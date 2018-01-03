package tribs.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JFX {

    public void openStage(String fxmlPath, String title, Stage stage, int width, int height) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(false);
        stage.show();
    }
}
