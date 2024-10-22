package cui;

import domain.KauwgomAutomaat;

public class KauwgomAutomaatInterface {

	public static void main(String[] args) {
		KauwgomAutomaatInterface kai = new KauwgomAutomaatInterface();

		kai.speelMetAutomaat();
	}

	private void speelMetAutomaat() {
		int getal1 = 22;
		int getal2 = 33;
		getal2 = getal1;

		KauwgomAutomaat mijnAutomaat = new KauwgomAutomaat(100, "rood");
		KauwgomAutomaat mijnAutomaat2 = new KauwgomAutomaat(150, "blauw");

		mijnAutomaat = mijnAutomaat2;
		mijnAutomaat.setKleur("groen");

		System.out.printf("Kleur1: %s%nKleur2: %s%n", mijnAutomaat.getKleur(), mijnAutomaat2.getKleur());

		mijnAutomaat.werpMuntIn();

		System.out.printf("De kleur van de automaat is %s%n", mijnAutomaat.getKleur());
		System.out.printf("De automaat bevat %d kauwgomballen.%n", mijnAutomaat.getAantalKauwgomBallen());
		System.out.printf("Er is %seen munt ingeworpen%n", mijnAutomaat.isMuntIngeworpen() ? "" : "g");

		mijnAutomaat.draaiHendel();

		mijnAutomaat.vulBij(500);

		System.out.printf("De kleur van de automaat is %s%n", mijnAutomaat.getKleur());
		System.out.printf("De automaat bevat %d kauwgomballen.%n", mijnAutomaat.getAantalKauwgomBallen());
		System.out.printf("Er is %seen munt ingeworpen%n", mijnAutomaat.isMuntIngeworpen() ? "" : "g");
	}

}
