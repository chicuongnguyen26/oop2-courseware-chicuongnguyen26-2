package ch.fhnw.oop2.module09.nationalratswahlen_solution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Comparator;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox {
	private final WahlPM model; // Gesamte Infos, was dargestellt werden soll vom PM

	private TableView<Object> tabelle;
	private Label             anzahlGemeinden;

	public ApplicationUI(WahlPM model) {
		this.model = model;
        initializeSelf();
        initializeControls();
		layoutControls();
		setupEventHandlers();
		setupValueChangedListeners();
		setupBindings();
	}

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    public void initializeControls() {
		tabelle = initializeResultatTabelle();
		anzahlGemeinden = new Label();
	}

	private TableView<Object> initializeResultatTabelle() {
		TableView<Object> tableView = new TableView<>();



		return tableView;
	}

	private void layoutControls() {
		setVgrow(tabelle, Priority.ALWAYS);

		getChildren().addAll(tabelle, anzahlGemeinden);
	}

	private void setupEventHandlers() {
	}

	private void setupValueChangedListeners() {
	}

    private void setupBindings() {

	}


}
