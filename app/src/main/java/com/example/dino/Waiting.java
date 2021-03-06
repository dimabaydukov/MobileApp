package com.example.dino;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class Waiting extends AppCompatActivity {

    MediaPlayer mPlayer;

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
                //?????????????????? ???????????????????????? ?? ????????????
                store = false;
                play();
                Bundle arguments = getIntent().getExtras();
                Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());
                Intent intent = new Intent(Waiting.this, Collection.class);
                intent.putExtra(Dinosaurs.class.getSimpleName(), dino);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                startActivity(intent);
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isInteractive();

        if(isScreenOn){
            if (store == true) {
                mPlayer = MediaPlayer.create(this, R.raw.toast);
                mPlayer.start();
                Toast.makeText(getApplicationContext(), "???? ????????????????????????! ?????? ???????????????????? ???????????? " +
                        "?????????? 10 ??????", Toast.LENGTH_LONG).show();
                stopTimer.start();
            }
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
        mPlayer = MediaPlayer.create(this, R.raw.stop);
        mPlayer.start();
        switchingToActivityMain();
    }

    public void stopHatching(){
        mPlayer = MediaPlayer.create(this, R.raw.toast);
        mPlayer.start();

        //?????????????????????? ????????????
        mainTimer.cancel();
        Toast.makeText(getApplicationContext(), "?????? ?????????????????????? ???????????? :( ",
                Toast.LENGTH_LONG).show();
    }

    public void switchingToActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void play(){
        mPlayer = MediaPlayer.create(this, R.raw.newdino);
        mPlayer.start();
    }
}