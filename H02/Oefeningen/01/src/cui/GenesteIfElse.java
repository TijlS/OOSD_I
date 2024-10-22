package cui;

public class GenesteIfElse {

	public static void main(String[] args) {
		GenesteIfElse gie = new GenesteIfElse();

		gie.temperatuur();
	}

	private void temperatuur() {
		int x = 1013;
		int temperatuur = 15;

		if (x >= 0) {
			System.out.println("positief");
		} else {
			System.out.println("negatief");
		}

		if (temperatuur <= 10) {
			System.out.println("koud");
		} else if (temperatuur < 20) {
			System.out.println("goed");
		} else {
			System.out.println("warm");
		}

		if (x >= 0) {
			if (x % 2 == 0) {
				System.out.println("positief en even");
			} else {
				System.out.println("positief en oneven");
			}
		} else {
			if (x % 2 == 0) {
				System.out.println("negatief en even");
			} else {
				System.out.println("negatief en oneven");
			}
		}

	}

}
