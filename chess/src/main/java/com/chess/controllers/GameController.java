package com.chess.controllers;

import java.io.IOException;

import com.chess.App;

import javafx.fxml.FXML;

public class GameController {

    @FXML
    private void switchToMenuView() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    private void saveGame() throws IOException {
        //
    }
}
