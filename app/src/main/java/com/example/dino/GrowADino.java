package com.example.dino;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class GrowADino extends AppCompatActivity {

    Button timeButton;
    TextView textViewGrow;
    ImageView imageView13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grow_a_dino);

        timeButton = findViewById(R.id.timeButton);
        textViewGrow = findViewById(R.id.textViewGrow);
        imageView13 = findViewById(R.id.imageView13);

        Bundle arguments = getIntent().getExtras();
        Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());
        String timeForTimer = dino.getTime();
        imageView13.setImageResource(dino.getImg());

        textViewGrow.setText(timeForTimer + " минут");
    }

    public void setTime(View v) {
        //установка времени и переход на waiting
        Bundle arguments = getIntent().getExtras();
        Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());

        Intent intent = new Intent(this, Waiting.class);
        intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void goBack (View v){
        Intent intent = new Intent(this, DinoChoice.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}