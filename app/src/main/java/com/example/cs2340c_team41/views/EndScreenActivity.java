package com.example.cs2340c_team41.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340c_team41.R;
import com.example.cs2340c_team41.models.Leaderboard;

public class EndScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        int gameStatus = getIntent().getIntExtra("status", 0);
        TextView statusContent = findViewById(R.id.statusContent);
        if (gameStatus == 1) {
            statusContent.setText("You won!");
        } else {
            statusContent.setText("You lost.");
        }
        Leaderboard leaderboard = Leaderboard.getInstance();
        TextView leaderboardContent = findViewById(R.id.leaderboardContent);
        leaderboardContent.setText(leaderboard.getLeaderboard());

        TextView latestAttempt = findViewById(R.id.latestAttemptContent);
        latestAttempt.setText(leaderboard.getLatestAttempt());

        Button btn = (Button) findViewById(R.id.restartBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStartScreen();
            }
        });

    }
    public void goToStartScreen() {
        Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
        System.out.println("Hello!");
        startActivity(intent);
    }
}