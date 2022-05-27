package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class DinoChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dino_choice);
    }

    public void goBack (View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow10 (View v){
        Dinosaurs dino = new Dinosaurs("name", "1", R.drawable.dino_one);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow20 (View v){
        Dinosaurs dino = new Dinosaurs("name", "2", R.drawable.dino_three);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow30 (View v){
        Dinosaurs dino = new Dinosaurs("name", "3", R.drawable.dino_four);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow40 (View v){
        Dinosaurs dino = new Dinosaurs("name", "4", R.drawable.dino_five);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow50 (View v){
        Dinosaurs dino = new Dinosaurs("name", "5", R.drawable.dino_six);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow60 (View v){
        Dinosaurs dino = new Dinosaurs("name", "6", R.drawable.dino_twoo);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}