package domein;

import java.util.List;

import dto.VoorwerpDTO;

public class DomeinController {
	private VoorwerpRepository rr;

	public DomeinController() {
		rr = new VoorwerpRepository();
	}

	public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
		rr.voegVoorwerpToe(new Wapen(naam, gewicht, niveau, kracht, gebruikt));
	}

	public void voegSleutelToe(String naam, double gewicht, int niveau, int deur) {
		rr.voegVoorwerpToe(new Sleutel(naam, gewicht, niveau, deur));
	}

	public VoorwerpDTO[] geefVoorwerpDTOs() {
		List<Voorwerp> voorwerpen = rr.getVoorwerpen();
		VoorwerpDTO[] voorwerpDTOs = new VoorwerpDTO[voorwerpen.size()];

		for (int i = 0; i < voorwerpen.size(); i++) {
			Voorwerp v = voorwerpen.get(i);

			if (v instanceof Wapen w) {
				voorwerpDTOs[i] = new VoorwerpDTO(w.getNaam(), w.getGewicht(), w.getNiveau(), w.getKracht(),
						w.isGebruikt());
			}
			if (v instanceof Sleutel s) {
				voorwerpDTOs[i] = new VoorwerpDTO(s.getNaam(), s.getGewicht(), s.getNiveau(),
						Sleutel.getAantalInOmloop(), s.getDeur());
			}
		}

		return voorwerpDTOs;
	}
}
