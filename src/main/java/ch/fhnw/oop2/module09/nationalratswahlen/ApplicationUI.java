package ch.fhnw.oop2.module09.nationalratswahlen;

import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox {
    private final WahlPM model;

    private TableView<Resultat> tabelle;

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
    }

    public void layoutControls() {
        setVgrow(tabelle, Priority.ALWAYS);

        getChildren().addAll(tabelle);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    public void setupBindings() {
    }

}
