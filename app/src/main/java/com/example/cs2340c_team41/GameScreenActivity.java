package com.example.cs2340c_team41;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;


import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class GameScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sprite_1", R.drawable.sprite_1);
        map.put("sprite_2", R.drawable.sprite_2);
        map.put("sprite_3", R.drawable.sprite_3);
        Intent intent = getIntent();
        String playerName = intent.getStringExtra("name");
        String difficulty = intent.getStringExtra("difficulty");
        String sprite = intent.getStringExtra("character");
        int hp = 100;
        if (difficulty.equals("Easy")) {
            hp = 200;
        } else if (difficulty.equals("Hard")) {
            hp = 50;
        }
        TextView text;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        text = findViewById(R.id.player_name);
        text.setText(playerName);
        text = findViewById(R.id.player_hp);
        text.setText(String.format("HP: %s", hp));
        text = findViewById(R.id.player_difficulty);
        text.setText((String.format("Difficulty: %s", difficulty)));
        Button btn = (Button) findViewById(R.id.exitBtn);
        ImageView playerSprite = findViewById(R.id.player_sprite);
        playerSprite.setImageResource(map.get(sprite));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEndScreen();
            }
        });
    }
    public void goToEndScreen() {
        Intent intent = new Intent(this, EndScreenActivity.class);
        startActivity(intent);
    }
}