package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void growDino (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Intent intent = new Intent(this, DinoChoice.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void yourWorld (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Intent intent = new Intent(this, Collection.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}