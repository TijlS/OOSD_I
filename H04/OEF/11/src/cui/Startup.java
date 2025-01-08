package cui;

import java.util.Scanner;

public class Startup {
	public static void main(String[] args) {
		new Startup().berekenGemiddeldeVanGetallenInTweedimensionaleArray();
	}

	private void berekenGemiddeldeVanGetallenInTweedimensionaleArray() {
		double getallenMatrix[][] = new double[3][2]; // 3 rijen, 2 kolommen

		for (int i = 0; i < getallenMatrix.length; i++) {
			for (int j = 0; j < getallenMatrix[i].length; j++) {
				getallenMatrix[i][j] = geefElement(i + 1, j + 1);
			}
		}

		double totaal = 0;
		for (int i = 0; i < getallenMatrix.length; i++) {
			for (int j = 0; j < getallenMatrix[i].length; j++) {
				totaal += getallenMatrix[i][j];
			}
		}

		System.out.printf("Het gemiddelde van alle getallen in de matrix is %.1f.", totaal / 6);
	}

	private double geefElement(int rij, int kolom) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Geef getal op rij %d en kolom %d: ", rij, kolom);
		return input.nextDouble();
	}

}
