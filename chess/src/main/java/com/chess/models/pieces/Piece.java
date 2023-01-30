package com.chess.models.pieces;

import com.chess.common.Move;
import com.chess.models.game.Game;
import com.chess.models.squares.Square;

public abstract class Piece implements Movable {
    protected String name;
    protected Color color;
    protected Square square;
    protected String fenName;

    public Piece(Color color) {
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return this.square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public void makeMove(Square square) {
        Move move = new Move(this.getSquare().getLocation(), square.getLocation());
        this.getSquare().reset();
        this.setSquare(square);
        square.setPiece(this);
        square.setIsOccupied(true);
        Game.getBoard().addMove(move);
        Game.getBoard().setIsWhiteTurn(!Game.getBoard().getIsWhiteTurn());
        Game.getBoard().setMoveTally(Game.getBoard().getMoveTally() + 1);
    }

    public String getFenName() {
        return this.fenName;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", color='" + getColor() + "'" +
                ", square='" + getSquare() + "'" +
                "}";
    }

}
