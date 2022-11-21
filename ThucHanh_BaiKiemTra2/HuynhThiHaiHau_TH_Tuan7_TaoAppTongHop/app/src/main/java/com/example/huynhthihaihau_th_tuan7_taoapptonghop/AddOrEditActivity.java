package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huynhthihaihau_th_tuan7_taoapptonghop.sqlite.nhanvienDao;
import com.example.huynhthihaihau_th_tuan7_taoapptonghop.model.nhanvien;

public class AddOrEditActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtnvid,edtname,edtluong;
    private Button btnluu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit);
        edtnvid = findViewById(R.id.edtNvid);
        edtname = findViewById(R.id.edtNvName);
        edtluong = findViewById(R.id.edtNvLuong);

        btnluu= findViewById(R.id.btnluu);
        btnluu.setOnClickListener(this);
        findViewById(R.id.btnlistnv).setOnClickListener(this);

        ReadNhanVien();
    }
    private void ReadNhanVien(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle==null){
            return;
        }
        String id = bundle.getString("id");

        nhanvienDao dao = new nhanvienDao(this);
        nhanvien sv = dao.getById(id);

        edtnvid.setText(sv.getId());
        edtname.setText(sv.getName());
        edtluong.setText(""+ sv.getLuong());

        btnluu.setText("Chỉnh sửa");
    }
    //phương thuc nay co the goi su kien onclick cho cac button
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnluu:
                nhanvienDao dao = new nhanvienDao(this);
                nhanvien sv = new nhanvien();

                sv.setId(edtnvid.getText().toString());
                sv.setName(edtname.getText().toString());
                sv.setLuong(Float.parseFloat(edtluong.getText().toString()));
                //su dung chung 1 nut
                if(btnluu.getText().equals("Lưu")){//nếu nut luu hiển thị save thì thực hiện insert còn "update" thì thực hiện update
                    dao.insert(sv);
                }else {
                    dao.update(sv);
                }

                Toast.makeText(this, "Cay xanh moi da duoc luu!",
                        Toast.LENGTH_SHORT).show();
                break;

        }
    }
}