package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InkomstenEnUitgaven {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new InkomstenEnUitgaven().startProgramma();

		input.close();
	}

	private void startProgramma() {
		List<Double> inkomsten = new ArrayList<>();
		List<Double> uitgaven = new ArrayList<>();
		double totaalInkomsten = 0;
		double totaalUitgaven = 0;
		String inkomstenString = "";
		String uitgavenString = "";

		double bedrag = vraagBedrag();

		while (bedrag != 0) {
			if (!(bedrag < 1 && bedrag > -1)) {
				if (bedrag > 0) {
					inkomsten.add(bedrag);
					totaalInkomsten += bedrag;
					inkomstenString += String.format("%.2f  ", bedrag);
				} else {
					uitgaven.add(Math.abs(bedrag));
					totaalUitgaven += bedrag;
					uitgavenString += String.format("%.2f  ", bedrag);
				}
			}

			bedrag = vraagBedrag();
		}

		System.out.printf("%nInkomsten (totaal = %.2f EURO):%n", totaalInkomsten);
		System.out.println(inkomstenString);

		System.out.printf("%nUitgaven (totaal = %.2f EURO):%n", totaalUitgaven);
		System.out.println(uitgavenString);
	}

	private double vraagBedrag() {
		System.out.print("Geef bedrag op (0 => STOP): ");
		return input.nextDouble();
	}

}
