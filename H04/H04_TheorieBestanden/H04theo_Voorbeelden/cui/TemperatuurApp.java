package cui;

import java.util.Scanner;

import domein.TemperatuurStatistiek;

public class TemperatuurApp {

	private Scanner invoer = new Scanner(System.in);

	// tag::main[]
	public static void main(String[] args) {
		new TemperatuurApp().leesTemperaturenEnToonStatistieken();
	}

	private void leesTemperaturenEnToonStatistieken() {
		TemperatuurStatistiek ts = new TemperatuurStatistiek(); // <.>

		// Inlezen van temperaturen tot sentinel -100
		int dag = 1;
		double temperatuur = geefTemperatuur(dag++);
		while (temperatuur != -100) {
			ts.voegTemperatuurToe(temperatuur); // <.>
			temperatuur = geefTemperatuur(dag++);
		}

		// Bevragen van ts en alle resultaten tonen
		System.out.println(ts.toString());
		System.out.printf("%nEr werden %svriestemperaturen opgemeten.%n", ts.bevatVriestemperaturen() ? "" : "geen ");
		System.out.printf("Dag %d was de warmste dag met %.1f graden.%n", ts.geefWarmsteDag(),
				ts.geefHoogsteTemperatuur());
		double gezochteTemperatuur = 20;
		System.out.printf("Werd er een temperatuur van %.1f graden opgemeten? %s%n", gezochteTemperatuur,
				ts.isGemeten(gezochteTemperatuur) ? "ja" : "nee", gezochteTemperatuur);
	}

	private double geefTemperatuur(int dag) { // <.>
		System.out.printf("Geef temperatuur in voor dag %d > ", dag);
		return invoer.nextDouble();
	}
	// end::main[]

}