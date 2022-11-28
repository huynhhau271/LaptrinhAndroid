package com.example.huynhthihaihau_th_tuan7_taoapptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Intent intent = getIntent();
        TextView tvTitle = (TextView) findViewById(R.id.tv_dt_title);
        TextView tvDes =(TextView) findViewById(R.id.tv_dt_des);
        ImageView imageView = (ImageView) findViewById(R.id.iv_dt_ha);
        tvTitle.setText(intent.getStringExtra("title"));
        tvDes.setText(intent.getStringExtra("des"));
        imageView.setImageResource(intent.getIntExtra("image",R.id.imgHinh));

        EditText soA = (EditText) findViewById(R.id.editTextNumberA);
        EditText soB = (EditText) findViewById(R.id.editTextNumberB);
        Button tinh = (Button)  findViewById(R.id.btnTinh);
        TextView txtht = (TextView) findViewById(R.id.txthienthiKetqua);
        tinh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int soa = Integer.parseInt(soA.getText().toString());
                int sob = Integer.parseInt(soB.getText().toString());
                int result=0;
                switch (view.getId()){
                    case R.id.btnTinh:
                        result = soa + sob;
                        break;
                }
                txtht.setText(result + "");
            }
        });

//        @Override
//        public void onClick(View view) {
//            int soa = Integer.parseInt(soA.getText().toString());
//            int sob = Integer.parseInt(soB.getText().toString());
//            int result=0;
//            switch (view.getId()){
//                case R.id.btnTinh:
//                    result = soa + sob;
//                    break;
//            }
//            txtht.setText(result + "");
//        }



    }
}