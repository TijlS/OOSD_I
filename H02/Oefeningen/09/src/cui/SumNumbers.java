package cui;

import java.util.Scanner;

public class SumNumbers {

	public static void main(String[] args) {
		SumNumbers sn = new SumNumbers();

//		sn.ex1SumWithFor();
		sn.ex2DivisibleBy3();
//		sn.ex3PrintTable();
	}

	private void ex3PrintTable() {
		System.out.printf("%-7s%-7s%-7s%-7s%n", "N", "10*N", "100*N", "1000*N");
		for (int i = 1; i <= 5; i = i + 1) {
			System.out.printf("%-7s%-7s%-7s%-7s%n", i, 10 * i, 100 * i, 1000 * i);
		}
	}

	private void ex2DivisibleBy3() {
		Scanner input = new Scanner(System.in);
		int divibleBy3 = 0, even = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("Number: ");
			int number = input.nextInt();

			if (number % 3 == 0)
				divibleBy3 = divibleBy3 + 1;
			if (number % 2 == 0)
				even = even + 1;
		}

		System.out.printf("%n%d number%s are even and %d number%s are divisible by 3", even, even > 1 ? "s" : "",
				divibleBy3, divibleBy3 > 1 ? "s" : "");

		input.close();
	}

	private void ex1SumWithFor() {
		Scanner input = new Scanner(System.in);
		int total = 0;

		for (int i = 0; i < 5; i = i + 1) {
			System.out.print("Number to add: ");
			int number = input.nextInt();

			total = total + number;
		}

		System.out.printf("%nTotal is: %d", total);

		input.close();
	}

}
