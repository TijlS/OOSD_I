package domein;

public class Gebruiker {
	private String gebruikersnaam;
	private double krediet;

	/**
	 * Class constructor. <br>
	 * - de gebruikersnaam moet minstens 6 tekens bevatten <br>
	 * - de gebruikersnaam moet minstens 1 punt bevatten <br>
	 * - de gebruikersnaam mag niet beginnnen of eindigen met een punt <br>
	 * - de gebruikersnaam mag geen spaties bevatten <br>
	 * - krediet moet in ]0, 100] liggen <br>
	 * - krediet moet nauwkeurig zijn tot 0.01 <br>
	 * 
	 * @param gebruikersnaam de <code>String</code> met de gebruikersnaam voor de
	 *                       nieuwe <code>Gebruiker</code>
	 * @throws <code>IllegalArgumentException</code> wanneer de gebruikersnaam niet
	 * voldoet
	 */
	public Gebruiker(String gebruikersnaam, double krediet) {
		this.setGebruikersnaam(gebruikersnaam);
		this.setKrediet(krediet);
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	private void setGebruikersnaam(String gebruikersnaam) {
		// DR: > 6
		if (gebruikersnaam == null || gebruikersnaam.isEmpty() || gebruikersnaam.length() < 6)
			throw new IllegalArgumentException("Gebruikersnaam moet minstens 6 tekens zijn!");

		// DR: min 1 punt
		boolean hasPoint = false;
		// DR: geen spaties
		boolean hasSpaces = false;

		for (int i = 0; i < gebruikersnaam.length(); i++) {
			if (gebruikersnaam.charAt(i) == '.')
				hasPoint = true;
			if (gebruikersnaam.charAt(i) == ' ')
				hasSpaces = true;
		}

		// DR: niet beginnen of eindigen met punt;
		boolean startsOrEndsWithPoint = gebruikersnaam.startsWith(".") || gebruikersnaam.endsWith(".");

		if (!hasPoint)
			throw new IllegalArgumentException("Gebruikersnaam moet een punt bevatten!");
		if (startsOrEndsWithPoint)
			throw new IllegalArgumentException("Gebruikersnaam mag niet starten of eindigen met een punt!");
		if (hasSpaces)
			throw new IllegalArgumentException("Gebruikersnaam mag geen spaties bevatten!");

		this.gebruikersnaam = gebruikersnaam;
	}

	public double getKrediet() {
		return krediet;
	}

	private void setKrediet(double krediet) {
		if (krediet <= 0 || krediet > 100)
			throw new IllegalArgumentException("Krediet moet in interval ]0, 100] liggen!");

		this.krediet = krediet;
	}

}
