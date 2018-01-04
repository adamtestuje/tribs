package tribs.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tribs.utils.Memory;
import tribs.utils.Tribs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainView {
    @FXML Label labelUserData;
    @FXML Label labelVersion;
    @FXML ChoiceBox<String> selectorVillages;

    Map userData;

    public MainView() {
        userData = Memory.readUserData();
    }

    @FXML
    public void initialize() {
        labelUserData.setText(String.format("Login: %s » World: %s", userData.get("login"), userData.get("world")));
        labelVersion.setText("Tribs, version:0.0.0a1");
        populateVillages();
    }

    private void populateVillages() {
        List<String> villages = Tribs.getVillages();
        ObservableList<String> observableVillages = FXCollections.observableArrayList(villages);
        selectorVillages.setItems(observableVillages);
        selectorVillages.getSelectionModel().selectFirst();
    }

    @FXML
    public void showAboutModal() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/about.fxml"));
        stage.setScene(new Scene(root));
        stage.initOwner(labelUserData.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tribs - About");
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    public void showSettings() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/settings/settings.fxml"));
        stage.setScene(new Scene(root));
        stage.initOwner(labelUserData.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tribs - Settings");
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    public void close() {
        Stage stage = (Stage) labelUserData.getScene().getWindow();
        stage.close();
    }
}
