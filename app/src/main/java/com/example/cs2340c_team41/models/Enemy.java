package com.example.cs2340c_team41.models;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.content.Context;
import java.util.Random;

import com.example.cs2340c_team41.R;

import java.util.Random;

public class Enemy {
    private Integer sprite;
    private int speed;
    private double x;
    private double y;

    public Enemy(Integer sprite, int speed, double x, double y) {
        this.sprite = sprite;
        this.speed = speed;
        Random random = new Random();
        this.x = x;
        this.y = y;
    }

    void attack() {};

    public void draw(Context context, Canvas canvas) {
        Bitmap sprite = BitmapFactory.decodeResource(context.getResources(),
                this.sprite);
        int width = sprite.getWidth();
        int height = sprite.getHeight();
        int newWidth = 200;
        sprite = Bitmap.createScaledBitmap(
                sprite, newWidth, height * newWidth / width, false);
        canvas.drawBitmap(sprite, (float) x - (float) sprite.getWidth() / 2,
                (float) y - (float) sprite.getHeight() / 2, null);
    }
}
