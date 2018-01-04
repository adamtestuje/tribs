package tribs.controllers.wizard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import tribs.utils.JFX;
import tribs.utils.Memory;
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
        Memory.rememberWorld(selectorWorld.getSelectionModel().getSelectedItem());
        JFX jfx = new JFX();
        jfx.openStage("/fxml/wizard/stepThird.fxml",
                "Tribs - First Time Setup Wizard",
                (Stage) buttonNext.getScene().getWindow(),
                600, 400);
    }
}