package com.example.cs2340c_team41.model;

public class Player {
    private String name;
    private int health;
    private double xPosition;
    private double yPosition;
    private int score;
    private Integer playerSprite;
    private static volatile Player instance;
    private Player(String name, int health, double xPosition, double yPosition, int score, Integer
            playerSprite) {
        this.name = name;
        this.health = health;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.score = score;
        this.playerSprite = playerSprite;
    }
    public static Player getInstance(String name, int health, double xPosition, double yPosition,
                                     int score, Integer playerSprite) {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player(name, health, xPosition, yPosition, score, playerSprite);
                }
            }
        }
        return instance;
    }

    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public double getX() {
        return this.xPosition;
    }
    public double getY() {
        return this.yPosition;
    }
    public int getScore() {
        return this.score;
    }
    public Integer getPlayerSprite() {
        return this.playerSprite;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setXLoc(double x) {
        this.xPosition = x;
    }
    public void setYLoc(double y) {
        this.yPosition = y;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
