package domein;

public class RecursieMysterie {

	public static void main(String[] args) {
		RecursieMysterie rm = new RecursieMysterie();

		System.out.println(rm.mysterie(3, -4));
	}

	private int mysterie(int a, int b) {
		if (b == 1)
			return a;
		return a + mysterie(a, b - 1);
	}

	/*
	 * private int mysterie(int a, int b) { if (b == 1) return a; return a +
	 * mysterie(a, b - 1); }
	 */

	/*
	 * Wat is het resultaat van de methode-aanroep mysterie(3, 4)? a = 3, b = 4
	 * return 3 + mysterie(3, 4 - 1) a = 3, b = 3 return 3 + mysterie(3, 3 - 1) a =
	 * 3, b = 2 return 3 + mysterie(3, 2 - 1) a = 3, b = 1 return 3 -> 12
	 * 
	 * 
	 * Kan je een algemene omschrijving geven van wat mysterie als resultaat heeft?
	 * a * b
	 * 
	 * Wat gebeurt er bij de methode aanroep mysterie(3, -4)? blijft oneindig
	 * doorgaan
	 * 
	 */
}
