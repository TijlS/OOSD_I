package domein;

import utils.Status;

public class DomeinController {
	private Craps craps = new Craps();

	public void speelEersteRonde() {
		craps.speelEersteRonde();
	}

	public void speelVerder() {
		craps.speelVerder();
	}

	public boolean spelIsNogBezig() {
		return craps.isNogBezig();
	}

	public int[] geefOgenWorp() {
		return craps.geefAantalOgenDobbelStenen();
	}

	public int geefTotaalGeworpen() {
		return craps.geefTotaalGeworpen();
	}

	public int geefTotaalEersteWorp() {
		return craps.getTotaalEersteWorp();
	}

	public Status geefSpelStatus() {
		return craps.getSpelStatus();
	}

}
