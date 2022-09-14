package com.example.huynhthihaihau_th_tuan4_taoluonggiaodien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Signup1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        EditText username = (EditText) findViewById(R.id.userName);
        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbt);
        regbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String usename1 = username.getText().toString();
                Toast.makeText(Signup1Activity.this, "Username is" + usename1, Toast.LENGTH_SHORT).show();
                doOpenMainActivity();
            }
        });
    }
    public void doOpenMainActivity()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}