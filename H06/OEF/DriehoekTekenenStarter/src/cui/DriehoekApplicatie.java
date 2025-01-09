package cui;

import static domein.Driehoek.TOEGESTANE_TEKENS;

import java.util.Scanner;

import domein.DomeinController;
import domein.Driehoek;
import utils.Orientatie;

public class DriehoekApplicatie {

	private static final String[] HOOFDMENU_OPTIES = { "Grootte wijzigen", "Teken wijzigen", "Orientatie wijzigen",
			"Driehoek tekenen", "Stoppen" };
	private static final String[] ORIENTATIE_OPTIES = init_Orientatie_Opties();

	private static final Scanner invoer = new Scanner(System.in);
	private DomeinController dc;

	public DriehoekApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	private static String[] init_Orientatie_Opties() {
		String[] orientatie_opties = new String[Orientatie.values().length];
		int index = 0;
		for (Orientatie orientatie : Orientatie.values())
			orientatie_opties[index++] = orientatie.toString();
		return orientatie_opties;
	}

	public void start() {
		int keuze = maakMenuKeuze(HOOFDMENU_OPTIES, "MENU");
		while (keuze != 5) {
			switch (keuze) {
			case 1 -> dc.wijzigGrootte(voerGrootteIn());
			case 2 -> dc.wijzigTeken(voerTekenIn());
			case 3 -> dc.wijzigOrientatie(voerOrientatieIn());
			case 4 -> tekenDriehoek();
			}
			keuze = maakMenuKeuze(HOOFDMENU_OPTIES, "MENU");
		}
		System.out.printf("%nTot een volgende keer!");
	}

	private int voerGrootteIn() {
		int grootte;
		boolean geldigeInvoer;

		do {
			System.out.printf("Geef de grootte voor de vorm, zorg dat deze ligt tussen %d en %d: ",
					Driehoek.MIN_GROOTTE, Driehoek.MAX_GROOTTE);
			grootte = invoer.nextInt();

			geldigeInvoer = grootte >= Driehoek.MIN_GROOTTE && grootte <= Driehoek.MAX_GROOTTE;

			if (!geldigeInvoer)
				System.out.println("Dit is geen geldige invoer!");

		} while (!geldigeInvoer);

		return grootte;

	}

	private int voerOrientatieIn() {
		return maakMenuKeuze(ORIENTATIE_OPTIES, "Positie rechte hoek");
	}

	private char voerTekenIn() {
		char teken;
		boolean geldig;
		do {
			System.out.printf("%nDe geldige tekens zijn %s%n", TOEGESTANE_TEKENS);
			System.out.print("Geef het teken voor de vorm: ");
			teken = invoer.next().charAt(0);
			geldig = TOEGESTANE_TEKENS.indexOf(teken) != -1;
			if (!geldig)
				System.out.println("Dit is geen geldig teken, probeer nogmaals...");
		} while (!geldig);
		return teken;
	}

	private void tekenDriehoek() {
		System.out.printf("%n%s", dc.geefVorm());
	}

	private static int maakMenuKeuze(String[] keuzes, String hoofding) {
		int keuze = 0;
		do {
			System.out.printf("%n%s%n", hoofding);
			for (int i = 0; i < keuzes.length; i++) {
				System.out.printf("%d. %s%n", i + 1, keuzes[i]);
			}
			System.out.print("Jouw keuze: ");
			keuze = invoer.nextInt();
		} while (keuze < 1 || keuze > keuzes.length);
		return keuze;
	}
}
