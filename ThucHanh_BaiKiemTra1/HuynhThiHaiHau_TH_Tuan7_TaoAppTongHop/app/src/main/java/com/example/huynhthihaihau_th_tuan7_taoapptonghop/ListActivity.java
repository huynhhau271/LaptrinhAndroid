package com.example.huynhthihaihau_th_tuan7_taoapptonghop;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView lvMenu;
    ArrayList<Menu> arrayMenu;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        AnhXa();
        adapter = new MenuAdapter(this, R.layout.dong_menu, arrayMenu);

        lvMenu.setAdapter(adapter);


    }

    private void XacNhanXoa(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xóa nghệ danh này ra khỏi danh sách không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayMenu.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }


    private void AnhXa() {
        lvMenu = (ListView) findViewById(R.id.ListviewMenu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new Menu("Đinh Hương", "Ca sĩ - diễn viên","Việt Nam", R.drawable.dinhhuong));
        arrayMenu.add(new Menu("Ngô Kiến Huy", "MC - ca sĩ - diễn viên","Việt Nam", R.drawable.ngokienhuy));
        arrayMenu.add(new Menu("Mỹ Tâm", "Ca sĩ","Việt Nam", R.drawable.mytam));
        arrayMenu.add(new Menu("Jack", "Ca sĩ","Việt Nam", R.drawable.jack));
        arrayMenu.add(new Menu("Phạm Phương Thảo", "Ca sĩ - diễn viên","Việt Nam", R.drawable.phamphuongthao));
        arrayMenu.add(new Menu("Sơn Tùng", "Ca sĩ","Việt Nam", R.drawable.sontung));

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Menu fr = arrayMenu.get(i);
                doOpenMainActivity(fr.getTen(),fr.getMoTa(),fr.getHinh());
            }
        });
    }


    public void doOpenMainActivity(String ten, String mota, int hinh)
    {
        Intent myIntent;
        myIntent = new Intent( this, Detail.class);
        myIntent.putExtra("title",ten);
        myIntent.putExtra("des",mota);
        myIntent.putExtra("image",hinh);
        startActivity(myIntent);
    }


}