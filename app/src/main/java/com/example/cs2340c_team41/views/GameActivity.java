package com.example.cs2340c_team41.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;

import com.example.cs2340c_team41.models.Game;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        Intent intent = getIntent();
        String difficulty = intent.getStringExtra("difficulty");
        int hp = 100;
        if (difficulty.equals("Easy")) {
            hp = 200;
        } else if (difficulty.equals("Hard")) {
            hp = 50;
        }
        setContentView(new Game(this, intent.getStringExtra("sprite"),
                intent.getStringExtra("name"), hp));
    }
}