package com.example.flmmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    DataHelper dataHelper;
    TextView tv;
    Button anasay;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_result);
        dataHelper=new DataHelper(this);
        tv=(TextView) findViewById(R.id.tv_user);
        anasay=(Button) findViewById(R.id.home);
        tv.setText("İyi Şanslar bir dahaki sefere,  "+dataHelper.receiveDataString ("İsim","GÜLAY-ADIGÜZEL"));

        anasay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (ResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}