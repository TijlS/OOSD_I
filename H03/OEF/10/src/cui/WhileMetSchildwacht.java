package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhileMetSchildwacht {

	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
//		new WhileMetSchildwacht().oef1();
		new WhileMetSchildwacht().oef2();
	}

	private void oef1() {
		List<Integer> negatieveGetallen = new ArrayList<>();

		int getal = vraagGetal();

		while (getal != 0) {
			if (getal < 0)
				negatieveGetallen.add(getal);

			getal = vraagGetal();
		}

		if (negatieveGetallen.size() == 0)
			System.out.println("Er werden geen negatieve getallen ingevoerd.");
		else {
			double totaal = 0;
			for (Integer nummer : negatieveGetallen) {
				totaal += nummer;
			}

			System.out.printf("Het gemiddelde van de negatieve getallen is %.1f", totaal / negatieveGetallen.size());

		}
	}

	private void oef2() {
		int grootsteGetal = Integer.MIN_VALUE, kleinsteGetal = Integer.MAX_VALUE;

		int getal = vraagGetal();

		while (getal != 0) {
			if (getal > grootsteGetal)
				grootsteGetal = getal;
			if (getal < kleinsteGetal)
				kleinsteGetal = getal;

			getal = vraagGetal();
		}

		if (grootsteGetal == Integer.MIN_VALUE) {
			System.out.println("Er werden geen geldige getallen ingegeven!");
			return;
		}

		System.out.printf("Het grootste van alle ingevoerde getallen is %d.%n", grootsteGetal);
		System.out.printf("Het kleinste %d.", kleinsteGetal);
	}

	private int vraagGetal() {
		System.out.print("Geef een getal (0 voor te stoppen): ");
		return input.nextInt();
	}

}
