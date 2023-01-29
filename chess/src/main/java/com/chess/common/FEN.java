package com.chess.common;

public class FEN {
    private String fen;
    private boolean isWhiteTurn;
    private boolean whiteKingSideCastle;
    private boolean whiteQueenSideCastle;
    private boolean blackKingSideCastle;
    private boolean blackQueenSideCastle;
    private String enPassantSquare;
    private int halfMoveClock;
    private int fullMoveNumber;

    public FEN(String fen) {
        this.fen = fen;
        parse();
    }

    private void parse() {
        String[] parts = fen.split(" ");

        isWhiteTurn = parts[1].equals("w");

        String castling = parts[2];
        if (castling.contains("K")) {
            whiteKingSideCastle = true;
        }
        if (castling.contains("Q")) {
            whiteQueenSideCastle = true;
        }
        if (castling.contains("k")) {
            blackKingSideCastle = true;
        }
        if (castling.contains("q")) {
            blackQueenSideCastle = true;
        }
        enPassantSquare = parts[3];
        halfMoveClock = Integer.parseInt(parts[4]);
        fullMoveNumber = Integer.parseInt(parts[5]);
    }

    public boolean isWhiteKingSideCastle() {
        return whiteKingSideCastle;
    }

    public boolean isWhiteQueenSideCastle() {
        return whiteQueenSideCastle;
    }

    public boolean isBlackKingSideCastle() {
        return blackKingSideCastle;
    }

    public boolean isBlackQueenSideCastle() {
        return blackQueenSideCastle;
    }

    public String getEnPassantSquare() {
        return enPassantSquare;
    }

    public int getHalfMoveClock() {
        return halfMoveClock;
    }

    public int getFullMoveNumber() {
        return fullMoveNumber;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    @Override
    public String toString() {
        return fen;
    }
}

