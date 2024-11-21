package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class RechthoekApp {

	public static void main(String[] args) {
		// instance methods
		Rechthoek rechthoek1 = new Rechthoek(10, 10, new Coordinaat(100, 0));
		Rechthoek rechthoek2 = new Rechthoek(300, 300, new Coordinaat(0, 0));
		System.out.printf("Lengte van rechthoek1 is %.2f%n", rechthoek1.getLengte());
		System.out.printf("Lengte van rechthoek2 is %.2f%n", rechthoek2.getLengte());

		// class variables
		System.out.printf("Coordinaten liggen in het interval [%d, %d]", Coordinaat.ONDERGRENS, Coordinaat.BOVENGRENS);
		Rechthoek mijnRechthoek = new Rechthoek(10, 10, new Coordinaat(Coordinaat.ONDERGRENS, Coordinaat.BOVENGRENS));
		System.out.println(mijnRechthoek);
	}
}
