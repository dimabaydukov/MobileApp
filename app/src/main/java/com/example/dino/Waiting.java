package com.example.dino;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Waiting extends AppCompatActivity {

    Button stopHatchingButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting);

        stopHatchingButton = findViewById(R.id.stopHatchingButton);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Не отвлекайтесь! Ваш динозавтрик убежит " +
                "через 10 сек", Toast.LENGTH_LONG).show();
        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                StopHatching();
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StopHatching();
    }

    protected void StopHatching(){
        //динозавтрик убежал
        SwitchingToActivityMain();
    }

    public void SwitchingToActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
