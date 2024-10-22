package cui;

import java.util.Scanner;

public class DemoWhile {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		DemoWhile dw = new DemoWhile();

		dw.demonstrateInputWithSentinel();
//		dw.demonstrateValidatedInput();

		input.close();
	}

	private void demonstrateValidatedInput() {
		int number;

		// Eerst runnen en dan testen
		do {
			System.out.print("Geef een positief geheel getal in: ");
			number = input.nextInt();
		} while (!(number > 0));

		System.out.printf("Het POSITIEVE getal is %d", number);
	}

	private void demonstrateInputWithSentinel() {
		int som = 0;
		int aantalStudenten = 0;

		int resultaat = getResult(aantalStudenten + 1);

		// Eerst testen en dan runnen
		while (resultaat != -1) {
			som += resultaat;
			aantalStudenten++;

			resultaat = getResult(aantalStudenten + 1);
		}

		if (aantalStudenten == 0) {
			System.out.println("Er werden geen resultaten ingevoerd");
		} else {
			System.out.printf("Het klasgemiddelde is %.1f", (double) som / aantalStudenten);

		}

		input.close();

	}

	private int getResult(int student) {
		int result;
		boolean resultOk;

		do {
			System.out.printf("Geef resultaat in [0, 20] voor student %d (-1 om te stoppen): ", student);
			result = input.nextInt();

			resultOk = result >= 0 && result <= 20 || result == -1;
		} while (!resultOk);

		return result;
	}

}
