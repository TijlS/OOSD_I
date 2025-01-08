package domein;

import java.util.ArrayList;
import java.util.List;

public class ResultatenLijst {
	private final int MIN_RESULTAAT = 0;
	private final int MAX_RESULTAAT = 20;
	private final int MAX_AANTAL_RESULTATEN = 5;

	private List<Integer> resultaten;

	public ResultatenLijst() {
		resultaten = new ArrayList<>();
	}

	public List<Integer> getResultaten() {
		return resultaten;
	}

	public void voegResultaatToe(int resultaat) {
		if (resultaat < MIN_RESULTAAT || MAX_RESULTAAT < resultaat)
			throw new IllegalArgumentException(
					String.format("Resultaat moet in interval [%d, %d] liggen!", MIN_RESULTAAT, MAX_AANTAL_RESULTATEN));
		if (resultaten.size() >= MAX_AANTAL_RESULTATEN)
			throw new IllegalArgumentException(
					String.format("Er zijn al %d resulataten opgegeven!", MAX_AANTAL_RESULTATEN));

		resultaten.add(resultaat);
	}

	public double geefGemiddelde() {
		if (resultaten.size() == 0)
			throw new IllegalArgumentException("Er zijn geen getallen opgegeven!");

		double totaal = 0;
		for (Integer integer : resultaten) {
			totaal += integer;
		}

		return totaal / resultaten.size();
	}

}
