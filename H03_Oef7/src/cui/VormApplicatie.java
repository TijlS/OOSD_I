package cui;

import java.util.Scanner;

import domein.Driehoek;
import domein.Rechthoek;

public class VormApplicatie {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		VormApplicatie va = new VormApplicatie();

		va.vormen();

		input.close();
	}

	private void vormen() {
		int keuze = keuzeMenu();

		int amntFigures = 0, amntRectanglesWithSurfaceBiggerThan50 = 0, amntRightAngledTriangles = 0;

		while (keuze != 0) {
			switch (keuze) {
			case 1:
				Rechthoek rectangle = createRectangle();

				if (rectangle.berekenOppervlakte() > 50) {
					amntRectanglesWithSurfaceBiggerThan50++;
				}

				amntFigures++;
				break;

			case 2:
				Driehoek triangle = createTriangle();

				if (triangle.isRechthoekig()) {
					amntRightAngledTriangles++;
				}

				amntFigures++;
				break;
			}

			keuze = keuzeMenu();
		}
		System.out.println("Overzicht vormen:");
		System.out.printf("Totaal aantal vormen: %d%n", amntFigures);
		System.out.printf("Aantal rechthoeken met opp > 50: %d%n", amntRectanglesWithSurfaceBiggerThan50);
		System.out.printf("Totaal rechthoekige driehoeken: %d", amntRightAngledTriangles);
	}

	private int geefLengteDriehoek(char zijde) {
		int length;
		boolean inputOk;

		do {
			System.out.printf("Geef de lengte voor zijde %s: ", zijde);
			length = input.nextInt();
			inputOk = length > 0;
			if (!inputOk)
				System.out.println("Lengte > 0");
		} while (!inputOk);

		return length;
	}

	private Driehoek createTriangle() {
		int a = geefLengteDriehoek('A');
		int b = geefLengteDriehoek('B');
		int c = geefLengteDriehoek('C');
		Driehoek triangle = new Driehoek(a, b, c);

		return triangle;
	}

	private double geefLengteRechthoek(String kant) {
		double length;
		boolean inputOk;

		do {
			System.out.printf("Geef de %s van de rechthoek: ", kant);
			length = input.nextDouble();
			inputOk = length > 0;
			if (!inputOk)
				System.out.println("Lengte > 0");
		} while (!inputOk);

		return length;
	}

	private Rechthoek createRectangle() {
		double lengte = geefLengteRechthoek("lengte");
		double breedte = geefLengteRechthoek("breedte");
		Rechthoek rectangle = new Rechthoek(lengte, breedte);

		return rectangle;
	}

	private int keuzeMenu() {
		int keuze;
		boolean inputOk;

		do {
			System.out.print("Wil je graag een vorm ingeven (1 -> rechthoek, 2 -> driehoek, 0 -> nee)? ");
			keuze = input.nextInt();

			inputOk = keuze >= 0 && keuze <= 2;

		} while (!inputOk);
		return keuze;
	}

}
