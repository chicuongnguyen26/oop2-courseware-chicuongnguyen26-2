package ch.fhnw.oop2.module08.colormixer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

import java.awt.*;
import javafx.scene.paint.Color;

public class ColorPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("Color Mixer 3000");

    private final IntegerProperty red   = new SimpleIntegerProperty(0);
    private final IntegerProperty blue  = new SimpleIntegerProperty(0);
    private final IntegerProperty green = new SimpleIntegerProperty(0);

    private final ObjectProperty<Color> mischMasch = new SimpleObjectProperty<>();

    //public ColorPM(){
   //     mischMasch.bind(Bindings.createObjectBinding(() -> {
     //       return Color.rgb(getRed(), getGreen(), getBlue()); }, red, green, blue));
  //  }


    public ColorPM(){
        red.addListener(((observable, oldValue, newValue)       -> setMischMasch(Color.rgb(getRed(), getGreen(), getBlue()))));
        green.addListener(((observable, oldValue, newValue)     -> setMischMasch(Color.rgb(getRed(), getGreen(), getBlue()))));
        blue.addListener(((observable, oldValue, newValue)      -> setMischMasch(Color.rgb(getRed(), getGreen(), getBlue()))));
    }




    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public int getRed() {
        return red.get();
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public void setRed(int red) {
        this.red.set(red);
    }

    public int getBlue() {
        return blue.get();
    }

    public IntegerProperty blueProperty() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue.set(blue);
    }

    public int getGreen() {
        return green.get();
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public void setGreen(int green) {
        this.green.set(green);
    }

    public Color getMischMasch() {
        return mischMasch.get();
    }

    public ObjectProperty<Color> mischMaschProperty() {
        return mischMasch;
    }

    public void setMischMasch(Color mischMasch) {
        this.mischMasch.set(mischMasch);
    }
}
