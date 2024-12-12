package cui;

import java.util.Scanner;

import domein.DomeinController;

public class PizzaApp {
	private final DomeinController dc;

	public PizzaApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		Scanner invoer = new Scanner(System.in);
		System.out.print("Hoeveel pizza's wens je te bestellen [1-10]? ");
		int aantalPizzas = invoer.nextInt();
		dc.plaatsBestelling(aantalPizzas);
		System.out.printf("Je plaatste een bestelling voor %d pizza's.%n", dc.geefAantalBesteld());
		System.out.printf("Deze bestelling geeft %srecht op korting.", dc.geeftRechtOpKorting() ? "" : "geen ");
	}

}
