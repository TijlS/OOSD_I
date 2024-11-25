package cui;

import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		DoosApplicatie da = new DoosApplicatie(dc);

		da.start();
	}

}
