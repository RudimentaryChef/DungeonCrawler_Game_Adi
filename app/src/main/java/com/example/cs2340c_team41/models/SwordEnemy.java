package com.example.cs2340c_team41.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.cs2340c_team41.R;

import java.util.Random;

public class SwordEnemy extends Enemy {
    private Integer sprite;
    private int speed;
    private double x;
    private double y;

    public SwordEnemy(double x, double y) {
        super(R.drawable.enemy_2, 10, x, y);
    }

    @Override
    public void attack() {
        // BrickEnemy attack logic
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
