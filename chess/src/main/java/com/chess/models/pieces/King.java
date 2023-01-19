package com.chess.models.pieces;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.chess.common.Location;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public class King extends Piece {

    private Movable bishop;
    private Movable rook;

    public King(Color color) {
        super(color);
        this.name = "King";
    }

    public King(Color color, Movable bishop, Movable rook) {
        super(color);
        this.name = "King";
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();
        Location current = this.getSquare().getLocation();

        // Compose a list of valid moves for the king by combining the valid moves of
        // the

        candidates.addAll(bishop.getValidMoves(board, this.getSquare()));
        candidates.addAll(rook.getValidMoves(board, this.getSquare()));

        // Filters out all the moves that are not 1 square away
        return candidates.stream().filter(candidate -> {
            return Math.abs(candidate.getFile().ordinal() - current.getFile().ordinal()) == 1
                    && Math.abs(candidate.getRank() - current.getRank()) == 1;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        // TODO Auto-generated method stub
        return null;
    }

}
