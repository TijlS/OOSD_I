package cui;

import java.util.Scanner;

import domein.DomeinController;
import dto.KaartDTO;

public class HogerLagerApplicatie {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private final int HOGER = 0;

	public HogerLagerApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void startHogerLagerSpel() {
		KaartDTO nieuweKaart;
		boolean hoger;

		System.out.println("Welkom bij Hoger Lager");
		dc.startHogerLager();
		nieuweKaart = dc.geefHuidigeKaart();

		do {
			System.out.printf("De huidige kaart is: %d van %s%n", nieuweKaart.waarde(), nieuweKaart.kleur());

			hoger = (invoerKeuze() == HOGER);

			dc.raadHogerLager(hoger);
			nieuweKaart = dc.geefHuidigeKaart();

			System.out.printf("De nieuwe kaart is: %d van %s%n", nieuweKaart.waarde(), nieuweKaart.kleur());
			System.out.printf("Je hebt dus %S geraden.%n", dc.isCorrectGeraden() ? "juist" : "fout");
			System.out.printf("Je score is: %d%n", dc.geefScore());

		} while (!dc.isEindeSpel());

		System.out.printf("Je score is %d%n%n", dc.geefScore());
		System.out.printf("Je hebt het spel %S%n", dc.isGewonnen() ? "gewonnen" : "verloren");

	}

	private int invoerKeuze() {
		int keuze;

		do {
			System.out.println("Zal de volgende kaaert Hoger (0) of Lager (1) zijn?: ");
			keuze = input.nextInt();
		} while (keuze < 0 || keuze > 1);
		return keuze;
	}
}
