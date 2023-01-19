package com.chess.models.pieces;

import java.util.List;

import com.chess.common.Location;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public interface Movable {
    List<Location> getValidMoves(Board board);

    List<Location> getValidMoves(Board board, Square square);

    void makeMove(Square square);
}
