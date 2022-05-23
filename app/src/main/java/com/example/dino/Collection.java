package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Collection extends AppCompatActivity {

    static ListView dinoCollection;
    static ArrayList<Dinosaurs> dinosaurs = new ArrayList<Dinosaurs>();
    DinoAdapter dinoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);

        dinoCollection=(ListView) findViewById(R.id.dinoCollection);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addDino();
    }

    private void addDino(){
        dinoAdapter = new DinoAdapter(this, R.layout.list_with_dino, dinosaurs);
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null) {
            Dinosaurs dino = (Dinosaurs) arguments.getSerializable(Dinosaurs.class.getSimpleName());
            dinoAdapter.add(dino);
        };

        dinoCollection.setAdapter(dinoAdapter);
    }

    public void goBack (View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}