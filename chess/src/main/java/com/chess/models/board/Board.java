package com.chess.models.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chess.common.FEN;
import com.chess.common.File;
import com.chess.common.Location;
import com.chess.common.Move;
import com.chess.models.pieces.Color;
import com.chess.models.pieces.Piece;
import com.chess.models.pieces.PieceFactory;
import com.chess.models.squares.Square;
import com.chess.models.squares.SquareColor;

public class Board {
    private static final Integer BOARD_SIZE = 8;
    private final Map<Location, Square> locationSquareMap;

    Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    String moves;
    Integer moveTally;
    boolean isWhiteTurn;

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    private FEN fen;

    public Board(FEN fen, String moves) {
        locationSquareMap = new HashMap<>();
        this.fen = fen;
        this.moves = moves;
        this.moveTally = fen.getFullMoveNumber();
        this.isWhiteTurn = fen.isWhiteTurn() == true;
        initializeBoard();
    }


    private void initializeBoard() {
        Map<Location, Piece> pieces = PieceFactory.getPieces(fen);

        // Populate the board with squares and pieces
        for (int i = 0; i < board.length; i++) {
            int col = 0;
            SquareColor squareColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for (File file : File.values()) {
                Square square = new Square(squareColor, new Location(file, BOARD_SIZE - i));
                locationSquareMap.put(square.getLocation(), square);
                
                Piece piece = pieces.get(square.getLocation());
                if (piece != null) {
                    square.setPiece(piece);
                    square.setIsOccupied(true);
                    piece.setSquare(square);
                    if (piece.getColor().equals(Color.WHITE)) {
                        whitePieces.add(piece);
                    } else {
                        blackPieces.add(piece);
                    }
                }
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

    public void printTerminalBoard() {
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

    public void printMoves() {
        System.out.println(moves);
    }

    public void setFen(FEN fen) {
        this.fen = fen;
    }

    public FEN getFen() {
        return fen;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoveTally(Integer moveTally) {
        this.moveTally = moveTally;
    }

    public Integer getMoveTally() {
        return moveTally;
    }

    public void incrementMoveTally() {
        moveTally++;
    }

    public void decrementMoveTally() {
        moveTally--;
    }

    public void addMove(Move move) {
        moves += moveTally.toString() + ". " + move.toString() + ", ";
    }

    public void setIsWhiteTurn(boolean b) {
        isWhiteTurn = b;
    }

    public boolean getIsWhiteTurn() {
        return isWhiteTurn;
    }
}
