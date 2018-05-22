package ch.fhnw.oop2.module11.snake;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ch.fhnw.oop2.module11.snake.presentationmodels.Terrarium;
import ch.fhnw.oop2.module11.snake.views.Board;

/**
 * @author Dieter Holz
 */
public class SnakeApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		Terrarium terrarium = new Terrarium(20, 20);

		Parent rootPanel = new Board(terrarium);

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Snake");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
