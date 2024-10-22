package cui;

import java.util.Scanner;

public class Meetkunde {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef de lengte van de rechthoek: ");
		int lengte = input.nextInt();

		System.out.print("Geef de breedte van de rechthoek: ");
		int breedte = input.nextInt();

		System.out.printf("De omtrek = %d%n", lengte * 2 + breedte * 2);
		System.out.printf("De oppervlakte = %d%n", lengte * breedte);

		input.close();
	}

}
