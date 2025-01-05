package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class ComplexApplicatie {
	private Scanner invoer;
	private DomeinController dc;

	public ComplexApplicatie(DomeinController dc) {
		this.dc = dc;
		this.invoer = new Scanner(System.in);
	}

	public void start() {
		String antwoord = voerAntwoordIn();

		while (antwoord.equalsIgnoreCase("ja")) {
			voegGetalToe();
			toonAlleGetallen();
			invoer.nextLine();

			antwoord = voerAntwoordIn();
		}
		System.out.println("Tot een volgende keer!");
	}

	private String voerAntwoordIn() {
		boolean geldigeInvoer;
		String antwoord;

		do {
			System.out.print("Wens je een complex getal toe te voegen (ja/nee)? ");
			antwoord = invoer.nextLine();
			geldigeInvoer = antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("nee");
			if (!geldigeInvoer)
				System.out.println("Gelieve met ja of nee te antwoorden...");
		} while (!geldigeInvoer);

		return antwoord;
	}

	private void voegGetalToe() {
		double reeel = voegEenGetalToe("reele");
		double imaginair = voegEenGetalToe("imaginaire");

		dc.voegComplexGetalToe(reeel, imaginair);
	}

	private double voegEenGetalToe(String deel) {
		System.out.printf("Geef het %s deel: ", deel);
		return invoer.nextDouble();
	}

	private void toonAlleGetallen() {
		if (dc.geefAlleComplexeGetallen().isEmpty()) {
			System.out.println("Er zijn nog geen complexe getallen ingevoerd...");
			return;
		}

		System.out.printf("%nDe lijst van complexe getallen:%n");

		List<String> alleGetallen = dc.geefAlleComplexeGetallen();
		for (String getal : alleGetallen) {
			System.out.printf("  %s%n", getal);
		}

		System.out.printf("De som van deze getallen is gelijk aan %s%n%n", dc.geefSomVanAlleComplexeGetallen());
	}
}
