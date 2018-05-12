package ch.fhnw.oop2.module08.multilanguage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dieter Holz
 */
class LanguageSwitcherTest {

	@Test
	void testSetLanguage() {
		//given
		LanguageSwitcher switcher = new LanguageSwitcher();

		//when
		switcher.setLanguage(LanguageSwitcher.Lang.DE);

		//then
		Assertions.assertEquals("App auf Deutsch", switcher.getApplicationTitle());
		Assertions.assertEquals("eine Beschriftung", switcher.getText());
		Assertions.assertEquals("Deutsch", switcher.getApplicationTitle());
		Assertions.assertEquals("Englisch", switcher.getApplicationTitle());



		//when
		switcher.setLanguage(LanguageSwitcher.Lang.EN);

		//then
		Assertions.assertEquals("English App", switcher.getApplicationTitle());
		Assertions.assertEquals("some Label", switcher.getText());
		Assertions.assertEquals("German", switcher.getApplicationTitle());
		Assertions.assertEquals("English", switcher.getApplicationTitle());
	}

}