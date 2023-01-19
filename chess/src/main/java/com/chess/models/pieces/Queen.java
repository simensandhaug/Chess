package com.chess.models.pieces;

import java.util.Collections;
import java.util.List;

import com.chess.common.Location;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public class Queen extends Piece {

    private Movable bishop;
    private Movable rook;

    public Queen(Color color) {
        super(color);
        this.name = "Queen";
    }

    public Queen(Color color, Movable bishop, Movable rook) {
        super(color);
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();

        // Compose a list of valid moves for the queen by combining the valid moves of
        // the bishop and rook

        candidates.addAll(bishop.getValidMoves(board, this.getSquare()));
        candidates.addAll(rook.getValidMoves(board, this.getSquare()));

        return candidates;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        // TODO Auto-generated method stub
        return null;
    }

}
