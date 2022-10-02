package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Profile = (Button) findViewById(R.id.btProfile);
        Button Listview = (Button) findViewById(R.id.btListview);

        Listview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "LISTVIEW OPEN!", Toast.LENGTH_SHORT).show();
                doOpenListviewActivity();
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "PROFILE OPEN!", Toast.LENGTH_SHORT).show();
                doOpenProfileActivity();
            }
        });

    }
    public void doOpenProfileActivity()
    {
        Intent myIntent=new Intent(this, ProfileActivity.class);
        startActivity(myIntent);
    }

    public void doOpenListviewActivity()
    {
        Intent myIntent=new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }
}