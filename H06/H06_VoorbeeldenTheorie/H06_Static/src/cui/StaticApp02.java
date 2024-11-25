package cui;

import domein.Coordinaat;
import domein.Rechthoek;

public class StaticApp02 {

	private Rechthoek rechthoek;

	public static void main(String[] args) { 
		StaticApp02 myApp = new StaticApp02(); 
		myApp.maakEnToonRechthoek(); 
	}

	private void maakEnToonRechthoek() { 
		this.rechthoek = new Rechthoek(10, 10, new Coordinaat(5, 5));
		System.out.printf("Deze instantie van rechthoek heeft een omtrek van %.2f", rechthoek.geefOmtrek());
	}
}
