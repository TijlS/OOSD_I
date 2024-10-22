package cui;

import java.util.Scanner;

public class Iteration {

	public static void main(String[] args) {
		Iteration it = new Iteration();

//		it.showClassMedian();
		it.showAlphabet();
	}

	private void showAlphabet() {
//		char letter = 'A'; // Only one character allowed
		String text = "LONG TEXT"; // See, " needed instead of '
//		System.out.printf("Letter: %s", letter);

		// Uppercase: 65-90, lowercase: 97-122
		// See UTF-8 table
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			System.out.println(letter);
		}
	}

	private void showClassMedian() {
		Scanner input = new Scanner(System.in);
		int numberOfStudents = 5;
		double total = 0;
		int amountPassed = 0, amountFailed = 0;

		for (int i = 1; i <= numberOfStudents; i++) {
			System.out.printf("Resultaat van student (/20) %d: ", i);
			double result = input.nextDouble();
			total += result;
			if (result >= 10)
				amountPassed++;
		}

		amountFailed = numberOfStudents - amountPassed;

		// Als totaal = int
		// voor komma (double)totaal / numberOfStudents

		System.out.printf("Gemiddelde van %d studenten: %.2f/20%n", numberOfStudents, total / numberOfStudents);
		System.out.printf("Geslaagd: %d, gezakt %d", amountPassed, amountFailed);

		input.close();
	}

}
