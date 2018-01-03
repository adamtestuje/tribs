package tribs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private final String filePathString = "user.data";

    @Override
    public void start(Stage primaryStage) throws IOException {
        File file = new File(filePathString);
        if(file.exists() && !file.isDirectory()) {
            openMainView();
        } else {
            openSetupWizard(primaryStage);
        }
    }

    private void openMainView() {
        System.out.println("Main view open!");
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
