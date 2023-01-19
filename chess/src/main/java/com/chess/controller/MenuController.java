package com.chess.controller;

import java.io.IOException;

import com.chess.App;

import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void switchToGameView() throws IOException {
        App.setRoot("game");
    }

    @FXML
    private void switchToLoadGameView() throws IOException {
        App.setRoot("loadGame");
    }
}