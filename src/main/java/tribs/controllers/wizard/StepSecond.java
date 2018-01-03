package tribs.controllers.wizard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import tribs.utils.Tribs;

import java.io.IOException;
import java.util.List;

public class StepSecond {
    @FXML private ChoiceBox<String> selectorWorld;
    @FXML private Button buttonNext;

    @FXML
    void initialize() {
        List<String> worlds = Tribs.getWorlds();
        ObservableList<String> daa = FXCollections.observableArrayList(worlds);
        selectorWorld.setItems(daa);
        selectorWorld.getSelectionModel().selectFirst();
    }

    @FXML
    private void loadNext() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wizard/stepThird.fxml"));
        Stage stage = (Stage) buttonNext.getScene().getWindow();
        stage.setTitle("Tribs - First Time Setup Wizard");
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);
        stage.show();
    }
}