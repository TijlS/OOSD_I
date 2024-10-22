package cui;

public class OutputStatements {

	public static void main(String[] args) {
		OutputStatements os = new OutputStatements();

		os.compute();
	}

	private void compute() {
		int i = 1, j = 2, k = 3, m = 2;

		System.out.println(i == 1); // GUESS: true OK
		System.out.println(j == 3); // GUESS: false OK
		System.out.println(i >= 1 && j < 4); // GUESS: true OK
		System.out.println(m <= 99 && k < m); // GUESS: false OK
		System.out.println(j >= i || k == m); // GUESS: true OK
		System.out.println(k + m < j || 3 - j >= k); // GUESS: false OK
		System.out.println(!(k > m)); // GUESS: false OK
	}

}
