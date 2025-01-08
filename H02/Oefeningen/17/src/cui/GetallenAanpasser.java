package cui;

import java.util.Scanner;

public class GetallenAanpasser {
	public static void main(String[] args) {
		new GetallenAanpasser().start();
	}

	private void start() {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een getal in: ");
		int getal = input.nextInt();

		getal = veranderGetal(getal);

		System.out.printf("Het heeft nu de waarde %d", getal);
	}

	private int veranderGetal(int getal) {
		if (getal > 0) {
			getal -= 10;
			System.out.println("Het gegeven getal was strikt positief en werd verminderd met 10.");
		} else if (getal < 0) {
			getal += 10;
			System.out.println("Het gegeven getal was negatief en werd vermeerderd met 10.");
		} else {
			getal += 1;
			System.out.println("Het gegeven getal was 0 en werd vermeerderd met 1.");
		}

		return getal;
	}
}
