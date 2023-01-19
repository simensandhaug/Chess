package com.chess.models;

public class Player {
    private String name;
    private boolean color;
    private int score;

    public Player(String name, boolean color) {
        this.name = name;
        this.color = color;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public boolean getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int capturedPieceValue) {
        score += capturedPieceValue;
    }
}
