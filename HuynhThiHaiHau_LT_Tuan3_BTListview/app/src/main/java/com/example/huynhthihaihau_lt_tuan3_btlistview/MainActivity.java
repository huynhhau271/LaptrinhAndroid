package com.example.huynhthihaihau_lt_tuan3_btlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThem, btnCapNhat;

    EditText edtMonHoc;
    ArrayList<String> arrayCourse;

    int vitri = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        edtMonHoc = (EditText) findViewById(R.id.editTextMonHoc);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenDetailActivity();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenDetailActivity();
            }
        });

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("Python");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("Java");
        arrayCourse.add("ASP.Net");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                arrayCourse
        );
        lvMonHoc.setAdapter(adapter);

        //Chức năng Thêm:
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });

        //Cập nhật lại dữ liệu:
        //click vào sẽ đổ dữ liệu lên EditText "Nhập môn học: "
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMonHoc.setText(arrayCourse.get(position));
                vitri = position;

            }

        });

        //Chức năng cập nhật:
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = edtMonHoc.getText().toString();
                arrayCourse.set(vitri, t);
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");

            }
        });

        //Chức năng xóa:
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn vừa xóa: " + arrayCourse.get(position), Toast.LENGTH_SHORT).show();
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                doOpenDetailActivity();
                return false;
            }

        });

    }

    public void doOpenDetailActivity()
    {
        Intent myIntent=new Intent(this, DetailActivity.class);
        startActivity(myIntent);
    }
}