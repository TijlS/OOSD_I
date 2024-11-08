package cui;

import java.util.Scanner;

import domein.DomeinController;

public class DobbelsteenApp {

	private static Scanner input = new Scanner(System.in);
	private DomeinController dc;

	public DobbelsteenApp(DomeinController dc) {
		this.dc = dc;
	}

	public static void main(String[] args) {
		DobbelsteenApp da = new DobbelsteenApp(new DomeinController());

		da.speelDobbelsteenSpel();

		input.close();
	}

	private void speelDobbelsteenSpel() {
		toonStartScherm();

		while (!dc.isEindeSpel()) {
			toonRolScherm();
		}

		System.out.printf("Einde van het spel, %nje score is %d", dc.geefScore());
	}

	private void toonStartScherm() {
		wachtVoorKlikOpKnop("Start");
		dc.startNieuwSpel();
	}

	private void wachtVoorKlikOpKnop(String knop) {
		System.out.printf("Druk op <enter> om te klikken op de knop %s...", knop);
		input.nextLine();
	}

	private void toonRolScherm() {
		wachtVoorKlikOpKnop("Rol");
		dc.rolDobbelstenen();
		System.out.printf("%n----> aantal ogen geworpen: %d%n%n", dc.geefAantalOgenWorp());
	}

}
