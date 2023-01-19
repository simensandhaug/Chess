package com.chess.models.pieces;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.models.board.Board;
import com.chess.models.squares.Square;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
        this.name = "Rook";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getSquare().getLocation();

        // Get all possible moves in all four directions

        // Left
        getFileCandidates(candidates, squareMap, current, -1);

        // Right
        getFileCandidates(candidates, squareMap, current, 1);

        // Down
        getRankCandidates(candidates, squareMap, current, -1);

        // Up
        getRankCandidates(candidates, squareMap, current, 1);

        return candidates;
    }

    private void getFileCandidates(List<Location> candidates, Map<Location, Square> squareMap, Location current,
            int offset) {
        Location next = LocationFactory.build(current, offset, 0);

        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).getIsOccupied()) {
                if (squareMap.get(next).getPiece().color.equals(this.getColor())) {
                    break;
                }
                candidates.add(next);
                break;
            }
            candidates.add(next);
            next = LocationFactory.build(next, offset, 0);
        }
    }

    private void getRankCandidates(List<Location> candidates, Map<Location, Square> squareMap, Location current,
            int offset) {
        Location next = LocationFactory.build(current, 0, offset);

        while (squareMap.containsKey(next)) {
            if (squareMap.get(next).getIsOccupied()) {
                if (squareMap.get(next).getPiece().color.equals(this.getColor())) {
                    break;
                }
                candidates.add(next);
                break;
            }
            candidates.add(next);
            next = LocationFactory.build(next, 0, offset);
        }
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        List<Location> candidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = square.getLocation();

        // Get all possible moves in all four directions

        // Left
        getFileCandidates(candidates, squareMap, current, -1);

        // Right
        getFileCandidates(candidates, squareMap, current, 1);

        // Down
        getRankCandidates(candidates, squareMap, current, -1);

        // Up
        getRankCandidates(candidates, squareMap, current, 1);

        return candidates;
    }

}
