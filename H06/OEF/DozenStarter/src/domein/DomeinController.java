package domein;

import java.util.ArrayList;
import java.util.List;

import dto.DoosDTO;

public class DomeinController {
	private List<Doos> dozen;

	public DomeinController() {
		this.dozen = new ArrayList<>();
	}

	public void maakDoos() {
		this.dozen.add(new Doos());
	}

	public void maakDoos(String kleur) {
		this.dozen.add(new Doos(kleur));
	}

	public void maakDoos(double lengte, double breedte, double hoogte) {
		this.dozen.add(new Doos(lengte, breedte, hoogte));
	}

	public void maakDoos(double lengte, double breedte, double hoogte, String kleur) {
		this.dozen.add(new Doos(lengte, breedte, hoogte, kleur));
	}

	public DoosDTO[] geefAlleDozen() {
		DoosDTO[] doosDTOs = new DoosDTO[dozen.size()];

		for (int i = 0; i < doosDTOs.length; i++) {
			Doos huidigeDoos = dozen.get(i);
			doosDTOs[i] = new DoosDTO(huidigeDoos.getLengte(), huidigeDoos.getBreedte(), huidigeDoos.getHoogte(),
					huidigeDoos.getKleur(), huidigeDoos.getCode());
		}

		return doosDTOs;
	}

	public int geefAantalDozen() {
		return Doos.getAantalDozenGemaakt();
	}
}
