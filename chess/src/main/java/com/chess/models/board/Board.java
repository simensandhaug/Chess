package com.chess.models.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chess.common.File;
import com.chess.common.Location;
import com.chess.models.pieces.Color;
import com.chess.models.pieces.Piece;
import com.chess.models.pieces.PieceFactory;
import com.chess.models.squares.Square;
import com.chess.models.squares.SquareColor;

public class Board {
    private static final Integer BOARD_SIZE = 8;
    private final Map<Location, Square> locationSquareMap;

    Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public Board() {

        locationSquareMap = new HashMap<>();
        Map<Location, Piece> pieces = PieceFactory.getPieces();

        for (int i = 0; i < board.length; i++) {
            int col = 0;
            SquareColor squareColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for (File file : File.values()) {
                Square square = new Square(squareColor, new Location(file, BOARD_SIZE - i));

                if (pieces.containsKey(square.getLocation())) {
                    Piece piece = pieces.get(square.getLocation());
                    square.setPiece(piece);
                    square.setIsOccupied(true);
                    piece.setSquare(square);
                    if (piece.getColor().equals(Color.WHITE)) {
                        whitePieces.add(piece);
                    } else {
                        blackPieces.add(piece);
                    }
                }

                locationSquareMap.put(square.getLocation(), square);

                board[i][col] = square;
                squareColor = (squareColor == SquareColor.LIGHT) ? SquareColor.DARK : SquareColor.LIGHT;
                col++;
            }
        }
    }

    public Map<Location, Square> getLocationSquareMap() {
        return locationSquareMap;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(BOARD_SIZE - i + " ");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getIsOccupied()) {
                    Piece piece = board[i][j].getPiece();
                    System.out.print(piece.getName().charAt(0) + "  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }

        System.out.print("  ");
        for (File file : File.values()) {
            System.out.print(file.name() + "  ");
        }
        System.out.println();
    }

}
