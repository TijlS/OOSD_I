package domein;

public class SnackTracker {
	public static final int MAX_SNACKS = 10;
	private Snack[] snacks;

	/**
	 * Class constructor. Een nieuwe <code>SnackTracker</code> heeft geen Snacks en
	 * heeft plaats voor <code>MAX_SNACKS</code> snacks.
	 */
	public SnackTracker() {
		snacks = new Snack[MAX_SNACKS];
	}

	/**
	 * Registreert een nieuwe snack in deze SnackTracker.<br>
	 * De snack moet ingevuld zijn.
	 * 
	 * @param de Snack die geregistreerd wordt
	 * @throws IllegalArgumentException wanneer de <code>Snack</code> niet voldoet
	 *                                  of wanneer de <code>Snacktracker</code> zijn
	 *                                  maximum capaciteit reeds heeft bereikt.
	 */
	public void registreerSnack(Snack snack) {
		if (snack == null)
			throw new IllegalArgumentException("Snack moet ingevuld zijn!");

		int index = geefAantalGeregistreerdeSnacks();
		if (index == MAX_SNACKS)
			throw new IllegalArgumentException("Er zijn al te veel snacks!");

		this.snacks[index] = snack;
	}

	/**
	 * Geeft aan of er al dan niet gezond werd gesnackt.
	 * 
	 * @returns <code>true</code> indien er in deze SnackTracker geen snacks werden
	 *          geregistreerd of indien meer dan de helft van de geregistreerde
	 *          snacks gezond zijn; <code>false</code> in andere gevallen
	 */
	public boolean isGezondGesnackt() {
		if (geefAantalGeregistreerdeSnacks() == 0)
			return true;

		return geefAantalGezondeSnacks() > geefAantalGeregistreerdeSnacks() / 2 ? true : false;
	}

	public Snack[] getSnacks() {
		return snacks;
	}

	/**
	 * Retourneert het aantal geregistreerde snacks.
	 * 
	 * @returns het aantal geregistreerde snacks
	 */
	public int geefAantalGeregistreerdeSnacks() {
		int aantalSnacks = 0;

		for (Snack snack : snacks) {
			if (snack != null)
				aantalSnacks++;
		}

		return aantalSnacks;
	}

	private int geefAantalGezondeSnacks() {
		int aantal = 0;
		for (int i = 0; i < geefAantalGeregistreerdeSnacks(); i++)
			aantal += snacks[i].isGezond() ? 1 : 0;
		return aantal;
	}
}
