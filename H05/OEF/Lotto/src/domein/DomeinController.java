package domein;

import java.time.LocalDate;
import java.util.List;

import dto.TrekkingDTO;

public class DomeinController {

	private TrekkingRepository trekkingRepository;
	private Trekking geselecteerdeTrekking;

	public DomeinController() {
		this.trekkingRepository = new TrekkingRepository();
	}

	/**
	 * 
	 * @param naam
	 * @param datum
	 * @param nummers
	 */
	public void registreerTrekking(String naam, LocalDate datum, List<Integer> nummers) {
		trekkingRepository.voegTrekkingToe(new Trekking(naam, datum, nummers));
	}

	/**
	 * 
	 * @param naam
	 */
	public void selecteerTrekking(String naam) {
		this.geselecteerdeTrekking = trekkingRepository.geefTrekking(naam);
	}

	public TrekkingDTO geefGeselecteerdeTrekking() {
		if (geselecteerdeTrekking == null)
			return null;

		return new TrekkingDTO(geselecteerdeTrekking.getNaam(), geselecteerdeTrekking.getDatum());
	}

	/**
	 * 
	 * @param nummers
	 */
	public int geefWinst(List<Integer> nummers) {
		return geselecteerdeTrekking.geefWinst(nummers);
	}

	public int aantalNummers() {
		return Trekking.AANTAL_NUMMERS;
	}

}