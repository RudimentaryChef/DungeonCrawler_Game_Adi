package com.example.cs2340c_team41.models;

import java.util.Objects;

public class Attempt implements Comparable<Attempt> {
    private String name;
    private int score;
    private String time;

    public Attempt(String name, int score, String time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getTime() {
        return time;
    }

    @Override
    public int compareTo(Attempt other) {
        // Compare attempts based on score (in descending order)
        if (this.score < other.score) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attempt attempt = (Attempt) o;
        return Objects.equals(time, attempt.time); // Only compare time for equality
    }
}