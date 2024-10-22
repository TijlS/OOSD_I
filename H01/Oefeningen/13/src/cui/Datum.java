package cui;

import java.util.Scanner;

public class Datum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een datum in <ddmmjjjj>: ");
		int datum = input.nextInt();

		int dag = (datum / 1000000) % 100;
		int maand = (datum / 10000) % 100;
		int jaar = datum % 10000;

//		System.out.printf("dag: %d%nmaand: %d%njaar: %d%n", dag, maand, jaar);

		int dagenToevoegen = 0;

		while (jaar < jaar + 1) {
			if (maand == 12 && dag == 30)
				break;

			dag++;
			dagenToevoegen++;
			if (dag > 30) {
				maand++;
				dag = 1;

//				System.out.println("========================================");
			}

//			System.out.printf("DAG: %5d | MAAND: %5d | +: %5d%n", dag, maand, dagenToevoegen);
		}

		System.out.printf("Het duurt nog %d dagen voor het terug nieuwjaar is!", dagenToevoegen);

		input.close();
	}
}
