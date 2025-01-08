package cui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import dto.TrekkingDTO;

public class LottoApplicatie {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);

	private static final int REGISTREER = 1;
	private static final int CONTROLE_NUMMERS = 2;
	private static final int STOP = 3;

	public LottoApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		int keuze = invoerKeuze();

		while (keuze != STOP) {
			switch (keuze) {
			case REGISTREER -> doeRegistreerTrekking();
			case CONTROLE_NUMMERS -> doeControleerTrekking();
			}

			keuze = invoerKeuze();
		}

		System.out.println("Tot de volgende keer!");
	}

	private int invoerKeuze() {
		int keuze;

		do {
			System.out.println("MENU");
			System.out.println("1. Registreer trekking");
			System.out.println("2. Controller nummers");
			System.out.println("3. Stop");
			System.out.println("Maak je keuze: ");
			keuze = input.nextInt();
		} while (keuze < REGISTREER || keuze > STOP);

		return keuze;
	}

	private void doeRegistreerTrekking() {
		System.out.println("Registreer een nieuwe trekking");

		String naam = invoerTekst("Naam van de trekking: ");
		LocalDate datum = invoerDatum();
		List<Integer> getallen = invoerNummers();

		dc.registreerTrekking(naam, datum, getallen);

		System.out.println("De trekking is geregistreerd");
	}

	private void doeControleerTrekking() {
		String naam;
		List<Integer> nummers;
		int keuze;

		naam = invoerTekst("Geef de naam van de trekking waarvoor je de nummers wilt controleren: ");
		dc.selecteerTrekking(naam);

		TrekkingDTO trekkingDTO = dc.geefGeselecteerdeTrekking();

		if (trekkingDTO == null) {
			System.out.println("Geen trekking gevonden");
		} else {
			System.out.printf("Trekking gevonden met naam %s en datum %s%n", trekkingDTO.naam(), trekkingDTO.datum());

			do {
				System.out.printf("Geef jouw nummers in.%n");

				nummers = invoerNummers();
				int winst = dc.geefWinst(nummers);

				System.out.printf("Je winst: €%d.%n", winst);

				keuze = invoerNogControleren();
			} while (keuze == 1);
		}
	}

	private int invoerNogControleren() {
		int keuze;

		do {
			System.out.println("Wil je nog nummers controleren voor deze trekking (1:ja, 2:nee)? ");
			keuze = input.nextInt();
		} while (keuze < 1 || keuze > 2);
		return keuze;
	}

	private String invoerTekst(String insctructie) {
		System.out.print(insctructie);
		String tekst = input.next();
		return tekst;
	}

	private LocalDate invoerDatum() {
		System.out.print("Geef de dag van de trekking (1 - 31): ");
		int day = input.nextInt();

		System.out.print("Geef de maand van de trekking (1 - 12): ");
		int month = input.nextInt();

		System.out.print("Geef het jaartal van de trekking: ");
		int year = input.nextInt();

		return LocalDate.of(year, month, day);
	}

	private List<Integer> invoerNummers() {
		List<Integer> nummers = new ArrayList<>();

		for (int i = 0; i < dc.aantalNummers(); i++) {
			System.out.printf("Geef %d%s nummer in: ", i + 1, i == 0 ? "ste" : "de");
			nummers.add(input.nextInt());
		}

		return nummers;
	}

}
