package com.example.cs2340c_team41.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.example.cs2340c_team41.R;
import com.example.cs2340c_team41.views.InitialConfigActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button closeApplicationBtn = findViewById(R.id.exit);
        Button startApplicationBtn = findViewById(R.id.start);
        closeApplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        startApplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConfigScreen();
            }
        });
    }
    public void goToConfigScreen() {
        Intent intent = new Intent(this, InitialConfigActivity.class);
        startActivity(intent);
    }
}