package cui;

import java.time.LocalDate;
import java.util.Scanner;

import domein.DomeinController;
import dto.SpelerDTO;

public class DobbelsteenApp {

	private static Scanner input = new Scanner(System.in);
	private DomeinController dc;

	public DobbelsteenApp(DomeinController dc) {
		this.dc = dc;
	}

	public static void main(String[] args) {
		DobbelsteenApp da = new DobbelsteenApp(new DomeinController());

		da.registreer();
		da.meldAan();

//		da.speelDobbelsteenSpel();

		input.close();
	}

	private void speelDobbelsteenSpel() {
		toonStartScherm();

		while (!dc.isEindeSpel()) {
			toonRolScherm();
		}

		System.out.printf("Einde van het spel, %nje score is %d", dc.geefScore());
	}

	private void registreer() {
		dc.registreer("Schipper", "Tijl", "tijl.schipper@student.hogent.be", LocalDate.of(2006, 12, 28), "ww", "ww");
	}

	private void meldAan() {
		dc.meldAan("tijl.schipper@student.hogent.be", "ww");
		SpelerDTO aangemeld = dc.geefSpeler();

		System.out.printf("Welkom %s %s, je bent %sadministrator en je krediet is %d.%n", aangemeld.voornaam(),
				aangemeld.naam(), aangemeld.adminrechten() ? "" : "geen ", aangemeld.krediet());
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
