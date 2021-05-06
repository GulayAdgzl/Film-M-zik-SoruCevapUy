package com.example.flmmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity {


    private ImageButton btnPlay,btnpause,btnstop;
    MediaPlayer player;
    Button anasay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_music);
        btnPlay=findViewById (R.id.btnPlay);
        btnpause=findViewById (R.id.btnpause);
        btnstop=findViewById (R.id.btnstop);
        anasay=(Button) findViewById(R.id.home);


        anasay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MusicActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    public void play(View view){

        if (player == null) {
            player = MediaPlayer.create (this, R.raw.film);
            player.setOnCompletionListener (new MediaPlayer.OnCompletionListener () {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer ();
                }
            });

        }
        player.start ();
    }
    public  void pause(View view){
        if(player!=null){
            player.pause ();
        }
    }
    public  void stop(View view){
        stopPlayer ();
    }

    public  void stopPlayer(){
        player.release ();
        player=null;
        Toast.makeText (this, "Media Player Released", Toast.LENGTH_SHORT).show ();
    }

    @Override
    protected void onStop() {
        super.onStop ();
        stopPlayer ();
    }
}





