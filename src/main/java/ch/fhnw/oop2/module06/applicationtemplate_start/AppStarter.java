package ch.fhnw.oop2.module06.applicationtemplate_start;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent rootPane = new AppUI();

        Scene myScene = new Scene(rootPane);

        primaryStage.setTitle("JavaFX Template");
        primaryStage.setScene(myScene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
