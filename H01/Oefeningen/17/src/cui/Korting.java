package cui;

import java.util.Scanner;

public class Korting {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een prijs in (kommagetal): ");
		double prijs = input.nextDouble();

		System.out.print("Geef een kortingspercentage in (geheel getal): ");
		int korting = input.nextInt();

		System.out.printf("€%f met %d%% korting is: €%f%n", prijs, korting, (prijs / 100) * (100 - korting));
		System.out.printf("€%.2f met %d%% korting is: €%.2f", prijs, korting, (prijs / 100) * (100 - korting));

		input.close();
	}

}
