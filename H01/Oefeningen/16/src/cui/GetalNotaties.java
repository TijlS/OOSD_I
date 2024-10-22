package cui;

import java.util.Scanner;

public class GetalNotaties {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een getal in: ");
		int getal = input.nextInt();

		System.out.printf("Octale notatie = %o%n", getal);
		System.out.printf("Hexadecimale notatie (klein) = %x%n", getal);
		System.out.printf("Hexadecimale notatie (groot) = %X%n", getal);

		input.close();

	}

}
