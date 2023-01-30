package com.chess.models.game;

import java.util.Scanner;

import com.chess.common.FEN;
import com.chess.common.File;
import com.chess.common.Location;
import com.chess.models.board.Board;
import com.chess.models.pieces.Movable;
import com.chess.models.squares.Square;

public class Game {
    private static final String startingPositionFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    public static Board board;
    public static void main(String[] args) {
        String fenStr = args.length > 1 ? args[0] : startingPositionFEN;
        String moves = args.length > 1 ? args[1] : "";
        FEN fen = new FEN(fenStr);
        board = new Board(fen, moves);
        board.printTerminalBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // E2->E4

            String input = scanner.nextLine();
            String[] fromTo = input.split("->");
            File fromFile = File.valueOf(String.valueOf(Character.toUpperCase(fromTo[0].charAt(0))));
            Integer fromRank = Integer.parseInt(String.valueOf(fromTo[0].charAt(1)));
            File toFile = File.valueOf(String.valueOf(Character.toUpperCase(fromTo[1].charAt(0))));
            Integer toRank = Integer.parseInt(String.valueOf(fromTo[1].charAt(1)));

            Square fromSq = board.getLocationSquareMap().get(new Location(fromFile, fromRank));
            Square toSq = board.getLocationSquareMap().get(new Location(toFile, toRank));

            fromSq.getPiece().makeMove(toSq);
            fromSq.reset();

            board.printTerminalBoard();
            board.printMoves();

        }
    }

    public static void printPiece(Movable piece) {
        System.out.println(piece.toString());
    }

    public static Board getBoard() {
        return board;
    }

}
