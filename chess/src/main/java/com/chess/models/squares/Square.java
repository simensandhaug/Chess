package com.chess.models.squares;

import com.chess.common.Location;
import com.chess.models.pieces.Piece;

public class Square {
    private final SquareColor squareColor;
    private final Location location;
    private boolean isOccupied;
    private Piece piece;

    public Square(SquareColor squareColor, Location location) {
        this.squareColor = squareColor;
        this.location = location;
        this.isOccupied = false;
    }

    public void reset() {
        this.isOccupied = false;
        this.piece = null;
    }

    public SquareColor getSquareColor() {
        return this.squareColor;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean getIsOccupied() {
        return this.isOccupied;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public String toString() {
        return "{" +
                " squareColor='" + getSquareColor() + "'" +
                ", location='" + getLocation() + "'" +
                ", isOccupied='" + getIsOccupied() + "'" +
                "}";
    }

}
