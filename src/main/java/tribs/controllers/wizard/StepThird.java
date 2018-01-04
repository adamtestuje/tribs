package tribs.controllers.wizard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tribs.utils.JFX;
import tribs.utils.Memory;

import java.io.IOException;

public class StepThird {
    @FXML Button buttonFinish;

    @FXML
    private void finish() {
        Memory.saveUserData();
        try {
            loadNext();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadNext() throws IOException {
        JFX jfx = new JFX();
        jfx.openStage("/fxml/mainView.fxml",
                "Tribs - Main View",
                (Stage) buttonFinish.getScene().getWindow(),
                800, 600);
    }
}