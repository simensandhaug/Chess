package com.chess.models.pieces;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
        this.name = "Bishop";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getSquare().getLocation();

        // Get all possible moves in all four directions

        // Left and Down
        addValidMoves(candidates, squareMap, current, -1, -1);

        // Left and Up
        addValidMoves(candidates, squareMap, current, -1, 1);

        // Right and Down
        addValidMoves(candidates, squareMap, current, 1, -1);

        // Right and Up
        addValidMoves(candidates, squareMap, current, 1, 1);

        // Rank == up or down, File == left or right

        return candidates;
    }

    private void addValidMoves(List<Location> candidates, Map<Location, Square> squareMap, Location current,
            int fileOffset,
            int rankOffset) {
        Location next = LocationFactory.build(current, fileOffset, rankOffset);

        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).getIsOccupied()) {
                if (squareMap.get(next).getPiece().color.equals(this.getColor())) {
                    break;
                }
                candidates.add(next);
                break;
            }
            candidates.add(next);
            next = LocationFactory.build(next, fileOffset, rankOffset);
        }
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {

        List<Location> candidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = square.getLocation();

        // Get all possible moves in all four directions

        // Left and Down
        addValidMoves(candidates, squareMap, current, -1, -1);

        // Left and Up
        addValidMoves(candidates, squareMap, current, -1, 1);

        // Right and Down
        addValidMoves(candidates, squareMap, current, 1, -1);

        // Right and Up
        addValidMoves(candidates, squareMap, current, 1, 1);

        // Rank == up or down, File == left or right

        return candidates;
    }

}
