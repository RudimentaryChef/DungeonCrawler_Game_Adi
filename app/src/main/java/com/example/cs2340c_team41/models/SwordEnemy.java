package com.example.cs2340c_team41.models;

import com.example.cs2340c_team41.R;


public class SwordEnemy extends Enemy {
    private Integer sprite;
    private int speed;
    private double x;
    private double y;

    public SwordEnemy(double x, double y, double endingY, int damage) {
        super(R.drawable.enemy_2, 10, x, y, endingY, damage, 1.2);
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
