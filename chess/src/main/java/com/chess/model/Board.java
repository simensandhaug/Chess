package com.chess.model;

public class Board {
    private Piece[][] board;
    private boolean whiteTurn;

    public Board() {
        this.board = new Piece[8][8];
        this.whiteTurn = true;

        // initialize the board with the chess pieces
        initialize();
    }

    private void initialize() {
        // code to initialize the board with the chess pieces
    }

    public boolean movePiece(int[] initialPosition, int[] finalPosition) {
        // code to move a piece on the board
    }

    public boolean isCheck(boolean color) {
        // code to check if the king is in check
    }

    public boolean isCheckmate(boolean color) {
        // code to check if the king is in checkmate
    }

    public boolean isStalemate() {
        // code to check if the game is in stalemate
    }

    public boolean isDraw() {
        // code to check if the game is a draw
    }

    public boolean getTurn() {
        return whiteTurn;
    }

    public void switchTurn() {
        whiteTurn = !whiteTurn;
    }

    public Piece[][] getBoard() {
        return board;
    }
}
