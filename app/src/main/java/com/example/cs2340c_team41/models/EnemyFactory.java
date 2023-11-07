package com.example.cs2340c_team41.models;

import java.util.Random;

public class EnemyFactory {
    private Random random;

    private double treeX;
    private double treeY;
    private double brickX;
    private double brickY;
    private double sandX;
    private double sandY;
    private double swordX;
    private double swordY;
    private double treeEndingY;
    private double brickEndingY;
    private double sandEndingY;
    private double swordEndingY;
    private int damage;

    public EnemyFactory(double xBounds, double yBounds, int difficulty) {
        this.random = new Random();
        if (difficulty == 0) {
            damage = 5;
        } else if (difficulty == 1) {
            damage = 10;
        } else if (difficulty == 2) {
            damage = 15;
        }

        // Assigning random positions for each enemy type
        treeX = 300 + (xBounds - 300) * random.nextDouble();
        treeY = 400 + (yBounds - 800) * random.nextDouble();
        treeEndingY = Math.min(treeY + (yBounds - 200) * random.nextDouble(), yBounds - 100);

        brickX = 300 + (xBounds - 300) * random.nextDouble();
        brickY = 400 + (yBounds - 800) * random.nextDouble();
        brickEndingY = Math.min(brickY + (yBounds - 200) * random.nextDouble(), yBounds - 100);

        sandX = 300 + (xBounds - 300) * random.nextDouble();
        sandY = 400 + (yBounds - 800) * random.nextDouble();
        sandEndingY = Math.min(sandY + (yBounds - 200) * random.nextDouble(), yBounds - 100);

        swordX = 300 + (xBounds - 300) * random.nextDouble();
        swordY = 400 + (yBounds - 800) * random.nextDouble();
        swordEndingY = Math.min(swordY + (yBounds - 200) * random.nextDouble(), yBounds - 100);
    }

    public Enemy getEnemy(String enemyType) {
        if (enemyType == null) {
            return null;
        }

        if (enemyType.equalsIgnoreCase("TREE")) {
            return new TreeEnemy(treeX, treeY, treeEndingY, damage);
        } else if (enemyType.equalsIgnoreCase("BRICK")) {
            return new BrickEnemy(brickX, brickY, brickEndingY, damage);
        } else if (enemyType.equalsIgnoreCase("SAND")) {
            return new SandEnemy(sandX, sandY, sandEndingY, damage);
        } else if (enemyType.equalsIgnoreCase("SWORD")) {
            return new SwordEnemy(swordX, swordY, swordEndingY, damage);
        }
        return null;
    }
}

