package cui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayListDemo ald = new ArrayListDemo();

//		ald.demoArrayList();
		ald.werkMetListBanGetallen();
	}

	private void werkMetListBanGetallen() {
//		 int, double, float, enz. werken niet 	--> Number (Integer, Double, Float, ...)
//		 boolean 								--> Boolean
//		 char 									--> Character
		List<Integer> getallen = new LinkedList<>();

		getallen.add(5);
		getallen.add(15);
		getallen.add(-22);

		for (int getal : getallen) {
			System.out.println(getal);
		}
	}

	private void demoArrayList() {
		List<String> benodigdheden;

		benodigdheden = new ArrayList<>();

		System.out.printf("De verameling bevat %d elementen. %n", benodigdheden.size());

		benodigdheden.add("Tang");
		benodigdheden.add("Hamer");
		benodigdheden.add("Zaag");
		benodigdheden.add("Schroevendraaier");

		benodigdheden.add(1, "Vijs");

		System.out.printf("En nu bevat de verameling %d elementen. %n", benodigdheden.size());
		System.out.printf("De verzameling bevat %S%n", benodigdheden.get(2));
		System.out.printf("Het laatste is %S%n", benodigdheden.getLast());

		benodigdheden.remove("Slijpschijf");

		Scanner input = new Scanner(System.in);
		System.out.print("Welke tool wil je toevoegen? ");
		String zoekterm = input.next();

		if (!benodigdheden.contains(zoekterm)) {
			benodigdheden.add(zoekterm);
			System.out.printf("%s werd toegevoegd!%n", zoekterm);
		} else
			System.out.printf("%s zat al in de lijst%n", zoekterm);

		System.out.println("\nDe volledige verzameling: ");
		for (String string : benodigdheden) { // Enhanced for
			System.out.printf("- %S%n", string);
		}
	}

}
