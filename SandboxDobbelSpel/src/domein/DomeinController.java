package domein;

import java.time.LocalDate;

import dto.SpelerDTO;

public class DomeinController {

	private Spel spel;
	private SpelerRepository spelerRepository;
	private Speler aangemeldeSpeler;

	public DomeinController() {
		spelerRepository = new SpelerRepository(); // MC 1 op DCD
	}

	public void startNieuwSpel() {
		this.spel = new Spel();
	}

	public void rolDobbelstenen() {
		spel.rolDobbelstenen();
	}

	public int geefAantalOgenWorp() {
		return this.spel.geefAantalOgenWorp();
	}

	public int geefScore() {
		return spel.getScore();
	}

	public boolean isEindeSpel() {
		return spel.isEindeSpel();
	}

	/**
	 * 
	 * @param naam
	 * @param voornaam
	 * @param email
	 * @param geboorteDatum
	 * @param wachtwoord
	 * @param bevestigingWachtwoord
	 */
	public void registreer(String naam, String voornaam, String email, LocalDate geboorteDatum, String wachtwoord,
			String bevestigingWachtwoord) {
		Speler nieuweSpeler = new Speler(naam, voornaam, email, geboorteDatum, wachtwoord, bevestigingWachtwoord);

		spelerRepository.voegTo(nieuweSpeler);

	}

	/**
	 * 
	 * @param email
	 * @param wachtwoord
	 */
	public void meldAan(String email, String wachtwoord) {
		Speler speler = spelerRepository.geefSpeler(email, wachtwoord);

		this.aangemeldeSpeler = speler;
	}

	public SpelerDTO geefSpeler() {
		SpelerDTO spelerDTO = new SpelerDTO(this.aangemeldeSpeler.getNaam(), this.aangemeldeSpeler.getVoornaam(),
				this.aangemeldeSpeler.isAdminrechten(), this.aangemeldeSpeler.getKrediet());

		return spelerDTO;
	}

}