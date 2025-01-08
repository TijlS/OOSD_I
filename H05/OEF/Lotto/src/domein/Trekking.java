package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trekking {

	private String naam;
	private LocalDate datum;
	private List<Integer> nummers;
	public static final int AANTAL_NUMMERS = 6;

	/**
	 * 
	 * @param naam
	 * @param datum
	 * @param nummers
	 */
	public Trekking(String naam, LocalDate datum, List<Integer> nummers) {
		this.naam = naam;
		this.datum = datum;
		this.setNummers(nummers);
	}

	private void setNummers(List<Integer> nummers) {
		if (nummers.size() != AANTAL_NUMMERS)
			throw new IllegalArgumentException(
					String.format("Er moeten exact %d nummers worden ingegeven!", AANTAL_NUMMERS));

		List<Integer> nummersCheck = new ArrayList<>();

		for (int i = 0; i < nummers.size(); i++) {
			if (nummersCheck.contains(nummers.get(i)))
				throw new IllegalArgumentException("Elk nummer mag maar 1x voorkomen!");
		}

		this.nummers = nummers;
	}

	public String getNaam() {
		return this.naam;
	}

	public LocalDate getDatum() {
		return this.datum;
	}

	/**
	 * 
	 * @param nummers
	 */
	public int geefWinst(List<Integer> nummers) {
		int aantalJuisteNummers = 0;

		for (Integer nummer : nummers) {
			if (this.nummers.contains(nummer))
				aantalJuisteNummers++;
		}

		return aantalJuisteNummers <= 2 ? 0 : aantalJuisteNummers <= 4 ? 5 : aantalJuisteNummers == 5 ? 10 : 50;
	}

}