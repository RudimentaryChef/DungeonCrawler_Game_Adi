package com.example.cs2340c_team41.models;

import android.graphics.Canvas;
import java.util.Random;

import java.util.Random;

public class EnemyFactory {
    double xBounds;
    double yBounds;
    Random random;

    double treeX, treeY, brickX, brickY, sandX, sandY, swordX, swordY;

    public EnemyFactory(double xBounds, double yBounds) {
        this.xBounds = xBounds;
        this.yBounds = yBounds;
        this.random = new Random();

        // Assigning random positions for each enemy type
        treeX = 100 + (xBounds - 200) * random.nextDouble();
        treeY = 100 + (yBounds - 500) * random.nextDouble();

        brickX = 100 + (xBounds - 200) * random.nextDouble();
        brickY = 100 + (yBounds - 500) * random.nextDouble();

        sandX = 100 + (xBounds - 200) * random.nextDouble();
        sandY = 100 + (yBounds - 500) * random.nextDouble();

        swordX = 100 + (xBounds - 200) * random.nextDouble();
        swordY = 100 + (yBounds - 500) * random.nextDouble();
    }

    public Enemy getEnemy(String enemyType) {
        if (enemyType == null) {
            return null;
        }

        if (enemyType.equalsIgnoreCase("TREE")) {
            return new TreeEnemy(treeX, treeY);
        } else if (enemyType.equalsIgnoreCase("BRICK")) {
            return new BrickEnemy(brickX, brickY);
        } else if (enemyType.equalsIgnoreCase("SAND")) {
            return new SandEnemy(sandX, sandY);
        } else if (enemyType.equalsIgnoreCase("SWORD")) {
            return new SwordEnemy(swordX, swordY);
        }
        return null;
    }
}

