package cui;

import java.util.Scanner;

public class TemperatuurStatusApplicatie {
	private static final int SENTINEL = 9999;

	public static void main(String[] args) {
		new TemperatuurStatusApplicatie().bepaalTemperatuurStatus();
	}

	private Scanner invoer = new Scanner(System.in);

	private void bepaalTemperatuurStatus() {
		char schaal = voerSchaalIn();
		int temperatuur = vraagTemperatuur();

		while (temperatuur != SENTINEL) {
			String resultaat = geefTemperatuurStatus(temperatuur, schaal);

			System.out.printf("%d graden %s voelt aan als %s%n", temperatuur, schaal == 'C' ? "Celcius" : "Farenheit",
					resultaat);

			schaal = voerSchaalIn();
			temperatuur = vraagTemperatuur();
		}
	}

	private String geefTemperatuurStatus(int temperatuur) {
		return temperatuur > 20 ? "warm" : temperatuur >= 10 ? "lauw" : "koud";
	}

	private String geefTemperatuurStatus(int temperatuur, char celOfFar) {
		if (celOfFar == 'F')
			temperatuur = (temperatuur - 32) * 5 / 9;

		return geefTemperatuurStatus(temperatuur);
	}

	private int vraagTemperatuur() {
		System.out.printf("Geef de temperatuur (%d om te stoppen): ", SENTINEL);
		return invoer.nextInt();
	}

	private char voerSchaalIn() {
		boolean invoerOk;
		int schaal;

		do {
			System.out.print("Geef de schaal, Celcius of Farenheit (C=1, F=2): ");
			schaal = invoer.nextInt();

			invoerOk = schaal == 1 || schaal == 2;
		} while (!invoerOk);

		return schaal == 1 ? 'C' : 'F';
	}

}