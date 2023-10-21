package com.example.cs2340c_team41.models;

public enum Bounds {
    INSIDE(0),
    LEFT_EDGE(1),
    RIGHT_EDGE(2);

    private final int value;

    Bounds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}