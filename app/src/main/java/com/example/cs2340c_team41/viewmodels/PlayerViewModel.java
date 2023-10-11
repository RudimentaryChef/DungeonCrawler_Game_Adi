package com.example.cs2340c_team41.viewmodels;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340c_team41.R;
import com.example.cs2340c_team41.model.Player;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class PlayerViewModel extends ViewModel {
    private Player player;

    public PlayerViewModel(Context context, String playerName, int playerHealth, double xPosition, double yPosition, int score, String sprite) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sprite_1", R.drawable.sprite_1);
        map.put("sprite_2", R.drawable.sprite_2);
        map.put("sprite_3", R.drawable.sprite_3);
        this.player = Player.getInstance(playerName, playerHealth, xPosition, yPosition, score, map.get(sprite));
    }

    public void draw(Context context, Canvas canvas) {
        Bitmap sprite = BitmapFactory.decodeResource(context.getResources(), player.getPlayerSprite());
        int width = sprite.getWidth();
        int height = sprite.getHeight();
        int newWidth = 200;
        sprite = Bitmap.createScaledBitmap(
                sprite, newWidth, height * newWidth / width, false);
        canvas.drawBitmap(sprite, (float) player.getX() - (float) sprite.getWidth() / 2,
                (float) player.getY() - (float) sprite.getHeight() / 2, null);
    }

    public void positionPlayer(double xPosition, double yPosition) {
        this.player.setXLoc(xPosition);
        this.player.setYLoc(yPosition);
    }


}
