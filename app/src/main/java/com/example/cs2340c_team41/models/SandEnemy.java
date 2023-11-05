package com.example.cs2340c_team41.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.Random;

import com.example.cs2340c_team41.R;

public class SandEnemy extends Enemy {
    private Integer sprite;
    private int speed;
    private double x;
    private double y;

    public SandEnemy(double x, double y, double endingY, int damage) {
        super(R.drawable.enemy_4, 5, x, y, endingY, damage, 1.6);
    }


    // Getters
    public Integer getSprite() {
        return sprite;
    }
    public int getSpeed() {
        return speed;
    }

    // Setters
    public void setSprite(Integer sprite) {
        this.sprite = sprite;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
