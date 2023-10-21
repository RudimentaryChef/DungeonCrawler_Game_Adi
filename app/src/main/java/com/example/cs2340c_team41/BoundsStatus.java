package com.example.cs2340c_team41;

public enum BoundsStatus {
    INSIDE(0),
    LEFT_EDGE(1),
    RIGHT_EDGE(2);

    private final int value;

    BoundsStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}