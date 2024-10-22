package cui;

import java.util.Scanner;

public class ZipCodes {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ZipCodes zc = new ZipCodes();

		zc.displayZipCode();

		input.close();
	}

	private void displayZipCode() {
		int zipCode;
		boolean zipCodeValid;

		do {
			zipCode = askZipCode();

			zipCodeValid = zipCode < 10000 && zipCode > 999;
			if (!zipCodeValid)
				System.out.println("Postcode voldoet niet aan de voorwaarden.");
		} while (!zipCodeValid);

		String city = getCity(zipCode);

		if (city.isEmpty())
			System.out.printf(
					"Postcode %d bestaat niet of komt overeen met een stad die niet in de tabel is opgenomen.",
					zipCode);
		else
			System.out.printf("%d - %s", zipCode, city);
	}

	private String getCity(int zipCode) {
		String city = switch (zipCode) {
		case 1000 -> "Brussel";
		case 2000 -> "Antwerpen";
		case 2300 -> "Turnhout";
		case 8500 -> "Kortrijk";
		case 9000 -> "Gent";
		case 9200 -> "Dendermonde";
		case 9300 -> "Aalst";
		case 9600 -> "Ronse";
		case 9700 -> "Bah, Oudenaarde";
		default -> "";
		};

		return city;
	}

	private int askZipCode() {
		System.out.print("Geen een postcode (4 cijfers): ");
		int zipCode = input.nextInt();
		return zipCode;
	}

}
