package com.example.huynhthihaihau_lt_bt6_sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button logninbtn;
    EditText edtUsername, edtPassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);


        AnhXa();
        //Lấy giá trị
        edtUsername.setText(sharedPreferences.getString("TaiKhoan",""));
        edtPassword.setText(sharedPreferences.getString("MatKhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("Checked", false));


        logninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtusername = edtUsername.getText().toString().trim();
                String edtpassword = edtPassword.getText().toString().trim();
                if (edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")) {
                    //thông báo đăng nhập thành công
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    //nếu có checked
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("TaiKhoan", edtusername);
                        editor.putString("MatKhau", edtpassword);
                        editor.putBoolean("Checked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("TaiKhoan");
                        editor.remove("MatKhau");
                        editor.remove("Checked");
                        editor.commit();
                    }

                    //doOpenMainActivity();
                } else
                    //thông báo đăng nhập thất bại
                    Toast.makeText(MainActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void AnhXa() {
        logninbtn = (Button) findViewById(R.id.btlogin);
        edtUsername = (EditText) findViewById(R.id.userName);
        edtPassword = (EditText) findViewById(R.id.passWord);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);

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