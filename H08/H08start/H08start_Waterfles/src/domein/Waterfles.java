package domein;

public class Waterfles {
	public static final int MIN_CAPACITEIT = 100;
	public static final int MAX_CAPACITEIT = 2000;

	private final int capaciteit;
	private int inhoud;

	/**
	 * Class constructor. Een nieuwe waterfles heeft de opgegeven capaciteit en een
	 * inhoud van 0 ml. <br>
	 * 
	 * - de capaciteit moet tussen 100 en 2000 liggen
	 * 
	 * @param capaciteit de capaciteit van de nieuwe waterfles
	 * @throws IllegalArgumentException voor een ongeldige capaciteit
	 * 
	 */
	public Waterfles(int capaciteit) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * Deze methode verhoogt de inhoud van deze waterfles. <br>
	 * - Een waterfles kan enkel bijgevuld worden met een strikt positieve
	 * hoeveelheid water, hiervoor wordt de inhoud van de waterfles vermeerderd met
	 * de opgegeven hoeveelheid water. <br>
	 * Let op: de waterfles kan overlopen, dit betekent dat de inhoud van de
	 * waterfles na het bijvullen nooit groter zal worden dan de capaciteit van de
	 * waterfles.
	 * 
	 * @param hoeveelheidWater de hoeveelheid water waarmee deze waterfles bijgevuld
	 *                         wordt
	 * @throws IllegalArgumentException voor een niet strikt positieve
	 *                                  <code>hoeveelheidWater</code>
	 */
	public void vulBij(int hoeveelheidWater) {
		// TODO
		throw new UnsupportedOperationException();
	}

	private void controleerCapaciteit(int capaciteit) {
		// TODO
		throw new UnsupportedOperationException();
	}

	private void setInhoud(int inhoud) {
		if (inhoud < 0 || inhoud > MAX_CAPACITEIT)
			throw new IllegalArgumentException(
					String.format("Er kan niet meer dan %d water in de fles", MAX_CAPACITEIT));
		this.inhoud = inhoud;

	}

	public int getCapaciteit() {
		return capaciteit;
	}

	public int getInhoud() {
		return inhoud;
	}
}
