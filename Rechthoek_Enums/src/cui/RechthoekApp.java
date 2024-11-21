package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class RechthoekApp {

	public static void main(String[] args) {
		Rechthoek mijnRechthoek = new Rechthoek(10, 10, new Coordinaat(100, 0));
		mijnRechthoek.verschuif("boven", 200);
		System.out.println(mijnRechthoek);
	}
}
