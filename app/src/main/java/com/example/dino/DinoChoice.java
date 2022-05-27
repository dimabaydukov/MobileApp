package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class DinoChoice extends AppCompatActivity {

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dino_choice);
    }

    public void goBack (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow10 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "10", R.drawable.onedino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow20 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "20", R.drawable.threeedino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow30 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "30", R.drawable.fourdino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow40 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "40", R.drawable.fiveedino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow50 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "50", R.drawable.sixdino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow60 (View v){
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Dinosaurs dino = new Dinosaurs("name", "60", R.drawable.twodino);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}