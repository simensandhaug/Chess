module com.chess {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.chess to javafx.fxml;
    opens com.chess.controllers to javafx.fxml;
    opens com.chess.views to javafx.fxml;
    opens com.chess.models to javafx.fxml;

    exports com.chess.controllers;
    exports com.chess.views;
    exports com.chess.models;
    exports com.chess.common;
    exports com.chess.models.board;
    exports com.chess.models.pieces;
    exports com.chess.models.squares;
    exports com.chess.models.game;
    exports com.chess;
}
