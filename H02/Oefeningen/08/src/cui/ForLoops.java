package cui;

public class ForLoops {

	public static void main(String[] args) {
		ForLoops fl = new ForLoops();

		fl.positiveAddition();
		System.out.println("==========");
		fl.uneven();
		System.out.println("==========");
		fl.alphabet();

	}

	private void alphabet() {
		for (char letter = 'a'; letter <= 'z'; letter++) {
			System.out.printf("%s%n", letter);
		}

	}

	private void uneven() {
		for (int i = 51; i >= 0; i -= 2) {
			System.out.printf("%d%n", i);
		}

	}

	private void positiveAddition() {
		int total = 0;

		for (int i = 0; i <= 500; i += 12) {
			total += i;
		}

		System.out.printf("Total: %d%n", total);

	}

}
