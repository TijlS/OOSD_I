package cui;

import java.util.Scanner;

public class Vermenigvuldiger {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef eerste getal: ");
		int getal1 = input.nextInt();
		System.out.print("Geef tweede getal: ");
		int getal2 = input.nextInt();
		System.out.print("Geef derde getal: ");
		int getal3 = input.nextInt();

		System.out.printf("De vermenigvuldiging van %d, %d en %d is %d", getal1, getal2, getal3,
				getal1 * getal2 * getal3);

		input.close();
	}

}
