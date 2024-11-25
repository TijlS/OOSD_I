package cui;

import java.util.Scanner;

import domein.DomeinController;

public class JackpotApp {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		JackpotApp ja = new JackpotApp();
		DomeinController dc = new DomeinController();

		ja.toonJackpotScherm(dc);

		input.close();
	}

	private void toonJackpotScherm(DomeinController dc) {
		System.out.println("DISCLAMER: ");
		System.out.println("GOKKEN ONDER DE 18 JAAR IS VERBODEN");
		System.out.println("GOKKEN KAN VERSLAVEND ZIJN");
		System.out.println();

		dc.startNieuweJackpot();
		toonGetallen(dc);

		while (geefVerderSpelen()) {
			dc.speel();
			toonGetallen(dc);

			System.out.printf("Score: %d%n", dc.geefScore());
		}

		System.out.println("Spelen is gestopt");
	}

	private boolean geefVerderSpelen() {
		System.out.print("\n Wil je nog verder spelen (j/n)? ");
		String answer = input.nextLine();

		return answer.equalsIgnoreCase("ja") || answer.equalsIgnoreCase("j");
	}

	private void toonGetallen(DomeinController dc) {
		int[] getallen = dc.geefGetallen();

		System.out.println("Wielen jackpot: ");
		for (int i : getallen) {
			System.out.printf("%5d", i);
		}
		System.out.println();
	}

}
