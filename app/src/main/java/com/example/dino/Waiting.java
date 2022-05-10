package com.example.dino;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Waiting extends AppCompatActivity {

    Button timeButton;
    ImageView imageView13;
    int maxHeight;
    int timeForTimer = 10;

    CountDownTimer mainTimer;

    CountDownTimer stopTimer = new CountDownTimer(10000, 1000){

        @Override
        public void onTick(long l) { }

        @Override
        public void onFinish() {
            StopHatching();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting);

        timeButton = findViewById(R.id.timeButton);
        imageView13 = findViewById(R.id.imageView13);
        maxHeight = imageView13.getHeight();
        imageView13.getLayoutParams().height = 250;

        mainTimer = new CountDownTimer(timeForTimer*60000, 1000) {
            @Override
            public void onTick(long l) {
                float change = 143/(timeForTimer*60000);
                while (imageView13.getHeight() < maxHeight){
                    imageView13.getLayoutParams().height += change;
                }
            }

            @Override
            public void onFinish() {
                //сохраняем динозавтрика в список
            }
        };

        mainTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Не отвлекайтесь! Ваш динозавтрик убежит " +
                "через 10 сек", Toast.LENGTH_LONG).show();
        stopTimer.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stopTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StopHatching();
    }

    private void StopHatching(){
        //динозавтрик убежал
        mainTimer.cancel();
        Toast.makeText(getApplicationContext(), "Ваш динозавтрик убежал :( ",
                Toast.LENGTH_LONG).show();
        SwitchingToActivityMain();
    }

    public void SwitchingToActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}


