package ch.fhnw.oop2.module09.colormemory_solution;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Dieter Holz
 */
public class ColorCell extends ListCell<Color> {
	private Circle circle = new Circle(30);

	@Override
	protected void updateItem(Color color, boolean empty) {
		super.updateItem(color, empty);
        setText(null);
        setGraphic(null);
		if (color != null && !empty) {
			int red   = (int)(color.getRed()   * 255);
			int green = (int)(color.getGreen() * 255);
			int blue  = (int)(color.getBlue()  * 255);
			setText("R: " + red + " G: " + green + " B:" + blue);
			circle.setFill(color);
			setGraphic(circle);
		}
	}
}
