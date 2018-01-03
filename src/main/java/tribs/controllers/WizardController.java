package tribs.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tribs.utils.Tribs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WizardController {
    private boolean isLogged = false;
    @FXML private TextField inputLogin;
    @FXML private PasswordField inputPassword;
    @FXML private Button buttonReset;
    @FXML private Button buttonLogin;
    @FXML private Label labelStatus;
    @FXML private Label labelLogin;
    @FXML private Label labelPassword;
    @FXML private ChoiceBox<String> selectorWorld;

    @FXML
    public void loginTry() throws IOException {
        if (isLogged) {
            nextScene();
            return;
        }
        if (inputLogin.getText().isEmpty() || inputPassword.getText().isEmpty()) {
            emptyWarning();
        } else {
            loginAction();
        }
    }

    private void loginAction() {
        labelStatus.setText(String.format("Status: Trying to login with username: %s...", inputLogin.getText()));
        if (Tribs.login(inputLogin.getText(), inputPassword.getText())) {
            isLogged = true;
            next();
        } else {
            reset();
            labelStatus.setText("Status: Failed. Try again.");
        }
    }

    private void next() {
        inputLogin.setDisable(true);
        labelLogin.setDisable(true);
        inputPassword.setDisable(true);
        labelPassword.setDisable(true);
        buttonReset.setVisible(false);
        buttonLogin.setText("Next");
        labelStatus.setText("Status: Success.");
    }

    private void emptyWarning() {
        labelStatus.setText("Status: Please fill Login and Password fields!");
    }

    @FXML
    private void reset() {
        inputLogin.setText("");
        inputLogin.setDisable(false);
        inputPassword.setText("");
        inputPassword.setDisable(false);
        labelStatus.setText("Status: Idle");
    }

    private void nextScene() throws IOException {
        Stage appStage = (Stage) buttonLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wizard/2_choose_world.fxml"));
        Scene scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
        populateWorlds();
    }

    private void populateWorlds() {
        List<String> worldsList = new ArrayList<>();
        worldsList.add("Test");
//        ObservableList worlds = FXCollections.observableList(Tribs.getWorlds());
        ObservableList<String> w = FXCollections.observableArrayList("Adam", "testuje");
        selectorWorld.setItems(w);
    }
}