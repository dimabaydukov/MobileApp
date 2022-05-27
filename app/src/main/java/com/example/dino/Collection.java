package com.example.dino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Collection extends AppCompatActivity implements Serializable {

    static ListView dinoCollection;
    static ArrayList<Dinosaurs> dinosaurs = new ArrayList<Dinosaurs>();
    DinoAdapter dinoAdapter;

    MediaPlayer mPlayer;

    File myFile= new File(Environment.getExternalStorageDirectory(), "/newFile");

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void save() throws IOException {
        verifyStoragePermissions(this);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile)))
        {
            oos.writeObject(dinosaurs);
            System.out.println("Динозавры сохранились");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void load() throws IOException, ClassNotFoundException {
        verifyStoragePermissions(this);
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile)))
        {
            ArrayList<Dinosaurs> newdinosaurs=(ArrayList<Dinosaurs>)ois.readObject();
            dinosaurs = newdinosaurs;
            System.out.println("Динозавры загрузились");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        verifyStoragePermissions(this);
        System.out.println("hi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection);
        try {
            load();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        mPlayer = MediaPlayer.create(this, R.raw.press);
        mPlayer.start();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}