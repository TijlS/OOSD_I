package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blackjack {

	private List<Kaart> speelbord;
	private List<Kaart> trekstapel;
	private BigDecimal inzet;

	/**
	 * 
	 * @param inzet
	 */
	public Blackjack(BigDecimal inzet) {
		setInzet(inzet);

		/**
		 * De trekstapek maken en vullen met de kaarten
		 */
		trekstapel = new ArrayList<>();

		String[] kleuren = { "Klavers", "Harten", "Koeken", "Peiken" };
		String[] waarden = { "Aas", "Twee", "Drie", "Vier", "Vijf", "Zes", "Zeven", "Acht", "Negen", "Tien", "Boer",
				"Dame", "Koning" };

		for (String kleur : kleuren) {
			for (String waarde : waarden) {
				trekstapel.add(new Kaart(waarde, kleur));
			}
		}

		Collections.shuffle(trekstapel);

		/**
		 * 2 Kaarten aan het speelbord toevoegen
		 */
		speelbord = new ArrayList<>();
		speelbord.add(trekstapel.removeFirst());
		speelbord.add(trekstapel.removeFirst());
	}

	private void setInzet(BigDecimal inzet) {
		if (inzet.signum() == 1) // -1: -, 0: 0, 1: +
			this.inzet = inzet;
		else
			// TODO - Opnieuw vragen
			this.inzet = BigDecimal.valueOf(5);
	}

	public List<Kaart> getSpeelbord() {
		return this.speelbord;
	}

	public int geefPunten() {
		int punten = 0;
		int aantalAas = 0;

		for (Kaart kaart : speelbord) {
			String waarde = kaart.getWaarde();

			if (waarde.equals("Boer") || waarde.equals("Dame") || waarde.equals("Koning"))
				punten += 10;
			else if (waarde.equals("Aas"))
				aantalAas++;
			else
				punten += getIntWaarde(waarde);
		}

		for (int i = 0; i < aantalAas; i++) {
			if (punten + 11 > 21)
				punten++;
			else
				punten += 11;
		}

		return punten;
	}

	private int getIntWaarde(String waarde) {
		return switch (waarde) {
		case "Twee" -> 2;
		case "Drie" -> 3;
		case "Vier" -> 4;
		case "Vijf" -> 5;
		case "Zes" -> 6;
		case "Zeven" -> 7;
		case "Acht" -> 8;
		case "Negen" -> 9;
		case "Tien" -> 10;
		default -> 0;
		};
	}

	public BigDecimal geefWinst() {
		// 21 met 2 kaarten -> 3x inzet
		if (geefPunten() == 21) {
			if (trekstapel.size() == 2)
				return inzet.multiply(BigDecimal.valueOf(3));
			else if (trekstapel.size() > 2)
				return inzet.multiply(BigDecimal.valueOf(2));
		}
		// Meer dan 21 --> 0
		else if (geefPunten() > 21)
			return BigDecimal.ZERO;

		return inzet;
	}

	public void neemKaart() {
		speelbord.add(trekstapel.getFirst());
	}

	public boolean isPuntenTotaalKleinGenoeg() {
		return geefPunten() <= 21;
	}

}