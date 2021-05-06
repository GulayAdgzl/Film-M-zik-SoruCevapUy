package com.example.flmmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class OrtaActivity extends AppCompatActivity {

    DataHelper dataHelper;
    TextView sorularr,puann,filmoyun;
    ImageButton dogru,yanlis,anasayfa;

    Random r=new Random();
    int n;
    int points=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_orta);

        dataHelper=new DataHelper(this);

        sorularr=(TextView) findViewById(R.id.sorular);
        filmoyun=(TextView) findViewById(R.id.filmoyun);
        puann=(TextView) findViewById(R.id.puan);
        dogru=(ImageButton) findViewById(R.id.dogru);
        yanlis=(ImageButton) findViewById(R.id.yanlis);
        anasayfa=(ImageButton) findViewById(R.id.anasayfagit);

        anasayfa.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                startActivity (new Intent (OrtaActivity.this,MainActivity.class));
                finish ();
            }
        });


        filmoyun.setText(dataHelper.receiveDataString("İsim","GÜLAY-ADIGÜZEL"));

        //Sorular

        final String[] arrayQ={getString(R.string.o1),getString(R.string.o2),getString(R.string.o3)
                ,getString(R.string.o4),getString(R.string.o5)};
        final Boolean[] arrayA={false,false,false,false,true};

        final ArrayList<String> sorular=new ArrayList<String>(Arrays.asList(arrayQ));
        final  ArrayList<Boolean>cevaplar=new ArrayList<Boolean>(Arrays.asList(arrayA));

        n=r.nextInt(sorular.size());
        sorularr.setText(sorular.get(n));//Soruların karışık olmasını sağlar


        dogru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cevaplar.get(n)){
                    points++;
                    sorular.remove(n);
                    cevaplar.remove(n);
                    puann.setText("Skor"+points);
                    if(sorular.size() == 0) {
                        result();
                    }
                    else{
                        n=r.nextInt(sorular.size());
                        sorularr.setText(sorular.get(n));
                    }
                }
                else{
                    result();
                }
            }
            private void result() {
                dataHelper.saveDataInt("Puan Orta",points);
                startActivity(new Intent(OrtaActivity.this,
                        ResultActivity.class));
            }
        });


        yanlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cevaplar.get(n)){
                    points++;
                    sorular.remove(n);
                    cevaplar.remove(n);
                    puann.setText("Skor"+points);
                    if(sorular.size() == 0) {
                        result();
                    }
                    else{
                        n=r.nextInt(sorular.size());
                        sorularr.setText(sorular.get(n));
                    }
                }
                else{
                    result();
                }
            }
            private void result() {
                dataHelper.saveDataInt("Puan Orta",points);
                startActivity(new Intent(OrtaActivity.this,
                        ResultActivity.class));
            }

        });
    }
}