package com.example.dino;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Waiting extends AppCompatActivity {

    Button timeButton;
    ImageView imageView13;
    int timeForTimer;
    ProgressBar progressBar;
    int i = 0;
    boolean store = true;

    CountDownTimer mainTimer;

    CountDownTimer stopTimer = new CountDownTimer(10000, 1000){

        @Override
        public void onTick(long l) { }

        @Override
        public void onFinish() {
            if (store == true) {
                mainTimer.cancel();
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting);

        timeButton = findViewById(R.id.timeButton);
        imageView13 = findViewById(R.id.imageView13);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        imageView13.getLayoutParams().height = 250;

        Bundle arguments = getIntent().getExtras();
        Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());
        timeForTimer = parseInt(dino.getTime());

        imageView13.setImageResource(dino.getImg());

        mainTimer = new CountDownTimer(timeForTimer*60000, 2000) {
            @Override
            public void onTick(long l) {
                if (imageView13.getLayoutParams().height < 650) {
                    imageView13.getLayoutParams().height = imageView13.getLayoutParams().height + 1;
                    imageView13.setMinimumHeight(imageView13.getLayoutParams().height);
                }

                i++;
                progressBar.setProgress((int)i*100/(timeForTimer*30));
            }

            @Override
            public void onFinish() {
                //сохраняем динозавтрика в список
                store = false;
                Bundle arguments = getIntent().getExtras();
                Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());
                Intent intent = new Intent(Waiting.this, Collection.class);
                intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (store == true) {
            Toast.makeText(getApplicationContext(), "Не отвлекайтесь! Ваш динозавтрик убежит " +
                    "через 10 сек", Toast.LENGTH_LONG).show();
            stopTimer.start();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stopTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (store == true)
            stopHatching();
    }

    public void onClickBack(View v){
        switchingToActivityMain();
    }

    public void stopHatching(){
        //динозавтрик убежал
        mainTimer.cancel();
        Toast.makeText(getApplicationContext(), "Ваш динозавтрик убежал :( ",
                Toast.LENGTH_LONG).show();
    }

    public void switchingToActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}