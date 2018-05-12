package ch.fhnw.oop2.module09.nationalratswahlen;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class WahlPM {
    private static final String FILE_NAME = "Nationalratswahlen2007.txt";

    private static final String DELIMITER = "\t";

    private final StringProperty applicationTitle = new SimpleStringProperty("Nationalratswahlen 2007");

    private final ObservableList<Resultat> resultate = FXCollections.observableArrayList();

    public WahlPM() {
        resultate.addAll(readFromFile());
    }

    private List<Resultat> readFromFile() {
        //todo implement
        return null;
    }

    public void save() {
        //todo implement
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public ObservableList<Resultat> getResultate() {
        return resultate;
    }
}