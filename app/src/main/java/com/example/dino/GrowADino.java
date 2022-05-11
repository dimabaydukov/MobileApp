package com.example.dino;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class GrowADino extends AppCompatActivity {

    Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grow_a_dino);

        timeButton = findViewById(R.id.timeButton);
    }

    public void setTime(View v) {
        //установка времени и переход на waiting
    }
}