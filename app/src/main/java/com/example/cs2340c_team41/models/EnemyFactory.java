package com.example.cs2340c_team41.models;

import android.graphics.Canvas;
import java.util.Random;

import java.util.Random;

public class EnemyFactory {
    double xBounds;
    double yBounds;
    Random random;

    double treeX, treeY, brickX, brickY, sandX, sandY, swordX, swordY;
    double treeEndingY, brickEndingY, sandEndingY, swordEndingY;
    int damage;

    public EnemyFactory(double xBounds, double yBounds, int difficulty) {
        this.xBounds = xBounds;
        this.yBounds = yBounds;
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
        treeY = 100 + (yBounds - 800) * random.nextDouble();
        treeEndingY = Math.min(treeY + (yBounds - 200) * random.nextDouble(), yBounds- 100);

        brickX = 300 + (xBounds - 300) * random.nextDouble();
        brickY = 100 + (yBounds - 800) * random.nextDouble();
        brickEndingY = Math.min(brickY + (yBounds - 200) * random.nextDouble(), yBounds- 100);

        sandX = 300 + (xBounds - 300) * random.nextDouble();
        sandY = 100 + (yBounds - 800) * random.nextDouble();
        sandEndingY = Math.min(sandY + (yBounds - 200) * random.nextDouble(), yBounds - 100);

        swordX = 300 + (xBounds - 300) * random.nextDouble();
        swordY = 100 + (yBounds - 800) * random.nextDouble();
        swordEndingY = Math.min(swordY + (yBounds - 200) * random.nextDouble(), yBounds- 100);
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

