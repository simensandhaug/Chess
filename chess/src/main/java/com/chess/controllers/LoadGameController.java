package com.chess.controllers;

import java.io.IOException;

import com.chess.App;

import javafx.fxml.FXML;

public class LoadGameController {
    @FXML
    private void switchToMenuView() throws IOException {
        App.setRoot("menu");
    }
}
