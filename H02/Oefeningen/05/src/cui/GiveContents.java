package cui;

public class GiveContents {

	public static void main(String[] args) {
		GiveContents gc = new GiveContents();

		gc.computeIncrementAndDecrement();
	}

	private void computeIncrementAndDecrement() {
		int a = 0, b = 0, c = 0;
		printContents(a, b, c);

		a = ++b + ++c;
		printContents(a, b, c);
		a = b++ + c++;
		printContents(a, b, c);
		a = ++b + c++;
		printContents(a, b, c);
		a = b-- + c--;
		printContents(a, b, c);
	}

	private void printContents(int a, int b, int c) {
		System.out.printf("a: %d, b: %d, c: %d%n", a, b, c);
	}

}
