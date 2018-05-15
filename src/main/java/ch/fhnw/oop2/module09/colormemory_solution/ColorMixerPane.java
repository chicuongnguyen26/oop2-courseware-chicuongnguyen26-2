package ch.fhnw.oop2.module09.colormemory_solution;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;


public class ColorMixerPane extends GridPane {
	private final CoolColorMemoryPM pm;

	private Slider red;
	private Slider green;
	private Slider blue;

	private Label redValue;
	private Label blueValue;
	private Label greenValue;

	private Rectangle display;

	public ColorMixerPane(CoolColorMemoryPM pm) {
		this.pm = pm;
		initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
		setupBindings();
	}

	private void initializeControls() {
		red   = new Slider(0.0, 255, 0);
		green = new Slider(0.0, 255, 0);
		blue  = new Slider(0.0, 255, 0);

		redValue   = new Label();
		greenValue = new Label();
		blueValue  = new Label();

		display = new Rectangle();
		display.setHeight(100);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setHgap(10);
		setVgap(10);

		ColumnConstraints sliderColumn = new ColumnConstraints();
		sliderColumn.setHgrow(Priority.ALWAYS);

		ColumnConstraints valueColumn = new ColumnConstraints(30);
		valueColumn.setHalignment(HPos.RIGHT);

		getColumnConstraints().addAll(sliderColumn, valueColumn);

		addRow(0, red  , redValue);
		addRow(1, green, greenValue);
		addRow(2, blue , blueValue);
		add(display, 0, 3, 2, 1);

		setPrefHeight(getPrefHeight() + 200);
	}

	private void setupEventHandlers() {
	}


	private void setupValueChangedListeners() {
	}

	private void setupBindings() {
		red.valueProperty().bindBidirectional(pm.redProperty());
		redValue.textProperty().bind(pm.redProperty().asString());

		green.valueProperty().bindBidirectional(pm.greenProperty());
		greenValue.textProperty().bind(pm.greenProperty().asString());

		blue.valueProperty().bindBidirectional(pm.blueProperty());
		blueValue.textProperty().bind(pm.blueProperty().asString());

		display.fillProperty().bind(pm.colorProperty());

		display.widthProperty().bind(widthProperty().subtract(20));
	}
}
