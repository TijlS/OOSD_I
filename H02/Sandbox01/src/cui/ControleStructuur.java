package cui;

import java.util.Scanner;

public class ControleStructuur {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ControleStructuur cs = new ControleStructuur();

//		cs.demonstrateIf();
//		cs.demonstrateIfElse();
//		cs.demonstrateNestedIfElse();
//		cs.demonstrateMenuWithSwitch();
		cs.demonstrateTernairOperator();

		input.close();
	}

	private void demonstrateTernairOperator() {
		int numberOfStudent = 10;
		System.out.printf("Er zit%s %d student%s in de klas.", numberOfStudent > 1 ? "ten" : "", numberOfStudent,
				numberOfStudent > 1 ? "en" : "");
	}

	private void demonstrateMenuWithSwitch() {
		showMenu();
		int menuChoice = input.nextInt();

		switch (menuChoice) {
		case 1 -> System.out.println("Optelling");
		case 2 -> System.out.println("Aftrekking");
		case 3 -> System.out.println("Vermeningvuldiging");
		case 4 -> System.out.println("Deling");
		case 5 -> System.out.println("Rest na deling");
		default -> System.out.println("Dit is geen geldige keuze...");
		}
	}

	private void showMenu() {
		System.out.println("MENU:");
		System.out.println("=====");
		System.out.println("1) Optellen");
		System.out.println("2) Aftrekken");
		System.out.println("3) Vermenigvuldiging");
		System.out.println("4) Deling");
		System.out.println("5) Rest na deling");

		System.out.print("Maak je keuze: ");
	}

	private void demonstrateNestedIfElse() {
		int number1 = 10, number2 = 12, number3 = 13;

		System.out.printf("1: %d%n2: %d%n3: %d%n", number1, number2, number3);

		if (number1 > number2) {
			if (number1 > number3) {
				System.out.println("Getal 1 is het grootste.");
			} else {
				System.out.println("Getal 3 is het grootste.");
			}
		} else {
			if (number2 > number3) {
				System.out.println("Getal 2 is het grootste.");
			} else {
				System.out.println("Getal 3 is het grootste.");
			}
		}
	}

	private void demonstrateIfElse() {
		System.out.print("Maandsalaris in (in euro): €");
		double monthlySalary = input.nextDouble();

		if (monthlySalary >= 0) {
			double yearSalary = monthlySalary * 12;
			double vacationMoney = yearSalary * 0.08;

			System.out.printf("Jaarsalaris: €%.2f%n", yearSalary);
			System.out.printf("Vakantiegeld: €%.2f", vacationMoney);

		} else {
			System.out.println("Maandsalaris mag niet kleiner of gelijk zijn aan €0.");
		}
	}

	private void demonstrateIf() {
		System.out.print("Maandsalaris in (in euro): €");
		double monthlySalary = input.nextDouble();

		if (monthlySalary >= 0) {
			double yearSalary = monthlySalary * 12;
			double vacationMoney = yearSalary * 0.08;

			System.out.printf("Jaarsalaris: €%.2f%n", yearSalary);
			System.out.printf("Vakantiegeld: €%.2f", vacationMoney);
		}
		System.out.println("Tot de volgende keer!");
	}
}
