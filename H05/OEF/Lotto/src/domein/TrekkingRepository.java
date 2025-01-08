package domein;

import java.util.ArrayList;
import java.util.List;

public class TrekkingRepository {

	private List<Trekking> trekkingen;

	public TrekkingRepository() {
		trekkingen = new ArrayList<>();
	}

	/**
	 * 
	 * @param trekking
	 */
	public void voegTrekkingToe(Trekking trekking) {
		trekkingen.add(trekking);
	}

	/**
	 * 
	 * @param naam
	 */
	public Trekking geefTrekking(String naam) {
		for (Trekking trekking : trekkingen) {
			if (trekking.getNaam().equals(naam))
				return trekking;
		}

		return null;
	}

}