package com.example.cs2340c_team41.models;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GameButton {
    private Bitmap button;
    private float buttonX;
    private float buttonY;

    // Constructor
    public GameButton(Bitmap button) {
        this.button = button;
        this.buttonX = 0;
        this.buttonY = 0;
    }

    // Getter for button
    public Bitmap getButton() {
        return button;
    }

    // Setter for button
    public void setButton(Bitmap button) {
        this.button = button;
    }

    // Getter for buttonX
    public float getButtonX() {
        return buttonX;
    }

    // Setter for buttonX
    public void setButtonX(float buttonX) {
        this.buttonX = buttonX;
    }

    // Getter for buttonY
    public float getButtonY() {
        return buttonY;
    }

    // Setter for buttonY
    public void setButtonY(float buttonY) {
        this.buttonY = buttonY;
    }

    public int getWidth() {
        return this.button.getWidth();
    }

    public int getHeight() {
        return this.button.getWidth();
    }

    public void draw(Canvas canvas, float x, float y) {
        buttonX = x - (float) button.getWidth() / 2;
        buttonY = y - (float) button.getHeight() / 2;
        canvas.drawBitmap(button, buttonX,
                buttonY, null);
    }
}
