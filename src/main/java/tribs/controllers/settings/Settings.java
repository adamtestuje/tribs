package tribs.controllers.settings;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Settings {
    @FXML Button buttonReset;

    @FXML
    public void reset() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Tribs reset");
        confirm.setHeaderText("This action will reset saved user data and close Tribs.\n" +
                              "It can't be undone.");
        confirm.setContentText("Are you sure?");

        if (confirm.showAndWait().get() == ButtonType.OK) {
            try {
                Files.delete(Paths.get("userdata.dat"));
            } catch (Exception x) {
                x.printStackTrace();
            }
            System.exit(0);
        }
    }

    @FXML
    public void close() {
        Stage stage = (Stage) buttonReset.getScene().getWindow();
        stage.close();
    }
}
