package cui;

import java.util.Scanner;

import domein.DomeinController;

public class DobbelsteenApp {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		DobbelsteenApp da = new DobbelsteenApp();

		da.speelDobbelsteenSpel();

		input.close();
	}

	private void speelDobbelsteenSpel() {
		DomeinController dc = new DomeinController();

		toonMenu();
		int keuze = geefMenuKeuze();

		switch (keuze) {
		case 0 -> System.out.println("Tot de volgende keer!");
		case 1 -> dc.startNieuwSpel();

		default -> throw new IllegalArgumentException("Unexpected value: " + keuze);
		}

		System.out.println("Applicatie wordt gesloten");
	}

	private void toonMenu() {
		System.out.println("MENU");
		System.out.println("0. Stop");
		System.out.println("1. Start nieuw spel");
	}

	private int geefMenuKeuze() {
		System.out.println("Maak je keuze: ");
		return input.nextInt();
	}

}
