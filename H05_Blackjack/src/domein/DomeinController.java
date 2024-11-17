package domein;

import java.math.BigDecimal;
import java.util.List;

import dto.KaartDTO;

public class DomeinController {

	private Blackjack blackjack;

	/**
	 * 
	 * @param inzet
	 */
	public void startBlackjack(BigDecimal inzet) {
		// TODO - inzet vragen
		blackjack = new Blackjack(inzet);
	}

	public KaartDTO[] geefSpeelbord() {
		List<Kaart> kaarten = blackjack.getSpeelbord();
		KaartDTO[] kaartenDTOs = new KaartDTO[kaarten.size()];

		for (int i = 0; i < kaartenDTOs.length; i++) {
			Kaart currentKaart = kaarten.get(i);
			kaartenDTOs[i] = new KaartDTO(currentKaart.getWaarde(), currentKaart.getKleur());
		}

		return kaartenDTOs;
	}

	public int geefPunten() {
		return blackjack.geefPunten();
	}

	public void neemKaart() {
		blackjack.neemKaart();
	}

	public BigDecimal geefWinst() {
		return blackjack.geefWinst();
	}

	public boolean isPuntenTotaalOnder21() {
		return blackjack.isPuntenTotaalKleinGenoeg();
	}

}