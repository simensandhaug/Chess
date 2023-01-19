package com.chess.models.pieces;

import java.util.HashMap;
import java.util.Map;

import com.chess.common.File;
import com.chess.common.Location;

public final class PieceFactory {
    private PieceFactory() {
    }

    public static Map<Location, Piece> getPieces() {
        Map<Location, Piece> pieces = new HashMap<>();

        // TODO: Implement FEN notation

        // Rooks
        pieces.put(new Location(File.A, 1), new Rook(Color.WHITE));
        pieces.put(new Location(File.H, 1), new Rook(Color.WHITE));
        pieces.put(new Location(File.A, 8), new Rook(Color.BLACK));
        pieces.put(new Location(File.H, 8), new Rook(Color.BLACK));

        // Knights
        pieces.put(new Location(File.B, 1), new Knight(Color.WHITE));
        pieces.put(new Location(File.G, 1), new Knight(Color.WHITE));
        pieces.put(new Location(File.B, 8), new Knight(Color.BLACK));
        pieces.put(new Location(File.G, 8), new Knight(Color.BLACK));

        // Bishops
        pieces.put(new Location(File.C, 1), new Bishop(Color.WHITE));
        pieces.put(new Location(File.F, 1), new Bishop(Color.WHITE));
        pieces.put(new Location(File.C, 8), new Bishop(Color.BLACK));
        pieces.put(new Location(File.F, 8), new Bishop(Color.BLACK));

        // Queens
        pieces.put(new Location(File.D, 1), new Queen(Color.WHITE));
        pieces.put(new Location(File.D, 8), new Queen(Color.BLACK));

        // Kings
        pieces.put(new Location(File.E, 1), new King(Color.WHITE));
        pieces.put(new Location(File.E, 8), new King(Color.BLACK));

        // Pawns
        for (File file : File.values()) {
            pieces.put(new Location(file, 2), new Pawn(Color.WHITE));
            pieces.put(new Location(file, 7), new Pawn(Color.BLACK));
        }

        return pieces;
    }
}
