package startup;

import cui.LottoApplicatie;
import domein.DomeinController;

public class StartUp {
	public static void main(String[] args) {
		new LottoApplicatie(new DomeinController()).start();
		;
	}

}
