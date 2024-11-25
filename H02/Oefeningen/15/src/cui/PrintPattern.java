package cui;

public class PrintPattern {

	public static void main(String[] args) {
		PrintPattern pp = new PrintPattern();

		pp.trianglesA();
		pp.trianglesB();
		pp.trianglesC();
		pp.trianglesD();
	}

	private void trianglesA() {
		for (int amountOfStars = 1; amountOfStars <= 10; amountOfStars++) {
			draw(amountOfStars, '*');
			System.out.println();
		}
	}

	private void trianglesB() {
		for (int amountOfStars = 0; amountOfStars < 10; amountOfStars++) {
			draw(amountOfStars, ' ');
			draw(10 - amountOfStars, '*');
			System.out.println();
		}
	}

	private void trianglesC() {
		for (int amountOfStars = 10; amountOfStars >= 1; amountOfStars--) {
			draw(amountOfStars, '*');
			System.out.println();
		}
	}

	private void trianglesD() {
		for (int amountOfStars = 1; amountOfStars <= 10; amountOfStars++) {
			draw(10 - amountOfStars, ' ');
			draw(amountOfStars, '*');
			System.out.println();
		}
	}

	private void draw(int amount, char character) {
		for (int i = 1; i <= amount; i++) {
			System.out.print(character);
		}
	}

}
