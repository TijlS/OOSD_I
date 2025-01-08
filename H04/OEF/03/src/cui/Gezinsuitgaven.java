package cui;

import java.util.Scanner;

public class Gezinsuitgaven {

	public static void main(String args[]) {
		new Gezinsuitgaven().toonMaandenMetUitgavenBovenGemiddelde();
	}

	private void toonMaandenMetUitgavenBovenGemiddelde() {
		String result = "";
		Scanner input = new Scanner(System.in);
		double[] uitgaven = new double[12];
		double gemiddelde = 0;

		for (int i = 0; i < uitgaven.length; i++) {
			System.out.print(String.format("Geef de uitgaven in voor maand %d: ", i + 1));
			uitgaven[i] = input.nextDouble();
			gemiddelde += uitgaven[i];
		}
		gemiddelde = gemiddelde / uitgaven.length;

		for (int i = 0; i < uitgaven.length; i++) {
			if (uitgaven[i] > gemiddelde) {
				result += String.format("%d ", i + 1);
			}
		}

		if (!result.isEmpty())
			System.out.printf("In de volgende maanden werd er meer " + "uitgegeven dan het gemiddelde: %s%n", result);
		else
			System.out.printf("Geen maanden gevonden waarin meer werd uitgegeven" + " dan het gemiddelde!%n");

		input.close();
	}
}
