module com.chess {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.chess to javafx.fxml;
    opens com.chess.controller to javafx.fxml;
    opens com.chess.view to javafx.fxml;
    opens com.chess.model to javafx.fxml;

    exports com.chess.controller;
    exports com.chess.view;
    exports com.chess.model;
    exports com.chess;
}
