package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void growDino (View v){
        Intent intent = new Intent(this, DinoShopActivity.class);
        startActivity(intent);
    }

    public void yourWorld (View v){
        Intent intent = new Intent(this, YourWorld.class);
        startActivity(intent);
    }

}