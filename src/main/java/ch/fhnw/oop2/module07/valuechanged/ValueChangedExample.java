package ch.fhnw.oop2.module07.valuechanged;

import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ValueChangedExample extends VBox {
	private TextField textField;
	private Slider    slider;

	public ValueChangedExample() {
        initializeSelf();
        initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
	}

    private void initializeSelf(){
        String stylesheet = getClass().getResource("style.css").toExternalForm();
 		getStylesheets().add(stylesheet);
    }

	private void initializeControls() {
		textField = new TextField("0");
		slider    = new Slider(0, 1000, 0);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setSpacing(10);
		getChildren().addAll(textField, slider);
	}

    private void setupEventHandlers() {
    }

	private void setupValueChangedListeners() {
		slider.valueProperty().addListener((observable, oldValue, newValue) -> {
			double realValue = newValue.doubleValue();
			textField.setText(String.valueOf(realValue));
		});
		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			double value = Double.valueOf(newValue);
			if((slider.getValue() - value) > 0.1) {
				slider.setValue(value);
			}
		});
	}



















    //		textField.textProperty().addListener((observable, oldValue, newValue) -> {
    //			try {
    //				slider.setValue(Double.valueOf(newValue));
    //				textField.getStyleClass().remove("invalid");
    //			} catch (NumberFormatException e) {
    //				textField.getStyleClass().add("invalid");
    //			}
    //		});
    //
    //		slider.valueProperty().addListener((observable, oldValue, newValue) -> textField.setText(String.format("%.1f", newValue.floatValue())));


}
