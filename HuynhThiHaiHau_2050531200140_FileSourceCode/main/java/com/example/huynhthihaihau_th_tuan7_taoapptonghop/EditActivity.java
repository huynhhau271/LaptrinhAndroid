package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.huynhthihaihau_th_tuan7_taoapptonghop.sqlite.DBHelper1;
import com.example.huynhthihaihau_th_tuan7_taoapptonghop.sqlite.nhanvienDao;
import com.example.huynhthihaihau_th_tuan7_taoapptonghop.adapter.nhanvienAdapter;
import com.example.huynhthihaihau_th_tuan7_taoapptonghop.model.nhanvien;

import java.util.List;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private nhanvienAdapter NVadapter;
    private ListView lvnv;
    private String nhanvienid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase readableDatabase =dbHelper.getReadableDatabase();
        readableDatabase.close();
        //tim kiem thong tin tao giao dien
        lvnv =(ListView) findViewById(R.id.listViewNV);
        nhanvienDao dao = new nhanvienDao(this);
        List<nhanvien> list = dao.getAll();
        NVadapter = new nhanvienAdapter(this,list);
        lvnv.setAdapter(NVadapter);
        lvnv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nhanvien sv = list.get(i);
                nhanvienid= sv.getId();
            }
        });

        findViewById(R.id.btnedit).setOnClickListener(this);
        findViewById(R.id.btninsert).setOnClickListener(this);
        findViewById(R.id.btndelete).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,AddOrEditActivity.class);
        switch (view.getId()){
            case R.id.btninsert:
                //click nut edit chuyen trang addordedit
                startActivity(intent);
                break;
            case R.id.btnedit:
                if(nhanvienid==null){//ràng buộc điều kiện chọn id để thực hiện chỉnh sửa
                    Toast.makeText(this, "phai chon id cua nhan vien!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Bundle bundle= new Bundle();
                bundle.putString("id",nhanvienid);
                intent.putExtra("data",bundle);
                startActivity(intent);
                break;
            case R.id.btndelete:
                if(nhanvienid==null){
                    Toast.makeText(this, "phai chon id cua nhan vien!", Toast.LENGTH_SHORT).show();
                    return;//ket thuc doan lenh
                }

                nhanvienDao dao = new nhanvienDao(this);//tạo đoi tuong goi ham delete
                dao.delete(nhanvienid);
                nhanvienid = null;

                Toast.makeText(this, "Da xoa nhan vien!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}