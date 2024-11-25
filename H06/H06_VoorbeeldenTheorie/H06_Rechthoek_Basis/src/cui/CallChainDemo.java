package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class CallChainDemo {

	public static void main(String[] args) {
		Rechthoek mijnRechthoek = new Rechthoek(1, 1, new Coordinaat(10, 10));
		mijnRechthoek.verschuif("links");
	}

}