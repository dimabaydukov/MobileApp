package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        Dinosaurs dino = new Dinosaurs("Green", "10", R.drawable.dino_10);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow20 (View v){
        Dinosaurs dino = new Dinosaurs("Red", "20", R.drawable.dino_20);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void grow30 (View v){
        Dinosaurs dino = new Dinosaurs("Dark blue", "30", R.drawable.dino_30);
        Intent intent = new Intent(this, GrowADino.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}