package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class RechthoekApplicatie {

	public static void main(String[] args) {
		new RechthoekApplicatie().werkMetPassByValue();
	}

	private void werkMetPassByValue() {

		double argLengte = 33;
		double argBreedte = 33;
		Coordinaat argCoordinaat = new Coordinaat(3, 3);
		Rechthoek mijnRechthoek = new Rechthoek(-1, 1, new Coordinaat(1, 1));

		// voorbeeld: argumenten zijn literals
		mijnRechthoek.verschuif("links", 100);
		mijnRechthoek.verschuif("boven", 25);

		// voorbeeld: argumenten zijn complexere expressies
		mijnRechthoek.verschuif("bo" + "ven", 10 * 3);
		int afstand = 20;
		mijnRechthoek.verschuif("boven", 5 * 2 + afstand);
		mijnRechthoek.verschuif("bo" + "ven", mijnRechthoek.geefXpos()); // <1>

		// voorbeeld: doorgeven van een referentievariabele, i.e. een referentie naar
		// een Coordinaat-object
		System.out.println("Voor aanroep");
		System.out.println(String.format("  argCoordinaat: %s", argCoordinaat));
		System.out.println(String.format("  argLengte: %.2f", argLengte));
		System.out.println(String.format("  argBreedte: %.2f", argBreedte));

		mijnRechthoek.wijzigParameters(argLengte, argBreedte, argCoordinaat); // <2>

		System.out.println("\nNa aanroep mijnRechthoek.wijzigParameters(argLengte, argBreedte, argCoordinaat)");
		System.out.println(String.format("  argCoordinaat: %s", argCoordinaat));
		System.out.println(String.format("  argLengte: %.2f", argLengte));
		System.out.println(String.format("  argBreedte: %.2f", argBreedte));
	}

}
