package tribs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class About {
    @FXML Button buttonClose;

    @FXML
    public void close() {
        Stage stage = (Stage) buttonClose.getScene().getWindow();
        stage.close();
    }
}
