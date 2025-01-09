package domein;

import utils.Orientatie;

public class Driehoek {
	public static final int MIN_GROOTTE = 1;
	public static final int MAX_GROOTTE = 20;
	public static final String TOEGESTANE_TEKENS = "#*$-@&|";

	private int grootte;
	private char teken;
	private Orientatie orientatie;

	public Driehoek(Orientatie orientatie, int grootte, char teken) {
		setGrootte(grootte);
		setTeken(teken);
		setOrientatie(orientatie);
	}

	public String geefAlsTekening() {
		return switch (orientatie) {
		case Orientatie.LINKS_BOVEN -> geefDriehoekLinksBoven();
		case Orientatie.RECHTS_BOVEN -> geefDriehoekRechtsBoven();
		case Orientatie.LINKS_ONDER -> geefDriehoekLinksOnder();
		case Orientatie.RECHTS_ONDER -> geefDriehoekRechtsOnder();
		};
	}

	private String geefDriehoekRechtsBoven() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(' ', lijnNr - 1);
			driehoek += geefTekensInString(teken, grootte - lijnNr + 1);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekRechtsOnder() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(' ', grootte - lijnNr);
			driehoek += geefTekensInString(teken, lijnNr);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekLinksBoven() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(teken, grootte - lijnNr + 1);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekLinksOnder() {
		// Niet recursief:
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(teken, lijnNr);
			driehoek += "\n";
		}
		return driehoek;

		// TODO
		// voor het laatste deel van de oefening zet je bovenstaande code in commentaar
		// en haal je onderstaande return uit commentaar
		// return geefDriehoekLinksOnderRecursief(grootte);

	}

//	private String geefDriehoekLinksOnderRecursief(int grootte) {
//		// TODO: implementeer
//	}

	public void setGrootte(int grootte) {
		if (grootte < MIN_GROOTTE || grootte > MAX_GROOTTE)
			throw new IllegalArgumentException(
					String.format("Grootte moet in interval [%d, %d] liggen!", MIN_GROOTTE, MAX_GROOTTE));
		this.grootte = grootte;
	}

	public void setTeken(char teken) {
		if (TOEGESTANE_TEKENS.indexOf(teken) == -1)
			throw new IllegalArgumentException(String.format("Teken moet een van deze zijn: %s", TOEGESTANE_TEKENS));
		this.teken = teken;
	}

	public void setOrientatie(Orientatie orientatie) {
		this.orientatie = orientatie;
	}

	private String geefTekensInString(char teken, int aantal) {
		String resultaat = "";
		for (int i = 0; i < aantal; i++) {
			resultaat += teken;
		}
		return resultaat;
	}
}
