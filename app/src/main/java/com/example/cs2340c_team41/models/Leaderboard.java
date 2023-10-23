package com.example.cs2340c_team41.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private static Leaderboard leaderboard;
    private List<Attempt> topAttempts;
    private Attempt latestAttempt;

    private Leaderboard() {
        topAttempts = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public List<Attempt> getTopAttempts() {
        return topAttempts;
    }

    public void addAttempt(Attempt newAttempt) {
        this.latestAttempt = newAttempt;
        topAttempts.add(newAttempt);
        Collections.sort(topAttempts, Collections.reverseOrder());
        // Sort in descending order based on score

        // Keep only the top 5 attempts
        if (topAttempts.size() > 5) {
            topAttempts.subList(5, topAttempts.size()).clear();
        }
    }

    public String getLeaderboard() {
        StringBuilder leaderboardText = new StringBuilder();

        List<Attempt> topAttempts = Leaderboard.getInstance().getTopAttempts();

        for (Attempt attempt : topAttempts) {
            leaderboardText.append(attempt.getName()).append("   ")
                    .append(attempt.getScore()).append("   ")
                    .append(attempt.getTime()).append("\n");
        }

        return leaderboardText.toString();
    }

    public String getLatestAttempt() {
        StringBuilder res = new StringBuilder();
        res.append(this.latestAttempt.getName()).append("   ")
                .append(this.latestAttempt.getScore()).append("   ")
                .append(this.latestAttempt.getTime()).append("\n");
        return res.toString();
    }

    public void resetLeaderboard() {
        leaderboard = null;
    }
}
