package cui;

import java.util.Scanner;

public class MaandSalaris {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef maandsalaris in euro: €");
		double monthSalary = input.nextDouble();

		double yearSalary = monthSalary * 12;
		double vacationMoney = yearSalary / 100 * 8;

		System.out.printf("Jaarsalaris: €%.2f%nVakantiegeld: €%.2f", yearSalary, vacationMoney);

		input.close();
	}
}
