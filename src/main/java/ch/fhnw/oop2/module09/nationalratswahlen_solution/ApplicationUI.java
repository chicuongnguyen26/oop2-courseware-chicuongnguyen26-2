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

	private TableView<Resultat> tabelle;
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

	private TableView<Resultat> initializeResultatTabelle() {
		TableView<Resultat> tableView = new TableView<>(model.getResulate()); // nur vom Model können Daten abgerufen werden
        TableColumn<Resultat, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cell -> cell.getValue().gemeindeNamenProperty());
        /*
        Grundprinzip bei einem Integer -> funktioniert nicht,
        TableColumn<Resultat, Integer> wahlberechtigtenColumn = new TableColumn<>("Wahlber.");
        nameCol.setCellValueFactory(cell -> cell.getValue().wahlberechtigteProperty());
        */

        TableColumn<Resultat, Number> wahlberechtigtenColumn = new TableColumn<>("Wahlber."); // mit Number eine Zahl darstellen
        wahlberechtigtenColumn.setCellValueFactory(cell -> cell.getValue().wahlberechtigteProperty());

        TableColumn<Resultat, Number> waehlendeCol = new TableColumn<>("Wählende");
        waehlendeCol.setCellValueFactory(cell -> cell.getValue().waehlendeProperty());

		TableColumn<Resultat, Number> wahlbeteilCol = new TableColumn<>("Wahlbeteiligung");
		wahlbeteilCol.setCellValueFactory(cell -> cell.getValue().wahlbeteiligungProperty());


        tableView.getColumns().addAll(nameCol, wahlberechtigtenColumn, waehlendeCol, wahlbeteilCol);
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
		anzahlGemeinden.textProperty().bind(Bindings.size(model.getResulate())
				.asString("Anzahl der Gemeinden %d in der Schweiz"));
	}


}
