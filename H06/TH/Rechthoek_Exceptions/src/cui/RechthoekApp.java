package cui;

import java.math.BigDecimal;
import java.time.LocalDate;

import domein.Coordinaat;
import domein.Rechthoek;

public class RechthoekApp {

	public static void main(String[] args) {

		LocalDate vandaag = LocalDate.of(2030, 10, 2);
//		vandaag = vandaag.plusDays(25);

		BigDecimal prijs = BigDecimal.valueOf(20.2);
		prijs = prijs.multiply(BigDecimal.valueOf(1.21));

		System.out.println(prijs);

		Rechthoek rechthoek1 = new Rechthoek(10, 10, new Coordinaat(-100, 0));
		// Rechthoek rechthoek2 = new Rechthoek(300, 300, new Coordinaat(0, 5000));
		// Rechthoek rechthoek3 = new Rechthoek(-10, 1, new Coordinaat(0, 0));
		// Rechthoek rechthoek4 = new Rechthoek(10, 0, new Coordinaat(0, 0));
		// Rechthoek rechthoek5 = new Rechthoek(300, 300, null);

	}
}
