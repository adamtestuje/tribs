package tribs.controllers.wizard;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tribs.utils.JFX;
import tribs.utils.Memory;
import tribs.utils.Tribs;

import java.io.IOException;

public class StepFirst {
    private boolean isLogged = false;

    @FXML private Button buttonLogin;
    @FXML private Button buttonReset;
    @FXML private Label labelLogin;
    @FXML private Label labelPassword;
    @FXML private Label labelStatus;
    @FXML private PasswordField inputPassword;
    @FXML private TextField inputLogin;

    @FXML
    private void loadNext() throws IOException {
        JFX jfx = new JFX();
        jfx.openStage("/fxml/wizard/stepSecond.fxml",
                "Tribs - First Time Setup Wizard",
                (Stage) buttonLogin.getScene().getWindow(),
                600, 400);
    }

    @FXML
    public void loginTry() throws IOException {
        if (isLogged) {
            loadNext();
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
            Memory.rememberUserData(inputLogin.getText(), inputPassword.getText());
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
}