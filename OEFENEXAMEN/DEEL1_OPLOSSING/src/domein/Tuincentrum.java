package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.PlantMapper;

public class Tuincentrum {
	private List<Plant> planten;
	private final PlantMapper plantMapper;

	public Tuincentrum() {
		plantMapper = new PlantMapper();
		this.planten = plantMapper.geefPlanten();
	}

	public void voegPlantToe(Plant plant) {
		boolean bestaalAl = false;

		for (Plant p : planten) {
			if (p.getNaam().equalsIgnoreCase(plant.getNaam())) {
				bestaalAl = true;
				p.setAantalInVoorraad(p.getAantalInVoorraad() + plant.getAantalInVoorraad());
			}
		}

		if (!bestaalAl)
			this.planten.add(plant);
	}

	public List<Plant> getPlanten() {
		return planten;
	}

	// TODO maakOverzichtPlantenPerHoogte
	public int[] maakOverzichtPlantenPerHoogte() {
		int[] overzichtPerHoogte = new int[] { 0, 0, 0 };

		for (Plant p : planten) {
			if (p.getHoogteInCm() < 80)
				overzichtPerHoogte[0]++;
			else if (p.getHoogteInCm() >= 80 && p.getHoogteInCm() <= 100)
				overzichtPerHoogte[1]++;
			else if (p.getHoogteInCm() > 100)
				overzichtPerHoogte[2]++;
		}

		return overzichtPerHoogte;
	}

	public double bepaalWaardeVerkoop() {
		double totaal = 0;

		for (Plant plant : planten) {
			totaal += plant.berekenVerkoopprijs() * plant.getAantalInVoorraad();
		}

		return totaal;
	}

	public List<Plant> geefPlanten(boolean inVoorraad) {
		List<Plant> resultaat = new ArrayList<>();

		if (!inVoorraad)
			return getPlanten();

		for (Plant plant : planten) {
			if (plant.getAantalInVoorraad() > 0)
				resultaat.add(plant);
		}

		return resultaat;
	}

}
