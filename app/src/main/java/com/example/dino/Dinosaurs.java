package com.example.dino;

import android.widget.ImageView;

import java.io.Serializable;

public class Dinosaurs implements Serializable {
    private String name;
    private String time;
    private int img;

    public Dinosaurs(String name, String time, int img){
        this.name = name;
        this.time = time;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg() {
        return this.img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
