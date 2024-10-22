package cui;

import java.util.Scanner;

public class TabelVermenigvuldiging {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een positief getal in: ");
		int getal = input.nextInt();

		System.out.printf("%15d%15d%15d%15d%15d%n", 1, 10, 100, 1000, 10000);
		System.out.printf("%15d%15d%15d%15d%15d%n", 1 * getal, 10 * getal, 100 * getal, 1000 * getal, 10000 * getal);

		input.close();
	}

}
