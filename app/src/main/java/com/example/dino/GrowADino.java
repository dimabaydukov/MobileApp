package com.example.dino;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< Updated upstream
import android.widget.SeekBar;
import android.widget.TextView;
=======
>>>>>>> Stashed changes

import androidx.appcompat.app.AppCompatActivity;

public class GrowADino extends AppCompatActivity {

    Button timeButton;
<<<<<<< Updated upstream
    TextView textViewForSeekBar;
    SeekBar seekBar;
=======
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grow_a_dino);

        timeButton = findViewById(R.id.timeButton);
<<<<<<< Updated upstream
        textViewForSeekBar = findViewById(R.id.textViewForSeekBar);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewForSeekBar.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
=======
>>>>>>> Stashed changes
    }

    public void setTime(View v) {
        //установка времени и переход на waiting
    }
}