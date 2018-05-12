package ch.fhnw.oop2.module09.nationalratswahlen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class NR007App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		WahlPM model = new WahlPM();

		Parent rootPanel = new ApplicationUI(model);

		Scene scene = new Scene(rootPanel);

		primaryStage.titleProperty().bind(model.applicationTitleProperty());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
