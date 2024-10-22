package cui;

import java.util.Scanner;

public class Berekening {

	public static void mainDEPC(String[] args) {
		System.out.println("Kies uit de volgende lijst een method:");
		System.out.print("1. mainZonderInvoer \n2. mainMetInvoer \n3. mainSimpeleBewerkingen \nKeuze (1,2,3): ");

		Scanner invoer = new Scanner(System.in);

		int choice = invoer.nextInt();

		invoer.close();

		switch (choice) {
		case 1: {
			mainZonderInvoer(args);
		}
		case 2: {
			mainMetInvoer(args);
		}
		case 3: {
//			mainSimpeleBewerking(args);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}

	public static void main(String[] args) {
		Scanner invoer = new Scanner(System.in);

		System.out.print("1e getal: ");
		double getal1 = invoer.nextDouble();

		System.out.print("2e getal: ");
		double getal2 = invoer.nextDouble();

		double uitkomst = (getal1 + getal2) * 2;

		// %o -> octaal
		// %x/X -> hexadecimaal (X: letter als hfdltr)
		// java.util.Formatter voor volledige lijst
		//
		// 3 + 2
		// ^ ^ ^
		// Operand Operator Operand

		System.out.printf("De uitkomst is %.3f", uitkomst);

		invoer.close();
	}

	public static void mainMetInvoer(String[] args) {
		Scanner invoer = new Scanner(System.in);

		System.out.print("1e getal: ");
		int getal1 = invoer.nextInt();

		System.out.print("2e getal: ");
		int getal2 = invoer.nextInt();

		// a % b --> % = modulo operator, rest van deling
		System.out.printf("%d / %d is %d met rest %d", getal1, getal2, getal1 / getal2, getal1 % getal2);

		invoer.close();
	}

	public static void mainZonderInvoer(String[] args) {
		int getal1 = 10; // Declaratie
		int getal2 = 25;

		System.out.printf("som %d en %d is %d", getal1, getal2, getal1 + getal2);
	}

}
