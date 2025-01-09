package domein;

import java.util.List;

import dto.PlantDTO;

public class DomeinController {
	private Tuincentrum tuincentrum;

	public DomeinController() {
		this.tuincentrum = new Tuincentrum();
	}

	public void voegPlantToe(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
		tuincentrum.voegPlantToe(new Plant(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad));

	}

	public PlantDTO[] geefAllePlanten(boolean inVoorraad) {
		List<Plant> planten = tuincentrum.geefPlanten(inVoorraad);
		PlantDTO[] plantenDTO = new PlantDTO[planten.size()];

		for (int i = 0; i < plantenDTO.length; i++) {
			Plant p = planten.get(i);

			plantenDTO[i] = new PlantDTO(p.getNaam(), p.getSoortCode(), p.getHoogteInCm(), p.getAantalInVoorraad(),
					p.getPrijsInEuro());
		}

		return plantenDTO;
	}

	public double bepaalWaardeVerkoop() {
		return tuincentrum.bepaalWaardeVerkoop();
	}

	public int[] maakOverzichtPlantenPerHoogte() {
		return tuincentrum.maakOverzichtPlantenPerHoogte();
	}

}
