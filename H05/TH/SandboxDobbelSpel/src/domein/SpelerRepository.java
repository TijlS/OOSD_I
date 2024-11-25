package domein;

import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

	private List<Speler> spelers;

	public SpelerRepository() {
		this.spelers = new ArrayList<>();

		// Spelers ophalen uit DB
	}

	/**
	 * 
	 * @param speler
	 */
	public void voegTo(Speler speler) {
		boolean uniekEmailAdres = true;

		for (Speler s : spelers) {
			if (s.getEmail().equals(speler.getEmail()))
				uniekEmailAdres = false;
		}

		if (uniekEmailAdres) {
			spelers.add(speler);
			// Speler toevoegen aan DB
		}
	}

	/**
	 * 
	 * @param emailadres
	 * @param wachtwoord
	 */
	public Speler geefSpeler(String emailadres, String wachtwoord) {
		for (Speler s : spelers) {
			if (s.getEmail().equals(emailadres) && s.getWachtwoord().equals(wachtwoord))
				return s;
		}

		return null;
	}

}