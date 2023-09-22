package com.example.cs2340c_team41;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;


import android.os.Bundle;
import android.widget.TextView;

public class GameScreenActivity extends AppCompatActivity {
    public String PLAYER_NAME = "Ethan";
    public int HP = 200;
    public String DIFFICULTY = "Medium";
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        text = findViewById(R.id.player_name);
        text.setText(PLAYER_NAME);
        text = findViewById(R.id.player_hp);
        text.setText(String.format("HP: %s", HP));
        text = findViewById(R.id.player_difficulty);
        text.setText((String.format("Difficulty: %s", DIFFICULTY)));
        Button btn = (Button) findViewById(R.id.exitBtn);
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