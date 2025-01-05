package cui;

import java.util.Scanner;

public class WhileStruct {

	public static void main(String[] args) {
		WhileStruct ws = new WhileStruct();

		ws.getallen();
	}

	private void getallen() {
		Scanner scanner = new Scanner(System.in);

		int somGetallen = 0;
		int aantalGetallen = 0;

		while (aantalGetallen < 10) {
			System.out.printf("Geef een getal op (-1 voor te stoppen): ");
			int getal = scanner.nextInt();

			if (getal == -1)
				break;

			aantalGetallen++;
			somGetallen += getal;
		}

		if (aantalGetallen == 0)
			System.out.println("Er werden geen getallen opgegeven");
		else {
			System.out.println("======");
			System.out.printf("Gemiddelde: %.2f", (double) somGetallen / aantalGetallen);
		}
		scanner.close();
	}

}
