package domein;

public class Gebruiker {
	private String gebruikersnaam;

	/**
	 * Class constructor. <br>
	 * - de gebruikersnaam moet minstens 6 tekens bevatten <br>
	 * - de gebruikersnaam moet minstens 1 punt bevatten <br>
	 * - de gebruikersnaam mag niet beginnnen of eindigen met een punt <br>
	 * - de gebruikersnaam mag geen spaties bevatten
	 * 
	 * @param gebruikersnaam de <code>String</code> met de gebruikersnaam voor de
	 *                       nieuwe <code>Gebruiker</code>
	 * @throws <code>IllegalArgumentException</code> wanneer de gebruikersnaam niet
	 * voldoet
	 */
	public Gebruiker(String gebruikersnaam) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	private void setGebruikersnaam(String gebruikersnaam) {
		// TODO
		throw new UnsupportedOperationException();
	}

}
