package com.chess.models.pieces;

import java.util.HashMap;
import java.util.Map;

import com.chess.common.FEN;
import com.chess.common.File;
import com.chess.common.Location;

// Class PieceFactory is a final utility class to create pieces of a chess board. 
public final class PieceFactory {
    
    // Private constructor to prevent instantiation of the class.
    private PieceFactory() {
    }
    
    public static Map<Location, Piece> getPieces(FEN fen) {
        String fenStr = fen.toString();
        Map<Location, Piece> pieces = new HashMap<>();
        String[] parts = fenStr.split(" ");
        String[] rows = parts[0].split("/");
    
        int row = 8;
        // Iterate over the rows of the fen string
        for (String r : rows) {
            int col = File.A.ordinal();
            // Iterate over each character in the row
            for (char c : r.toCharArray()) {
                // If the character is a digit, it represents the number of blank squares in the row
                if (Character.isDigit(c)) {
                    col += c - '0';
                } else {
                    Piece piece;
                    // Create the piece based on the character representation
                    switch (c) {
                        case 'P':
                            piece = new Pawn(Color.WHITE);
                            break;
                        case 'p':
                            piece = new Pawn(Color.BLACK);
                            break;
                        case 'N':
                            piece = new Knight(Color.WHITE);
                            break;
                        case 'n':
                            piece = new Knight(Color.BLACK);
                            break;
                        case 'B':
                            piece = new Bishop(Color.WHITE);
                            break;
                        case 'b':
                            piece = new Bishop(Color.BLACK);
                            break;
                        case 'R':
                            piece = new Rook(Color.WHITE);
                            break;
                        case 'r':
                            piece = new Rook(Color.BLACK);
                            break;
                        case 'Q':
                            piece = new Queen(Color.WHITE);
                            break;
                        case 'q':
                            piece = new Queen(Color.BLACK);
                            break;
                        case 'K':
                            piece = new King(Color.WHITE);
                            break;
                        case 'k':
                            piece = new King(Color.BLACK);
                            break;
                        default:
                            piece = null;
                            break;
                    }
                    // Add the piece to the map with its location
                    pieces.put(new Location(File.values()[col], row), piece);
                    col++;
                }
            }
            row--;
        }
        return pieces;
    }
}

