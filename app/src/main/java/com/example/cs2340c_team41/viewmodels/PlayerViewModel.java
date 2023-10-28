package com.example.cs2340c_team41.viewmodels;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.cs2340c_team41.models.Bounds;
import com.example.cs2340c_team41.R;
import com.example.cs2340c_team41.models.Player;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class PlayerViewModel extends ViewModel {
    private Player player;

    public PlayerViewModel(String playerName, int playerHealth, double xPosition, double yPosition,
                           int score, String sprite) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sprite_1", R.drawable.sprite_1);
        map.put("sprite_2", R.drawable.sprite_2);
        map.put("sprite_3", R.drawable.sprite_3);
        this.player = Player.getInstance(playerName, playerHealth, xPosition, yPosition, score,
                map.get(sprite));
    }

    public void draw(Context context, Canvas canvas) {
        Bitmap sprite = BitmapFactory.decodeResource(context.getResources(),
                player.getPlayerSprite());
        int width = sprite.getWidth();
        int height = sprite.getHeight();
        int newWidth = 200;
        sprite = Bitmap.createScaledBitmap(
                sprite, newWidth, height * newWidth / width, false);
        canvas.drawBitmap(sprite, (float) player.getX() - (float) sprite.getWidth() / 2,
                (float) player.getY() - (float) sprite.getHeight() / 2, null);
    }

    public void setSprite(String playerSprite) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sprite_1", R.drawable.sprite_1);
        map.put("sprite_2", R.drawable.sprite_2);
        map.put("sprite_3", R.drawable.sprite_3);
        this.player.setPlayerSprite(map.get(playerSprite));
    }

    public void positionPlayer(double xPosition, double yPosition) {
        this.player.setXLoc(xPosition);
        this.player.setYLoc(yPosition);
    }

    public void moveUp() {
        player.setYLoc(player.getY() - 10);
    }

    public void moveDown() {
        player.setYLoc(player.getY() + 10);
    }

    public void moveLeft() {
        player.setXLoc(player.getX() - 10);
    }

    public void moveRight() {
        player.setXLoc(player.getX() + 10);
    }

    public Bounds checkBounds(float x, float y) {
        if (player.getX() < 100) {
            moveRight();
            return Bounds.LEFT_EDGE;
        }
        if (player.getY() < 100) {
            moveDown();
        }
        if (player.getX() > x) {
            moveLeft();
            return Bounds.RIGHT_EDGE;
        }
        if (player.getY() > y) {
            moveUp();
        }
        return Bounds.INSIDE;
    }

    public void enterLeft() {
        player.setXLoc(100);
    }

    public void enterRight(float x) {
        player.setXLoc(x);
    }

    public double getX() {
        return player.getX();
    }

    public double getY() {
        return player.getY();
    }


}
