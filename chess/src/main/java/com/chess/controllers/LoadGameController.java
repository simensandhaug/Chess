package com.chess.controllers;

import java.io.IOException;

import com.chess.Main;

import javafx.fxml.FXML;

public class LoadGameController {
    @FXML
    private void switchToMenuView() throws IOException {
        Main.setRoot("menu");
    }
}
