package cui;

public class TweedimensionaleArraysVoorbeeld2 {
	public static void main(String args[]) {
		new TweedimensionaleArraysVoorbeeld2().vulTweedimensionaleArrayOp();
	}

	private void vulTweedimensionaleArrayOp() {
		int[][] jagged1 = new int[4][];
		jagged1[0] = new int[5];
		jagged1[1] = new int[5];
		jagged1[2] = new int[7];
		jagged1[3] = new int[2];

		for (int rij = 0; rij < jagged1.length; rij++) // <.>
			for (int kolom = 0; kolom < jagged1[rij].length; kolom++) // <.>
				jagged1[rij][kolom] = rij + kolom;
	}
}