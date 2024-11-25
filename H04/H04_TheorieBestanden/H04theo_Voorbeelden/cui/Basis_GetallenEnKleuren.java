package cui;

import java.security.SecureRandom;

public class Basis_GetallenEnKleuren {

	public static void main(String[] args) {
		new Basis_GetallenEnKleuren().toonVoorbeelden();

	}

	private void toonVoorbeelden() {
		int[] getallen;
		getallen = new int[10]; // via de variabele getallen hebben we een verzameling van 10 getallen

		String[] kleuren = new String[5]; // via de variabele kleuren hebben we een verzameling van 5 Strings

		toonGetallen();
		toonStrings(kleuren);
		berekenSomMetKlassiekeFor();
		berekenSomMetEnhancedFor();

		getallen[0] = -10;
		getallen[3] = 20;
		getallen[9] = getallen[3] + 50;

		kleuren[0] = "rood";
		kleuren[1] = "geel";
		kleuren[2] = "groen";
		kleuren[3] = "oranje";
		kleuren[4] = "citroen" + kleuren[1];

		int i = 5;
		getallen[i] = 30;
		getallen[i % 2] = -30;
		getallen[i / 2] = i / 2;
		toonGetallen();
		toonStrings(kleuren);

		werpAIOOBException();
	}

	// tag::methodeToonIntArray[]
	private void toonGetallen() {
		SecureRandom sr = new SecureRandom();
		int[] getallen;
		if (sr.nextBoolean())
			getallen = new int[] { -10, -30, 2, 20, 0, 30, 0, 0, 0, 70 };
		else
			getallen = new int[] { 12, 8, 20 };
		System.out.printf("De array bevat %d elementen:%n", getallen.length);
		for (int index = 0; index < getallen.length; index++) {
			System.out.printf("- op index %d zit element %d.%n", index, getallen[index]);
		}
	}
	// end::methodeToonIntArray[]

	private void berekenSomMetKlassiekeFor() {
		// tag::methodeGeefSom01[]
		double[] getallen = { 23.12, 2.56, 88, 97.4 };
		double som = 0;
		for (int index = 0; index < getallen.length; index++) { // <.>
			som += getallen[index];
		}
		System.out.printf("De som is %.3f", som); // De som is 211,080
		// end::methodeGeefSom01[]
	}

	private void berekenSomMetEnhancedFor() {
		// tag::methodeGeefSom02[]
		double[] getallen = { 23.12, 2.56, 88, 97.4 };
		double som = 0;
		for (double getal : getallen) { // <.>
			som += getal;
		}
		System.out.printf("De som is %.3f", som); // De som is 211,080
		// end::methodeGeefSom02[]
	}

	private void maakAlleNegatieveGetallenNul_Klassiek() { // <.>
		// tag::vbWijzigKlassiekeFor[]
		int[] getallenmix = { -5, 10, -2, -1, 0, 23 };
		for (int index = 0; index < getallenmix.length; index++) {
			if (getallenmix[index] < 0)
				getallenmix[index] = 0; // <.>
		}

		// <.>
		// Resultaat, inhoud van de array getallenmix:
		// - op index 0 zit element 0.
		// - op index 1 zit element 10.
		// - op index 2 zit element 0.
		// - op index 3 zit element 0.
		// - op index 4 zit element 0.
		// - op index 5 zit element 23.
		// end::vbWijzigKlassiekeFor[]
	}

	private void maakAlleNegatieveGetallenNul_Enhanced() { // <.>
		// tag::vbWijzigEnhancedFor[]
		int[] getallenmix = new int[] { -5, 10, -2, -1, 0, 23 };
		for (int getal : getallenmix) {
			if (getal < 0)
				getal = 0; // <.>
		}

		// <.>
		// Resultaat, inhoud van de array getallenmix:
		// - op index 0 zit element -5.
		// - op index 1 zit element 10.
		// - op index 2 zit element -2.
		// - op index 3 zit element -1.
		// - op index 4 zit element 0.
		// - op index 5 zit element 23.
		// end::vbWijzigEnhancedFor[]
	}

	private void toonStrings(String[] strings) {
		for (int index = 0; index < strings.length; index++) {
			System.out.printf("%15d", index);
		}
		System.out.println();
		for (int index = 0; index < strings.length; index++) {
			System.out.printf("%15s", strings[index]);
		}
		System.out.println();
	}

//	// tag::methodeCopyArray[]
//	private int[] geefCopyMetAlleNegatieveGetallenNul(int[] getallen) { // <.>
//		int[] resultaat = new int[getallen.length]; // <.>
//		for (int index = 0; index < getallen.length; index++) {
//			resultaat[index] = getallen[index] < 0 ? 0 : getallen[index]; // <.>
//		}
//		return resultaat;
//	}
//	// end::methodeCopyArray[]

	private void werpAIOOBException() {
		String[] kleuren = { "rood", "geel", "groen", "roze", "paars" };
		int aantalKleuren = kleuren.length;
		kleuren[aantalKleuren] = "wit";
	}
}

// De array bevat 3 elementen:
// - op index 0 zit element 12.
// - op index 1 zit element 8.
// - op index 2 zit element 20.
