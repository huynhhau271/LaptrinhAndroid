package com.example.huynhthihaihau_th_tuan5_taolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMenu;
    ArrayList <Menu> arrayMenu;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new MenuAdapter(this, R.layout.dong_menu,arrayMenu);

        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn vừa xóa: " + arrayMenu.get(position), Toast.LENGTH_SHORT).show();
                arrayMenu.remove(position);
                adapter.notifyDataSetChanged();
                //doOpenDetailActivity();
                return false;
            }

        });

    }

    private void AnhXa(){
        lvMenu = (ListView) findViewById(R.id.ListviewMenu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new Menu("Phở Hà Nội","Tinh hoa ẩm thực đất Bắc",R.drawable.phohanoi));
        arrayMenu.add(new Menu("Bò bít tết","Bò bít tết ngon tuyệt",R.drawable.bobittet));
        arrayMenu.add(new Menu("Salat","Món ăn kiểu Pháp",R.drawable.salat));
        arrayMenu.add(new Menu("Pizza","Thức ăn nhanh - đơn giản",R.drawable.pizza));
        arrayMenu.add(new Menu("Thịt nướng","Đặc sản thịt nướng mè",R.drawable.thitnuong));
        arrayMenu.add(new Menu("Sushi","Sushi cá hồi",R.drawable.sushi));
    }

    /*public void doOpenDetailActivity()
    {
        Intent myIntent=new Intent(this, DetailActivity.class);
        startActivity(myIntent);
    }*/

}