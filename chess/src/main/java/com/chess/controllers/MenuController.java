package com.chess.controllers;

import java.io.IOException;

import com.chess.Main;

import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void switchToGameView() throws IOException {
        Main.setRoot("game");
    }

    @FXML
    private void switchToLoadGameView() throws IOException {
        Main.setRoot("loadGame");
    }
}