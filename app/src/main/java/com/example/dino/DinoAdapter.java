package com.example.dino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DinoAdapter extends ArrayAdapter<Dinosaurs> {

    private LayoutInflater inflater;
    private int layout;
    private List<Dinosaurs> dinosaursList;

    public DinoAdapter(Context context, int resource, List<Dinosaurs> dinosaursList) {
        super(context, resource, dinosaursList);
        this.dinosaursList = dinosaursList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView imgView = (ImageView)view.findViewById(R.id.dinoImg);
        TextView nameView = (TextView)view.findViewById(R.id.dinoName);
        TextView timeView = (TextView)view.findViewById(R.id.dinoTime);

        Dinosaurs dino = dinosaursList.get(position);

        imgView.setImageResource(dino.getImg());
        nameView.setText(dino.getName());
        timeView.setText(dino.getTime());

        return view;
    }
}
