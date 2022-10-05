package com.example.huynhthihaihau_lt_bt6_sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    MaterialButton btXacNhan;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = (TextView) findViewById(R.id.userName);
        TextView password = (TextView) findViewById(R.id.passWord);
        MaterialButton signup = (MaterialButton) findViewById(R.id.signupbt);
        setContentView(R.layout.activity_main);


        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "PROFILE OPEN!", Toast.LENGTH_SHORT).show();
                //doOpenSignupActivity();

            }
        });



        MaterialButton logninbtn = (MaterialButton) findViewById(R.id.loginbtn);
        logninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //thông báo đăng nhập thành công
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    //doOpenMainActivity();
                } else
                    //thông báo đăng nhập thất bại
                    Toast.makeText(MainActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public void doOpenMainActivity()
//    {
//        Intent myIntent=new Intent(this, MainActivity.class);
//        startActivity(myIntent);
//    }
//
//    public void doOpenSignupActivity()
//    {
//        Intent myIntent=new Intent(this, SignupActivity.class);
//        startActivity(myIntent);
//    }
}