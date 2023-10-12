package com.example.cs2340c_team41;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team41.models.Player;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = Player.getInstance("John", 100, 10.0, 20.0, 0, 1);
    }

    @Test
    public void testGetName() {
        assertEquals("John", player.getName());
    }

    @Test
    public void testGetX() {
        assertEquals(10.0, player.getX(), 0.001); // Use delta for double comparison
    }

    @Test
    public void testGetY() {
        assertEquals(20.0, player.getY(), 0.001);
    }

    @Test
    public void testGetScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void testGetPlayerSprite() {
        assertEquals(Integer.valueOf(1), player.getPlayerSprite());
    }

    @Test
    public void testSetName() {
        player.setName("Alice");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testSetHealth() {
        player.setHealth(80);
        assertEquals(80, player.getHealth());
    }

    @Test
    public void testSetXLoc() {
        player.setXLoc(15.0);
        assertEquals(15.0, player.getX(), 0.001);
    }

    @Test
    public void testSetYLoc() {
        player.setYLoc(25.0);
        assertEquals(25.0, player.getY(), 0.001);
    }

    @Test
    public void testSetScore() {
        player.setScore(50);
        assertEquals(50, player.getScore());
    }

    @Test
    public void testSetPlayerSprite() {
        player.setPlayerSprite(2);
        assertEquals(Integer.valueOf(2), player.getPlayerSprite());
    }
}