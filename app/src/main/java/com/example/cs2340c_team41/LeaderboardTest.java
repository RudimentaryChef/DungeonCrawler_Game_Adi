package com.example.cs2340c_team41;

import org.junit.Before;
import org.junit.Test;
import com.example.cs2340c_team41.models.Leaderboard;
import com.example.cs2340c_team41.models.Attempt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeaderboardTest {

    private Leaderboard leaderboard;
    private Attempt attempt1;
    private Attempt attempt2;
    private Attempt attempt3;
    private Attempt attempt4;
    private Attempt attempt5;

    @Before
    public void setUp() {
        // Create some sample attempts for testing
        leaderboard = Leaderboard.getInstance();

        attempt1 = new Attempt("Player1", 100, "4:55PM");
        attempt2 = new Attempt("Player2", 200, "5:30PM");
        attempt3 = new Attempt("Player3", 150, "4:45PM");
        attempt4 = new Attempt("Player4", 300, "6:00PM");
        attempt5 = new Attempt("Player5", 250, "5:45PM");
    }

    @Test
    public void testAddAttempt() {
        leaderboard.resetLeaderboard();
        leaderboard = Leaderboard.getInstance();
        leaderboard.addAttempt(attempt1);
        assertEquals(attempt1, leaderboard.getTopAttempts().get(0));

        leaderboard.addAttempt(attempt2);
        assertEquals(attempt2, leaderboard.getTopAttempts().get(0));
        assertEquals(attempt1, leaderboard.getTopAttempts().get(1));
    }

    @Test
    public void testGetLeaderboard() {
        leaderboard.resetLeaderboard();
        leaderboard = Leaderboard.getInstance();
        leaderboard.addAttempt(attempt1);
        leaderboard.addAttempt(attempt2);
        leaderboard.addAttempt(attempt3);

        String expectedLeaderboard = "Player2   200   5:30PM\n" +
                "Player3   150   4:45PM\n" +
                "Player1   100   4:55PM\n";

        assertEquals(expectedLeaderboard, leaderboard.getLeaderboard());
    }

    @Test
    public void testGetLatestAttempt() {
        leaderboard.resetLeaderboard();
        leaderboard = Leaderboard.getInstance();
        leaderboard.addAttempt(attempt1);
        leaderboard.addAttempt(attempt2);

        String expectedLatestAttempt = "Player2   200   5:30PM\n";
        assertEquals(expectedLatestAttempt, leaderboard.getLatestAttempt());
    }
}