package cui;

public class TweedimensionaleArraysVoorbeeld1 {
	public static void main(String args[]) {
		new TweedimensionaleArraysVoorbeeld1().maakEnToonEenTweedimensionaleArray();
	}

	private void maakEnToonEenTweedimensionaleArray() {

		int[][] jagged2 = { { 11, 22, 33 }, { -2, -5 }, { 4, 4, 4, 4 } };

		System.out.println("De waarden in de array rij per rij:\n");
		String uitvoer = "";
		for (int[] rij : jagged2) { // <.>
			for (int element : rij) // <.>
				uitvoer += String.format("%8d", element);
			uitvoer += "%n";
		}
		System.out.printf(uitvoer);
	}
}
