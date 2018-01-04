package tribs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tribs.utils.Memory;

import java.util.Map;

public class MainView {
    @FXML Label labelUserData;
    @FXML Label labelVersion;

    Map userData;

    public MainView() {
        userData = Memory.readUserData();
    }

    @FXML
    public void initialize() {
        labelUserData.setText(String.format("Login: %s » World: %s", userData.get("login"), userData.get("world")));
        labelVersion.setText("Tribs, version:0.0.0a1");
    }
}
