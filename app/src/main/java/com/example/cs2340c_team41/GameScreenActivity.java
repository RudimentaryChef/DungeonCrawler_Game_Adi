package com.example.cs2340c_team41;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;


import android.os.Bundle;
import android.widget.TextView;

public class GameScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String PLAYER_NAME = intent.getStringExtra("name");
        String difficulty = intent.getStringExtra("difficulty");
        String sprite = intent.getStringExtra("character");
        int HP = 100;
        if (difficulty.equals("Easy")) {
            HP = 200;
        } else if (difficulty.equals("Hard")) {
            HP = 50;
        }
        TextView text;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        text = findViewById(R.id.player_name);
        text.setText(PLAYER_NAME);
        text = findViewById(R.id.player_hp);
        text.setText(String.format("HP: %s", HP));
        text = findViewById(R.id.player_difficulty);
        text.setText((String.format("Difficulty: %s", difficulty)));
        Button btn = (Button) findViewById(R.id.exitBtn);
        ImageView player_sprite = findViewById(R.id.player_sprite);
        if (sprite.equals("sprite_1")) {
            player_sprite.setImageResource(R.drawable.sprite_1);
        } else if (sprite.equals("sprite_2")) {
            player_sprite.setImageResource(R.drawable.sprite_2);
        } else {
            player_sprite.setImageResource(R.drawable.sprite_3);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnHome();
            }
        });
    }
    public void returnHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}