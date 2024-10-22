package cui;

import java.util.Scanner;

public class WhileWithGuard {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		WhileWithGuard wwg = new WhileWithGuard();

//		wwg.oef1();
		wwg.oef2();

		input.close();
	}

	private long giveCompleteNumber() {
		try {
			System.out.print("Geef een getal (0 voor te stoppen): ");
			long number = input.nextLong();
			return number;

		} catch (Exception e) {
			System.out.println("Dommerik, een nummer!");
			return 0;
		}
	}

	private void oef2() {
		long biggest = 0, smallest = 0, runs = 0;

		long number = giveCompleteNumber();
		biggest = smallest = number;

		while (number != 0) {
			if (number > biggest) {
				biggest = number;
			}
			if (number < smallest) {
				smallest = number;
			}

			runs++;
			number = giveCompleteNumber();
		}

		if (runs == 0)
			System.out.println("Geen getallen ingegeven.");

		if (runs > 0) {
			System.out.printf("Het grootste ingevoerde getal was %d.%n", biggest);
			System.out.printf("Het kleinste was %d.", smallest);
		}
	}

	private void oef1() {
		int total = 0;
		int numbers = 0;

		while (true) {
			System.out.print("Geef een getal (0 voor te stoppen): ");
			int number = input.nextInt();

			if (number == 0) {
				break;
			}
			if (number < 0) {
				numbers++;
				total += number;
			}
		}

		if (numbers == 0) {
			System.out.println("Er werden geen negatieve getallen gevonden!");
		} else {
			System.out.printf("Het gemiddelde van alle negatieve getallen is %.2f", (double) total / numbers);
		}
	}

}
