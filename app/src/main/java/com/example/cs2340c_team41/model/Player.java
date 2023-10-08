package com.example.cs2340c_team41.model;
import android.media.Image;
import android.widget.ImageView;
public class Player {
    private String name;
    private int health;
    private int x_loc;
    private int y_loc;
    private int score;
    ImageView playerSprite;
    public Player(String name, int health, int x_loc, int y_loc, int score, ImageView playerSprite){
        this.name = name;
        this.health = health;
        this.x_loc = x_loc;
        this.y_loc = y_loc;
        this.score = score;
        this.playerSprite = this.playerSprite;

    }
    public String getName(){
        return this.name;
    }
    public int getHealth(){
        return this.health;
    }
    public int getXloc(){
        return this.x_loc;
    }
    public int getYloc(){
        return this.y_loc;
    }
    public int getScore(){
        return this.score;
    }
    public ImageView getPlayerSprite(){
        return this.playerSprite;
    }

}
