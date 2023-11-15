package com.example.cs2340c_team41.models;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.content.Context;
/*
*   This is the enemy superclass,
*   Enemies have sprites, speed, damage, multipliers, and locaations (both starting and current)
*   They also have a direction they move un
*
 */
public class Enemy {
    private Integer sprite;
    private int speed;
    private int damage;
    private double damageMultiplier;
    private double x;
    private double startingY;
    private double endingY;
    private double y;
    private Direction direction;

    public Enemy(Integer sprite, int speed, double x, double y, double endingY, int damage,
                 double damageMultiplier) {
        this.sprite = sprite;
        this.speed = speed;
        this.x = x;
        this.startingY = y;
        this.endingY = endingY;
        this.damage = damage;
        this.damageMultiplier = damageMultiplier;
        this.y = y;
        direction = Direction.DOWN;
    }

    public boolean notify(double playerX, double playerY, Context context, Integer sprite) {
        Bitmap enemySprite = BitmapFactory.decodeResource(context.getResources(),
                this.sprite);
        Bitmap playerSprite = BitmapFactory.decodeResource(context.getResources(),
                sprite);
        if ((playerX + 50 >= x - 50
                && playerX - 50 <= x + 50)  && (playerY + 50 >= y - 50
                && playerY - 50 <= y + 50)) {
            return true;
        }
        return false;
    };

    public double attack() {
        return damage * damageMultiplier;
    }

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

    public void move() {
        checkBounds();
        if (direction == Direction.DOWN) {
            y += speed;
        } else if (direction == Direction.UP) {
            y -= speed;
        }
    }

    public void checkBounds() {
        if (y > endingY) {
            y -= speed;
            direction = Direction.UP;
        } else if (y < startingY) {
            y += speed;
            direction = Direction.DOWN;
        }
    }

    // Getter for sprite
    public Integer getSprite() {
        return sprite;
    }

    // Setter for sprite
    public void setSprite(Integer sprite) {
        this.sprite = sprite;
    }

    // Getter for speed
    public int getSpeed() {
        return speed;
    }

    // Setter for speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getter for x
    public double getX() {
        return x;
    }

    // Setter for x
    public void setX(double x) {
        this.x = x;
    }

    // Getter for y
    public double getY() {
        return y;
    }

    // Setter for y
    public void setY(double y) {
        this.y = y;
    }
}
