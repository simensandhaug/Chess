package com.chess.models.game;

import java.util.Scanner;

import com.chess.common.File;
import com.chess.common.Location;
import com.chess.models.board.Board;
import com.chess.models.pieces.Movable;
import com.chess.models.squares.Square;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

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

            board.printBoard();

        }
    }

    public static void printPiece(Movable piece) {
        System.out.println(piece.toString());
    }
}
