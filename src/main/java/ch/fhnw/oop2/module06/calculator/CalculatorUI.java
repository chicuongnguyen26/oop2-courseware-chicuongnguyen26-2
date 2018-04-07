package ch.fhnw.oop2.module06.calculator;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CalculatorUI extends GridPane {

    private ArrayList<Button> numberButtons = new ArrayList<>();

    private Button dot;

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;

    private Button plusminus;

    private Button equal;
    private Button ac;

    private Label display;

    private ImageView selectedImage;
    private Image image;



    public CalculatorUI() {
        initializeControls();
        layoutControls();
        initializeSelf();
    }
    private void initializeSelf(){
        String styleSheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(styleSheet);
            }
    private void initializeControls() {
        for (int i = 0; i < 10; i++) {
            numberButtons.add(createButton(String.valueOf(i)));
        }

        dot = createButton(".");
        plus = createButton("+");
        minus = createButton("-");
        multiply = createButton("*");
        divide = createButton("/");

        plusminus = createButton("+/-");
        equal = createButton("=");
        ac = createButton("C");

        display = new Label("0");
        display.setMaxWidth(Double.MAX_VALUE);
        display.setMinHeight(70.0);


        selectedImage = new ImageView();
        image = new Image("file:///C:/Users/chicu/Documents/ironman1.gif");
        selectedImage.setImage(image);

    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMinSize(75.0, 80.0);

        return button;
    }

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        add(display, 0, 0, 5, 1);

        add(ac, 0, 1);
        add(plusminus, 1, 1);
        add(divide, 2, 1);
        add(multiply, 3, 1);

        add(numberButtons.get(7), 0, 2);
        add(numberButtons.get(8), 1, 2);
        add(numberButtons.get(9), 2, 2);
        add(minus, 3, 2);

        add(numberButtons.get(4), 0, 3);
        add(numberButtons.get(5), 1, 3);
        add(numberButtons.get(6), 2, 3);
        add(plus, 3, 3);

        add(numberButtons.get(1), 0, 4);
        add(numberButtons.get(2), 1, 4);
        add(numberButtons.get(3), 2, 4);
        add(equal, 3, 4, 1, 2);

        add(numberButtons.get(0), 0, 5, 2, 1);
        add(dot, 2, 5);

        add(selectedImage, 4, 1, 1, 5);

    // test
    }


}
