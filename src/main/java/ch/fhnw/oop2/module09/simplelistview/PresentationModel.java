package ch.fhnw.oop2.module09.simplelistview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Dieter Holz
 */
public class PresentationModel {
	private final StringProperty applicationTitle = new SimpleStringProperty("A very simple list");

	private final ObservableList<String> allElements = FXCollections.observableArrayList();


	// all getters and setters

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public ObservableList<String> getElements(){
		return allElements;
	}

	public void newElements() {
		allElements.add(String.valueOf(allElements.size() + 1));

	}
}
