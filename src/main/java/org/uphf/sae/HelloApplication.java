package org.uphf.sae;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 140, 85));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}