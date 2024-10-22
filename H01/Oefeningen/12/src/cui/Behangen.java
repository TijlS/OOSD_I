package cui;

import java.util.Scanner;

public class Behangen {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double rolHoogte = 10, rolBreedte = 0.50;

		System.out.print("Geef de hoogte van de muur in m in: ");
		double hoogte = input.nextDouble();

		System.out.print("Geef de breedte van de muur in m in: ");
		double breedte = input.nextDouble();

		System.out.printf("Het aantal benodigde rollen = %.1f", (hoogte * breedte) / (rolHoogte * rolBreedte));

		input.close();
	}
}
