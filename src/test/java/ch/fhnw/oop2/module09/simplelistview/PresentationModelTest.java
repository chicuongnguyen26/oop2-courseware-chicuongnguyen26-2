package ch.fhnw.oop2.module09.simplelistview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dieter Holz
 */
class PresentationModelTest {

	@Test
	void testAdd()  {
		//given
		PresentationModel pm = new PresentationModel();

		//then
		Assertions.assertEquals(0, pm.getElements().size());

		//when
		pm.newElements();


		//then
		Assertions.assertEquals(1, pm.getElements().size());
		Assertions.assertEquals("1", pm.getElements().get(0));

		//when
		pm.newElements();


		//then
		Assertions.assertEquals(2, pm.getElements().size());
		Assertions.assertEquals("1", pm.getElements().get(0));
		Assertions.assertEquals("2", pm.getElements().get(1));

	}
}