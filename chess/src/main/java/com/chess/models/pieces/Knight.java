package com.chess.models.pieces;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
        this.name = "Knight";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getSquare().getLocation();

        addValidMoves(candidates, squareMap, current, 2, 1);
        addValidMoves(candidates, squareMap, current, 2, -1);
        addValidMoves(candidates, squareMap, current, -2, 1);
        addValidMoves(candidates, squareMap, current, -2, -1);

        return candidates;
    }

    private void addValidMoves(List<Location> candidates, Map<Location, Square> squareMap, Location current,
            int fileOffset,
            int rankOffset) {
        Location next = LocationFactory.build(current, fileOffset, rankOffset);

        if (squareMap.containsKey(next)) {
            if (squareMap.get(next).getIsOccupied()) {
                if (squareMap.get(next).getPiece().color.equals(this.getColor())) {
                    return;
                }
                candidates.add(next);
                return;
            }
            candidates.add(next);
        }
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        // TODO Auto-generated method stub
        return null;
    }

}
