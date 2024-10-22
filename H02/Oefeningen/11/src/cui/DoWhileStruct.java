package cui;

import java.util.Scanner;

public class DoWhileStruct {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		DoWhileStruct dws = new DoWhileStruct();

//		dws.oef1();
		dws.oef2();

		input.close();
	}

	private int askNumber(String extra) {
		System.out.printf("Geen een getal in %s: ", extra != null ? "(" + extra + ")" : "");
		int number = input.nextInt();

		return number;
	}

	private void oef2() {
		int firstNumber, secondNumber;
		boolean validInput;
		do {
			firstNumber = askNumber("!= 1000 en != /12");
			validInput = firstNumber != 1000 || firstNumber % 12 != 0;

			if (!validInput)
				System.out.println("Ingevoerde waarde was niet geldig. Probeer opnieuw.");

		} while (!validInput);

		do {
			secondNumber = askNumber("> " + firstNumber);
			validInput = secondNumber > firstNumber;

			if (!validInput)
				System.out.println("Ingevoerde waarde was niet geldig. Probeer opnieuw.");
		} while (!validInput);

		System.out.printf("1e getal: %d%n2e getal: %d", firstNumber, secondNumber);
	}

	private void oef1() {
		int number = 0;

		System.out.print("Geef een strikt negatief getal: ");
		number = input.nextInt();

		while (number >= 0) {
			System.out.println("Getal was niet strikt negatief.");
			System.out.print("Geef een strikt negatief getal: ");
			number = input.nextInt();
		}

		System.out.printf("Getal was %d.", number);
	}

}
