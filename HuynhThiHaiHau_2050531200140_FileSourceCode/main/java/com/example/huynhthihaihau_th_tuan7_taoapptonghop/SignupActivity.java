package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {
   DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText username = (EditText) findViewById(R.id.userName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.passWord);
        EditText repassword = (EditText) findViewById(R.id.repassWord);
        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbt);
        DB = new DBHelper(this);
        regbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                  String username1 = username.getText().toString();
                  String email1 = email.getText().toString();
                  String password1 = password.getText().toString();
                  String repassword1 = repassword.getText().toString();

                  if (username1.equals("") || email1.equals("") || password1.equals("") || repassword1.equals(""))
                        Toast.makeText(SignupActivity.this, "PLEASE ENTER ALL THE FIELDS!!!", Toast.LENGTH_SHORT).show();
                  else
                      if(password1.equals(repassword1)){
                          Boolean checkuser = DB.checkusername(username1);
                          if(checkuser ==false){
                              Boolean insert = DB.insertData(username1, password1);
                              if(insert == true){
                                  Toast.makeText(SignupActivity.this, "REGISTRATION SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                  Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                  startActivity(intent);

                              }
                              else{
                                  Toast.makeText(SignupActivity.this, "REGISTRATION FAILED!!!", Toast.LENGTH_SHORT).show();
                              }
                          }
                          else{
                              Toast.makeText(SignupActivity.this, "USER ALREADY EXISTS! PLEASE SIGN IN", Toast.LENGTH_SHORT).show();
                          }

                      }
                      else{
                          Toast.makeText(SignupActivity.this, "PASSWORD NOT MACHING", Toast.LENGTH_SHORT).show();

                      }
//               doOpenLoginActivity();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void doOpenLoginActivity()
    {
        Intent myIntent=new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
}