package tribs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tribs.utils.JFX;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private final String filePathString = "userdata.dat";

    @Override
    public void start(Stage primaryStage) throws IOException {
        File file = new File(filePathString);
        if(file.exists() && !file.isDirectory()) {
            openMainView(primaryStage);
        } else {
            openSetupWizard(primaryStage);
        }
    }

    private void openMainView(Stage stage) throws IOException {
        JFX jfx = new JFX();
        jfx.openStage("/fxml/mainView.fxml", "Tribs - Main View", stage, 800, 600);
    }

    private void openSetupWizard(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/wizard/stepFirst.fxml"));
        primaryStage.setTitle("Tribs - First Time Setup Wizard");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
