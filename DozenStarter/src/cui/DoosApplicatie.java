package cui;

import domein.DomeinController;
import dto.DoosDTO;

public class DoosApplicatie {

	private DomeinController dc;

	public DoosApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		dc.maakDoos();
		dc.maakDoos("oranje");
		dc.maakDoos(1, 20.5, 30.5);
		dc.maakDoos(5.5, 6.5, 2, "geel");

		drukOverzichtAf();
	}

	public void drukOverzichtAf() {
		System.out.printf("Er werden %d dozen aangemaakt: %n", dc.geefAantalDozen());

		DoosDTO[] dozen = dc.geefAlleDozen();

		for (int i = 0; i < dozen.length; i++) {
			DoosDTO huidigeDoos = dozen[i];
			System.out.println(String.format("%d. Doos van %.2f x %.2f x %.2f; kleur: %s; unieke code: %s", i + 1,
					huidigeDoos.lengte(), huidigeDoos.breedte(), huidigeDoos.hoogte(), huidigeDoos.kleur(),
					huidigeDoos.code()));
		}
	}

}
