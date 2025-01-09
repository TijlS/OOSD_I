package domein;

public class Plant {
	private final String naam;
	private char soortCode;
	private int hoogteInCm;
	private int aantalInVoorraad;
	private double prijsInEuro;

	private static final int MIN_HOOGTE = 0;
	private static final int MAX_HOOGTE = 400;
	private static final int BTW_PERCENTAGE = 21;

	public Plant(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
		controleerNaam(naam);

		this.naam = naam;
		this.setSoortCode(soortCode);
		this.setHoogteInCm(hoogteInCm);
		this.setAantalInVoorraad(aantalInVoorraad);
		this.setPrijsInEuro(prijsInEuro);
	}

	public void setAantalInVoorraad(int aantalInVoorraad) {
		if (aantalInVoorraad < 0)
			throw new IllegalArgumentException("Aantal in voorraad moet positief zijn!");
		this.aantalInVoorraad = aantalInVoorraad;
	}

	public Plant(String naam, char soortCode) {
		this(naam, soortCode, 100, 0, 0);
	}

	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Naam mag niet leeg zijn!");
	}

	public char getSoortCode() {
		return soortCode;
	}

	private void setSoortCode(char soortCode) {
		if (soortCode != 'A' && soortCode != 'B' && soortCode != 'C')
			throw new IllegalArgumentException("Soortcode mag enkel A, B of C zijn!");
		this.soortCode = soortCode;
	}

	public double getPrijsInEuro() {
		return prijsInEuro;
	}

	public void setPrijsInEuro(double prijsInEuro) {
		this.prijsInEuro = prijsInEuro;
	}

	public String getNaam() {
		return naam;
	}

	public int getHoogteInCm() {
		return hoogteInCm;
	}

	private void setHoogteInCm(int hoogteInCm) {
		if (hoogteInCm <= MIN_HOOGTE || hoogteInCm > MAX_HOOGTE)
			throw new IllegalArgumentException(
					String.format("Hoogte moet in interval [%d, %d] liggen!", MIN_HOOGTE, MAX_HOOGTE));
		this.hoogteInCm = hoogteInCm;
	}

	public int getAantalInVoorraad() {
		return aantalInVoorraad;
	}

	public double berekenVerkoopprijs() {
		return this.prijsInEuro + prijsInEuro * BTW_PERCENTAGE / 100;
	}

}
