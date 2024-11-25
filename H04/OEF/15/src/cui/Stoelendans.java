package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stoelendans {
	private static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {
		new Stoelendans().startStoelendans();

		input.close();
	}

	private void startStoelendans() {
		String[] namen = { "Mo", "To", "Bo", "Jo", "Co" }; // new String[] niet nodig
		List<String> spelers = new ArrayList<>(List.of(namen));

		System.out.printf("We starten de stoelendans met %s%n", spelers);

		int ronde = 1;
		do {
			speelRonde(ronde, spelers);

			ronde++;
		} while (spelers.size() != 1);

		System.out.printf("%nProficiat %s! Je hebt de stoelendans gewonnen!", spelers.getFirst());

	}

	private void speelRonde(int ronde, List<String> spelers) {
		String afvaller = vraagAfvaller(ronde, spelers);
		spelers.remove(afvaller);
	}

	private String vraagAfvaller(int ronde, List<String> spelers) {
		System.out.printf("%nRonde %d met spelers %s%n", ronde, spelers);
		System.out.print("Geef de naam van de afvaller: ");
		String speler = input.nextLine();

		while (!spelers.contains(speler)) {
			System.out.printf("Let op! %s neemt niet deel aan de stoelendans!%n", speler);
			speler = vraagAfvaller(ronde, spelers);
		}

		return speler;
	}
}
