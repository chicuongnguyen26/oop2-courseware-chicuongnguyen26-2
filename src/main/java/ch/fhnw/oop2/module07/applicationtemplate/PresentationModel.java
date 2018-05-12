package ch.fhnw.oop2.module07.applicationtemplate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PresentationModel {

    private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX Template");
    private final StringProperty randomText = new SimpleStringProperty("Boah, ey!");

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public String getRandomText() {
        return randomText.get();
    }

    public StringProperty randomTextProperty() {
        return randomText;
    }

    public void setRandomText(String randomText) {
        this.randomText.set(randomText);
    }
}
