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
    private static volatile Player instance;
    private Player(String name, int health, int x_loc, int y_loc, int score, ImageView playerSprite){
        this.name = name;
        this.health = health;
        this.x_loc = x_loc;
        this.y_loc = y_loc;
        this.score = score;
        this.playerSprite = playerSprite;

    }
    public static Player getInstance(String name, int health, int x_loc, int y_loc, int score, ImageView playerSprite){
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player(name, health, x_loc, y_loc, score, playerSprite);
                }
            }
        }
        return instance;
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
    public void setName(String nomen){
        this.name = nomen;
    }
    public void setHealth(int healthy){
        this.health = healthy;
    }
    public void setXLoc(int x){
        this.x_loc = x;
    }
    public void setYLoc(int y){
        this.y_loc = y;
    }
    public void setScore(int sco){
        this.score = sco;
    }

}
