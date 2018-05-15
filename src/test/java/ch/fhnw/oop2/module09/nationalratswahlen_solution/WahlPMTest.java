package ch.fhnw.oop2.module09.nationalratswahlen_solution;

import javafx.collections.ObservableList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class WahlPMTest {

	private WahlPM sut;

	@BeforeEach
	void setUp() {
		sut = new WahlPM();
	}

	@Test
	void testGetResulate() {
		//given
		ObservableList<Resultat> resulate = sut.getResulate();

		//then
		assertTrue(resulate.size() > 1);
		assertEquals("Aeugst am Albis"    , resulate.get(0).getGemeindeNamen());
		assertEquals("GE-CH de l'étranger", resulate.get(resulate.size() - 1).getGemeindeNamen());
	}

	@Test
	void testSave() {
		//given

		//when
		sut.getResulate().get(0).setGemeindeNamen("NNN");
		sut.save();

		WahlPM secondPM = new WahlPM();

		//then
		assertEquals(sut.getResulate().size(), secondPM.getResulate().size());
		assertEquals("NNN", secondPM.getResulate().get(0).getGemeindeNamen());

		for (int i = 0; i < sut.getResulate().size(); i++) {
			assertEquals(sut.getResulate().get(i).getGemeindeNamen(), secondPM.getResulate().get(i).getGemeindeNamen());
		}

		//after
		sut.getResulate().get(0).setGemeindeNamen("Aeugst am Albis");
		sut.save();
	}

}