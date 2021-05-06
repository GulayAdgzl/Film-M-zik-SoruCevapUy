package com.example.flmmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout Kolay,Orta,Zor,btnMusic;
    TextView isim;
    ImageView isimduz;
    DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Kolay=(RelativeLayout) findViewById(R.id.Kolay);
        Orta=(RelativeLayout) findViewById(R.id.Orta);
        Zor=(RelativeLayout) findViewById(R.id.Zor);
        btnMusic=(RelativeLayout)findViewById (R.id.music);
        isimduz=(ImageView) findViewById(R.id.kadi_duzenle);
        isim=(TextView) findViewById(R.id.kullaniciadi);
        btnMusic.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this,MusicActivity.class));
            }
        });

        Kolay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this,KolayActivity.class));
            }
        });

        Orta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,OrtaActivity.class));
            }
        });

        Zor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ZorActivity.class));
            }
        });

    }
    }



