package com.chess.model;

public abstract class Piece {
    private String name;
    private boolean color;
    private int[] position;
    private int value;

    public Piece(String name, boolean color, int[] position) {
        this.name = name;
        this.color = color;
        this.position = position;
        this.value = getValue();
    }

    public String getName() {
        return name;
    }

    public boolean getColor() {
        return color;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] newPosition) {
        this.position = newPosition;
    }

    public abstract boolean isMoveValid(int[] newPosition);

    public abstract int getValue();
}
