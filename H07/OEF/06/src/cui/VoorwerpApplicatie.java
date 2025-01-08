package cui;

import domein.DomeinController;
import dto.VoorwerpDTO;

public class VoorwerpApplicatie {
	private DomeinController dc;

	public VoorwerpApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		System.out.println("=== OVERZICHT VOOR HET TOEVOEGEN ===");
		toonOverzicht();

		System.out.println();
		System.out.println();

		dc.voegWapenToe("Excallibur", 7.5, 5, 100, false);
		dc.voegSleutelToe("zijdeur", 0.1, 3, 50);
		dc.voegSleutelToe("kasteelpoort", 0.25, 4, 58);

		System.out.println("=== OVERZICHT NA HET TOEVOEGEN ===");
		toonOverzicht();
	}

	private void toonOverzicht() {
		VoorwerpDTO[] voorwerpen = dc.geefVoorwerpDTOs();

		for (VoorwerpDTO v : voorwerpen) {
			if (v.soort() == 'S') {
				System.out.printf("Sleutel %s met gewicht %.3f kg uit niveau %d past op deur %d.%n", v.naam(),
						v.gewicht(), v.niveau(), v.deur());
				System.out.printf("Er zijn %d sleutels in omloop.%n", v.aantalInOmloop());
			}
			if (v.soort() == 'W') {
				System.out.printf("Wapen %s met gewicht %.3f kg uit niveau %d en kracht %d %s gebruikt.%n", v.naam(),
						v.gewicht(), v.niveau(), v.kracht(), v.gebruikt() ? "is al" : "nog niet");
			}

		}
	}
}
