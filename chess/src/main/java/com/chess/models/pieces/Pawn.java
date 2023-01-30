package com.chess.models.pieces;

import com.chess.models.board.Board;
import com.chess.models.squares.Square;
import com.chess.common.Location;
import com.chess.common.LocationFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends Piece {

    private boolean isFirstMove = true;

    public Pawn(Color color) {
        super(color);
        this.name = "Pawn";
        this.fenName = color == Color.WHITE ? "P" : "p";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> candidates = Collections.emptyList();

        Map<Location, Square> squareMap = board.getLocationSquareMap();

        Location current = this.getSquare().getLocation();

        // Forward moves

        // Forward 1
        candidates.add(LocationFactory.build(current, 0, 1));

        // Forward 2
        if (this.isFirstMove) {
            candidates.add(LocationFactory.build(current, 0, 2));
        }

        // Diagonal moves
        candidates.add(LocationFactory.build(current, 1, 1));
        candidates.add(LocationFactory.build(current, -1, 1));

        // FILTERING
        // Filters out moves that are not on the board (i.e. off the board)
        List<Location> validMoves = candidates.stream()
                .filter(squareMap::containsKey)
                .collect(Collectors.toList());

        // Filters out moves that are blocked by a piece of the same color
        return validMoves.stream().filter((candidate) -> {

            // Cant move forward if blocked by a piece
            if (candidate.getFile().equals(this.getSquare().getLocation().getFile()) &&
                    squareMap.get(candidate).getIsOccupied()) {
                return false;
            }

            // Cant move diagonally except if there is a piece of the opposite color
            return !squareMap.get(candidate).getPiece().color.equals(this.getColor());
        }).collect(Collectors.toList());
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        // TODO Auto-generated method stub
        return null;
    }

}
