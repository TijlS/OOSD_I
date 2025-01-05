package domein;

import dto.KaartDTO;

public class DomeinController {

	private HogerLager hogerLager;

	public void startHogerLager() {
		hogerLager = new HogerLager();
	}

	/**
	 * 
	 * @param hogerLager
	 */
	public void raadHogerLager(boolean hogerLager) {
		this.hogerLager.raadHogerLager(hogerLager);
	}

	public KaartDTO geefHuidigeKaart() {
		return new KaartDTO(hogerLager.getHuidigeKaart().getWaarde(), hogerLager.getHuidigeKaart().getKleur());
	}

	public boolean isCorrectGeraden() {
		return hogerLager.isCorrectGeraden();
	}

	public boolean isEindeSpel() {
		return hogerLager.isEindeSpel();
	}

	public int geefScore() {
		return hogerLager.getScore();
	}

	public boolean isGewonnen() {
		return hogerLager.isGewonnen();
	}

}