package cui;

import java.util.Scanner;

import domein.Tankstation;

public class TankstationApp {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new TankstationApp().startTanken();

		input.close();
	}

	private void startTanken() {
		Tankstation tankstation = new Tankstation();

		int pompNummer = geefPompNummer();
		int aantalBeurten = 0, aantalLiterGetankt = 0;

		while (pompNummer != 0) {
			int aantalLiter = geefAantalLiter();

			boolean getankt = tankstation.tank(pompNummer, aantalLiter);
			if (getankt) {
				aantalBeurten++;
				aantalLiterGetankt += aantalLiter;

				System.out.printf("Je hebt %d liter getankt aan pomp %d.%n", pompNummer, aantalLiter);
			} else
				System.out.printf("Sorry, er is onvoldoende brandstof aan pomp %d%n", pompNummer);

			System.out.println("\nOverzicht pompen:");
			System.out.println(tankstation.toString());

			pompNummer = geefPompNummer();
		}

		System.out.printf("Er werd in totaal %d liter getankt in %d tankbeurten.", aantalLiterGetankt, aantalBeurten);
	}

	private int geefAantalLiter() {
		boolean aantalLiterIsValid;
		int aantalLiter;

		do {
			System.out.print("Hoeveel liter wens je te tanken (5 tot 80)? ");
			aantalLiter = input.nextInt();

			aantalLiterIsValid = aantalLiter >= 5 && aantalLiter <= 80;

			if (!aantalLiterIsValid)
				System.out.println("Je moet minstens 5 en kan maximaal 80 liter tanken...");
		} while (!aantalLiterIsValid);

		return aantalLiter;
	}

	private int geefPompNummer() {
		boolean pompNummerIsValid;
		int pompNummer;

		do {
			System.out.print("Aan welke pomp wil je tanken (1-5), druk 0 om te stoppen? ");
			pompNummer = input.nextInt();

			pompNummerIsValid = pompNummer >= 0 && pompNummer <= 5;

			if (!pompNummerIsValid)
				System.out.printf("We hebben geen pomp met nummer %d! Probeer opnieuw...%n", pompNummer);
		} while (!pompNummerIsValid);

		return pompNummer;
	}
}
