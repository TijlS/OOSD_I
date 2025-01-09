package cui;

import java.util.Scanner;

import domein.DomeinController;
import dto.PlantDTO;

public class TuincentrumApplicatie {
	private final DomeinController dc;

	private Scanner input = new Scanner(System.in);

	public TuincentrumApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		String[] menuKeuzes = { "Toon overzicht alle planten", "Toon overzicht voorradige planten", "Voeg plant toe",
				"Geef overzicht per hoogte", "Geef verkoopwaarde", "Stoppen" };
		int keuze = maakMenuKeuze(menuKeuzes, "Wat kies je? ");

		while (keuze != 6) {
			switch (keuze) {
			case 1 -> geefPlantenInVoorraad(false);
			case 2 -> geefPlantenInVoorraad(true);
			case 3 -> voegPlantToe();
			case 4 -> maakOverzichtPlantenPerHoogte();
			case 5 -> {
				System.out.printf("Verkoopwaarde: %.2f%n", dc.bepaalWaardeVerkoop());
			}
			}

			System.out.println();
			keuze = maakMenuKeuze(menuKeuzes, "Wat kies je? ");
		}

		System.out.println("Tot de volgende keer!");

	}

	private int maakMenuKeuze(String[] keuzes, String hoofding) {
		int i = 0;
		for (; i < keuzes.length; i++) {
			System.out.printf("%d. %s%n", i + 1, keuzes[i]);
		}

		System.out.print(hoofding);
		int keuze = input.nextInt();

		while (keuze < 0 || keuze > i) {
			System.out.println("Geen geldige keuze");

			System.out.print(hoofding);
			keuze = input.nextInt();
		}

		return keuze;
	}

	private void voegPlantToe() {
		System.out.print("Wat is de naam van de plant? ");
		String naam = input.next();

		System.out.print("Wat is de soortcode van de plant (A, B of C)? ");
		char soortCode = input.next().charAt(0);

		System.out.print("Wat is de hoogte van de plant in cm? ");
		int hoogteInCm = input.nextInt();

		System.out.print("Wat is de prijs van de plant? €");
		double prijsInEuro = input.nextDouble();

		System.out.print("Hoeveel zijn er in voorraad? ");
		int aantalInVoorraad = input.nextInt();

		dc.voegPlantToe(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad);
	}

	// Bepaal aantal planten tss 0-80cm, 80cm-1m, groter dan 1 m
	private void maakOverzichtPlantenPerHoogte() {
		int[] overzicht = dc.maakOverzichtPlantenPerHoogte();

		System.out.printf("%20s%20s%20s%n", "Kleiner dan 80cm", "80-100cm", "Groter dan 1m");
		System.out.printf("%20d%20d%20d%n", overzicht[0], overzicht[1], overzicht[2]);
	}

	private void geefPlantenInVoorraad(boolean inVoorraad) {
		PlantDTO[] planten = dc.geefAllePlanten(inVoorraad);

		System.out.printf("Overzicht van de planten%s:%n", inVoorraad ? "in voorraad" : "");

		for (PlantDTO p : planten) {
			System.out.printf("%S met code %s, %dcm hoog, kost: EUR %.2f: %d in voorraad%n", p.naam(), p.soortCode(),
					p.hoogteInCm(), p.prijsInEuro(), p.aantalInVoorraad());
		}

	}
}
