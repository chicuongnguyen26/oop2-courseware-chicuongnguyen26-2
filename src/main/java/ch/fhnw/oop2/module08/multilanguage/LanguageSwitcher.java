package ch.fhnw.oop2.module08.multilanguage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Dieter Holz
 */
public class LanguageSwitcher {
	public void setLanguage(Lang language) {

	}

	//PresentationModel
	enum Lang {DE, EN}

	enum MultiLanguageText {
		WINDOW_TITLE(       "App in English", "App auf Deutsch"),
		LABEL_TEXT(         "some Label"    , "eine Beschriftung"),
		GERMAN_BUTTON_TEXT( "German"        , "Deutsch"),
		ENGLISH_BUTTON_TEXT("English"       , "Englisch");

		private final String englishLabel;
		private final String germanLabel;

		MultiLanguageText(String englishLabel, String germanLabel) {
			this.englishLabel = englishLabel;
			this.germanLabel  = germanLabel;
		}

		public String getEnglishLabel() {
			return englishLabel;
		}

		public String getGermanLabel() {
			return germanLabel;
		}

		public String getText(Lang lang) {
			switch (lang) {
				case DE:
					return getGermanLabel();
				case EN:
					return getEnglishLabel();
				default:
					return getEnglishLabel();
			}
		}
	}


	private final StringProperty applicationTitle = new SimpleStringProperty();

	private final StringProperty text = new SimpleStringProperty();
	private final StringProperty german = new SimpleStringProperty();
	private final StringProperty english = new SimpleStringProperty();

	public LanguageSwitcher() {

	}


	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	private void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public String getText() {
		return text.get();
	}

	public StringProperty textProperty() {
		return text;
	}

	public void setText(String text) {
		this.text.set(text);
	}

	public String getGerman() {
		return german.get();
	}

	public StringProperty germanProperty() {
		return german;
	}

	public void setGerman(String german) {
		this.german.set(german);
	}

	public String getEnglish() {
		return english.get();
	}

	public StringProperty englishProperty() {
		return english;
	}

	public void setEnglish(String english) {
		this.english.set(english);
	}
}
