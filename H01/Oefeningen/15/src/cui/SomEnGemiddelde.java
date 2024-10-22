package cui;

import java.util.Scanner;

public class SomEnGemiddelde {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef eerste getal: ");
		int getal1 = input.nextInt();
		System.out.print("Geef tweede getal: ");
		int getal2 = input.nextInt();
		System.out.print("Geef derde getal: ");
		int getal3 = input.nextInt();

		int som = getal1 + getal2 + getal3;
		int gemiddelde = (getal1 + getal2 + getal3) / 3;

		System.out.printf("Van de ingevoerde getallen %d, %d en %d%n", getal1, getal2, getal3);
		System.out.printf("is de som %d%n", som);
		System.out.printf("het gemiddelde %d%n", gemiddelde);
		System.out.printf("en de rest %d%n", som % gemiddelde);

		input.close();
	}
}
