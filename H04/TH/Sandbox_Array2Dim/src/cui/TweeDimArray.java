package cui;

import java.security.SecureRandom;

public class TweeDimArray {

	public static void main(String[] args) {
		new TweeDimArray().maakTweeDimensionaleArray();
	}

	private void maakTweeDimensionaleArray() {
		int[][] matrix = new int[3][2]; // 3 rijen, 2 kolommen

		matrix[2][0] = 600;

		vulMatrix(matrix);

		toonMatrix(matrix);

		System.out.println("==========");

		int[][] getransponeerd = transponeer(matrix);
		toonMatrix(getransponeerd);
	}

	private void toonMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int col : row) {
				System.out.printf("%3d", col);
			}
			System.out.printf("%n");
		}
	}

	private void vulMatrix(int[][] matrix) {
		SecureRandom sr = new SecureRandom();

		for (int rijIndex = 0; rijIndex < matrix.length; rijIndex++) {
			int[] rij = matrix[rijIndex];

			for (int kolomIndex = 0; kolomIndex < rij.length; kolomIndex++) {
				rij[kolomIndex] = sr.nextInt(1, 11);
			}
		}
	}

	private int[][] transponeer(int[][] matrix) {
		int[][] getransponeerdeMatrix = new int[matrix[0].length][matrix.length];

		for (int rijIndex = 0; rijIndex < matrix.length; rijIndex++) {
			int[] rij = matrix[rijIndex];

			for (int kolomIndex = 0; kolomIndex < rij.length; kolomIndex++) {
				getransponeerdeMatrix[kolomIndex][rijIndex] = matrix[rijIndex][kolomIndex];
			}
		}

		return getransponeerdeMatrix;
	}

}
