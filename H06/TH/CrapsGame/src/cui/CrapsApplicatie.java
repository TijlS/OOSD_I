package cui;

import domein.DomeinController;

public class CrapsApplicatie {

	private DomeinController dc;

	public CrapsApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void startSpel() {
		dc.speelEersteRonde();
		toonResultaatRonde();
		while (dc.spelIsNogBezig()) {
			dc.speelVerder();
			toonResultaatRonde();
		}
	}

	private void toonResultaatRonde() {
		int[] ogenGeworpen = dc.geefOgenWorp();
		System.out.printf("Speler gooide %d (%d en %d)%n", dc.geefTotaalGeworpen(), ogenGeworpen[0], ogenGeworpen[1]);
		if (dc.spelIsNogBezig())
			System.out.printf("Probeer opnieuw %d te gooien%n", dc.geefTotaalEersteWorp());
		else
			System.out.printf("Resultaat: %s%n", dc.geefSpelStatus());
	}
}
