
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public final String appName = "Form Creator";

    @Override
    public void start(Stage primaryStage) throws Exception  {
            Parent root = FXMLLoader.load(getClass().getResource("mainGui.fxml"));
            primaryStage.setTitle(appName);
            primaryStage.setScene(new Scene(root, 850, 650));
            primaryStage.setResizable(false);
            primaryStage.show();
    }

    public String getAppName() {
        return appName;
    }
}

