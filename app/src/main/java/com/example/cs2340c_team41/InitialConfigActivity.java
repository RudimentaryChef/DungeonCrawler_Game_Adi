package com.example.cs2340c_team41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InitialConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config);

        //make buttons for changing difficulty
        ImageButton rightBtnDiff = findViewById(R.id.rightButtonDiff);
        ImageButton leftBtnDiff = findViewById(R.id.leftButtonDiff);

        //make buttons for changing character
        ImageButton rightBtnChar = findViewById(R.id.rightButtonChar);
        ImageButton leftBtnChar = findViewById(R.id.leftButtonChar);

        //makes button for starting the game
        Button startBtn = findViewById(R.id.startButton);

        //display the selected difficulty
        TextView diffTxt = findViewById(R.id.diffText);

        //display the selected character
        ImageView sprite = findViewById(R.id.character_image);

        //allow the textBox to store input name
        EditText nameBox = findViewById(R.id.nameTextbox);

        //track what difficulty and character is selected
        int[] diffTracker = {1};
        int[] charTracker = {1};

        //selects difficulty to the left
        leftBtnDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diffTracker[0] == 1) {
                    diffTxt.setText("Hard");
                    diffTracker[0] = 3;
                } else if (diffTracker[0] == 2) {
                    diffTxt.setText("Easy");
                    diffTracker[0] = 1;
                } else {
                    diffTxt.setText("Medium");
                    diffTracker[0] = 2;
                }
            }
        });

        //selects difficulty to the right
        rightBtnDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diffTracker[0] == 1) {
                    diffTxt.setText("Medium");
                    diffTracker[0] = 2;
                } else if (diffTracker[0] == 2) {
                    diffTxt.setText("Hard");
                    diffTracker[0] = 3;
                } else {
                    diffTxt.setText("Easy");
                    diffTracker[0] = 1;
                }
            }
        });

        //selects character to the left
        leftBtnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (charTracker[0] == 1) {
                    sprite.setImageResource(R.drawable.sprite_3);
                    charTracker[0] = 3;
                } else if (charTracker[0] == 2) {
                    sprite.setImageResource(R.drawable.sprite_1);
                    charTracker[0] = 1;
                } else {
                    sprite.setImageResource(R.drawable.sprite_2);
                    charTracker[0] = 2;
                }
            }
        });

        //selects character to the right
        rightBtnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (charTracker[0] == 1) {
                    sprite.setImageResource(R.drawable.sprite_2);
                    charTracker[0] = 2;
                } else if (charTracker[0] == 2) {
                    sprite.setImageResource(R.drawable.sprite_3);
                    charTracker[0] = 3;
                } else {
                    sprite.setImageResource(R.drawable.sprite_1);
                    charTracker[0] = 1;
                }
            }
        });

        //starts the game if name is not null
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameBox.getText() == null || nameBox.getText().toString().trim().isEmpty()) {
                    nameBox.setBackgroundColor(Color.rgb(255, 114, 118));
                } else {
//                    goToGameScreen();
                    Intent game = new Intent(getApplicationContext(), GameScreenActivity.class);
                    game.putExtra("name", nameBox.getText().toString());
                    String difficultyText = "";
                    if (diffTracker[0] == 1) {
                        difficultyText = "Easy";
                    } else if (diffTracker[0] == 2) {
                        difficultyText = "Medium";
                    } else {
                        difficultyText = "Hard";
                    }
                    game.putExtra("difficulty", difficultyText);
                    String character = "sprite_2";
                    if (charTracker[0] == 1) {
                        character = "sprite_1";
                    } else if (charTracker[0] == 3) {
                        character = "sprite_3";
                    }
                    game.putExtra("character", character);
                    startActivity(game);
                }
            }
        });
    }
    public void goToGameScreen(){
        Intent intent = new Intent(this, GameScreenActivity.class);
        startActivity(intent);
    }
}