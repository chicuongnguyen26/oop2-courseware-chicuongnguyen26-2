package ch.fhnw.oop2.module06.applicationtemplate_start;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AppUI extends StackPane {
    private Button button;

    public AppUI() {
        initializeSelf();
        initializeControls();
        layoutControls();
    }
    private void initializeSelf(){
        String styleSheet = getClass().getResource("AppStyle.css").toExternalForm();
        getStylesheets().add(styleSheet);
    }
    private void initializeControls() {
        button = new Button("Hello World");
    }

    private void layoutControls() {
        getChildren().add(button);
    }

}
