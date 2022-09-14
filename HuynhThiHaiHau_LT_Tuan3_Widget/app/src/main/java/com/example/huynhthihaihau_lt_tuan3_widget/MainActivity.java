package com.example.huynhthihaihau_lt_tuan3_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    ImageButton ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int there = random.nextInt(number);

                //Kiểm tra con vật nào về đích trước thì chiến thắng (1) -> WIN ONE
                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "WIN ONE",Toast.LENGTH_SHORT).show();
                    //Kiểm tra có đặt cược không?
                    if (cbOne.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                //Kiểm tra con vật nào về đích trước thì chiến thắng (2) -> WIN TWO
                if (skTwo.getProgress() >= skTwo.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "WIN TWO",Toast.LENGTH_SHORT).show();
                    //Kiểm tra có đặt cược không?
                    if (cbTwo.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                //Kiểm tra con vật nào về đích trước thì chiến thắng (3) -> WIN THREE
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "WIN THREE",Toast.LENGTH_SHORT).show();
                    //Kiểm tra có đặt cược không?
                    if (cbThree.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + there);
            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "Bạn vui lòng đặt cược 1 trong 3 con vật trước khi bắt đầu trò chơi này nhé!!!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    //Bỏ checkbox 2,3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    //Bỏ checkbox 1,3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Bỏ checkbox 1,2
                cbOne.setChecked(false);
                cbTwo.setChecked(false);
            }
        });
    }

    private void EnableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void AnhXa(){
        txtDiem     = (TextView) findViewById(R.id.textviewDiemSo);
        ibtnPlay    = (ImageButton) findViewById(R.id.buttonPlay);
        cbOne       = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo       = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree     = (CheckBox) findViewById(R.id.checkboxThree);
        skOne       = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo       = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree     = (SeekBar) findViewById(R.id.seekbarThree);
    }
}