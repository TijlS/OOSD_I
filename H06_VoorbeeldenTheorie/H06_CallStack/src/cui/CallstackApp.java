package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class CallstackApp {

	public static void main(String[] args) {
		Rechthoek mijnRechthoek = new Rechthoek(5, 5, new Coordinaat(0, 0));
		mijnRechthoek.verschuif("links");
	}

}