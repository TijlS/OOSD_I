package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HogerLager {

	private Kaart huidigeKaart;
	private List<Kaart> trekstapel;
	private int score;
	private boolean correctGeraden;

	public static final boolean HOGER = true;
	public static final boolean LAGER = !HOGER;

	public HogerLager() {
		maakKaarten();

		Collections.shuffle(trekstapel);
		huidigeKaart = trekKaart();
	}

	private void maakKaarten() {
		String[] kleuren = { "Klaveren", "Peiken", "Harten", "Koeken" };

		trekstapel = new ArrayList<>();

		for (String kleur : kleuren) {
			for (int waarde = 1; waarde <= 13; waarde++) {
				trekstapel.add(new Kaart(waarde, kleur));
			}
		}
	}

	private Kaart trekKaart() {
		if (trekstapel.isEmpty())
			return null;

		return trekstapel.remove(0);
	}

	public int getScore() {
		return this.score;
	}

	public boolean isCorrectGeraden() {
		return this.correctGeraden;
	}

	public Kaart getHuidigeKaart() {
		return this.huidigeKaart;
	}

	/**
	 * 
	 * @param hogerLager
	 */
	public void raadHogerLager(boolean hogerLager) {
		int waardeVorigeKaart = huidigeKaart.getWaarde();

		huidigeKaart = trekKaart();

		if (huidigeKaart == null) {
			correctGeraden = false;
			return;
		}

		int waardeHuidigeKaart = huidigeKaart.getWaarde();

		correctGeraden = (hogerLager == HOGER && waardeVorigeKaart <= waardeHuidigeKaart)
				|| (hogerLager == LAGER && waardeVorigeKaart >= waardeHuidigeKaart);

		if (correctGeraden)
			score++;
	}

	public boolean isEindeSpel() {
		return trekstapel.isEmpty() || isGewonnen();
	}

	public boolean isGewonnen() {
		return score == 15;
	}

}