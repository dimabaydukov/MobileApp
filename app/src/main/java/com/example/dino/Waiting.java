package com.example.dino;

import android.content.Intent;
<<<<<<< Updated upstream
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
=======
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
>>>>>>> Stashed changes
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Waiting extends AppCompatActivity {

<<<<<<< Updated upstream
    Button stopHatchingButton;
    ProgressBar progressBar;
=======
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
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting);

<<<<<<< Updated upstream
        stopHatchingButton = findViewById(R.id.stopHatchingButton);
        progressBar = findViewById(R.id.progressBar);
=======
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
>>>>>>> Stashed changes
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Не отвлекайтесь! Ваш динозавтрик убежит " +
                "через 10 сек", Toast.LENGTH_LONG).show();
<<<<<<< Updated upstream
        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                StopHatching();
            }
        }.start();
=======
        stopTimer.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stopTimer.cancel();
>>>>>>> Stashed changes
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StopHatching();
    }

<<<<<<< Updated upstream
    protected void StopHatching(){
        //динозавтрик убежал
=======
    private void StopHatching(){
        //динозавтрик убежал
        mainTimer.cancel();
        Toast.makeText(getApplicationContext(), "Ваш динозавтрик убежал :( ",
                Toast.LENGTH_LONG).show();
>>>>>>> Stashed changes
        SwitchingToActivityMain();
    }

    public void SwitchingToActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
