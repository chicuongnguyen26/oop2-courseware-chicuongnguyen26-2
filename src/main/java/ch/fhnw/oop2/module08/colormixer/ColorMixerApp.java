package ch.fhnw.oop2.module08.colormixer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class ColorMixerApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ColorPM pm = new ColorPM();
		Parent rootPanel = new ColorMixerUI(new ColorPM());

		Scene scene = new Scene(rootPanel);

		//primaryStage.setTitle("Color Mixer 3000!");
		primaryStage.titleProperty().bind(pm.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
