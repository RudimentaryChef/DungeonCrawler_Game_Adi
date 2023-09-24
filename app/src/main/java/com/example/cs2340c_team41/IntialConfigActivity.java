package com.example.cs2340c_team41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class IntialConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intial_config);

        //make buttons for changing difficulty
        Button rightBtnDiff = findViewById(R.id.rightButtonDiff);
        Button leftBtnDiff = findViewById(R.id.leftButtonDiff);

        //make buttons for changing character
        Button rightBtnChar = findViewById(R.id.rightButtonChar);
        Button leftBtnChar = findViewById(R.id.leftButtonChar);

        //makes button for starting the game
        Button startBtn = findViewById(R.id.startButton);

        //display the selected difficulty
        TextView diffTxt = findViewById(R.id.diffText);

        //display the selected character
        ImageView sprite = findViewById(R.id.charImage);

        //allow the textBox to store input name
        EditText nameBox = findViewById(R.id.nameTextbox);

        //track what difficulty and character is selected
        final int[] diffTracker = {1};
        final int[] charTracker = {1};

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
                    sprite.setImageResource(R.drawable.testsprite3);
                    charTracker[0] = 3;
                } else if (charTracker[0] == 2) {
                    sprite.setImageResource(R.drawable.testsprite1);
                    charTracker[0] = 1;
                } else {
                    sprite.setImageResource(R.drawable.testsprite2);
                    charTracker[0] = 2;
                }
            }
        });

        //selects character to the right
        rightBtnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (charTracker[0] == 1) {
                    sprite.setImageResource(R.drawable.testsprite2);
                    charTracker[0] = 2;
                } else if (charTracker[0] == 2) {
                    sprite.setImageResource(R.drawable.testsprite3);
                    charTracker[0] = 3;
                } else {
                    sprite.setImageResource(R.drawable.testsprite1);
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
                    //Intent game = new Intent(IntialConfigActivity.this, rishis.class);
                    //game.putExtra("name", nameBox.getText().toString());
                    //game.putExtra("difficulty", diffTracker[0]);
                    //game.putExtra("character", charTracker[0]);
                    //startActivity(game);
                }
            }
        });
    }
}