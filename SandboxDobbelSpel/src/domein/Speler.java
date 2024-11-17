package domein;

import java.time.LocalDate;

public class Speler {

	private String naam;
	private String voornaam;
	private String email;
	private LocalDate geboorteDatum;
	private String wachtwoord;
	private int krediet;
	private boolean adminrechten;

	/**
	 * 
	 * @param naam
	 * @param voornaam
	 * @param email
	 * @param geboorteDatum
	 * @param wachtwoord
	 * @param bevestigingWachtwoord
	 */
	public Speler(String naam, String voornaam, String email, LocalDate geboorteDatum, String wachtwoord,
			String bevestigingWachtwoord) {
		this.setNaam(naam);
		this.setVoornaam(voornaam);
		this.setEmail(email);
		this.setWachtwoord(wachtwoord);
		this.setGeboorteDatum(geboorteDatum);

		this.krediet = 5;
		this.adminrechten = false;
	}

	public String getEmail() {
		return this.email;
	}

	public int getKrediet() {
		return krediet;
	}

	public String getNaam() {
		return naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	private void setNaam(String naam) {
		if (naam != null && !naam.isEmpty())
			this.naam = naam;
		else
			this.naam = "anoniem";
	}

	private void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public boolean isAdminrechten() {
		return adminrechten;
	}

	private void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getWachtwoord() {
		return this.wachtwoord;
	}

}