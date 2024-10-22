package cui;

public class NestedSwitchCase {

	public static void main(String[] args) {
		NestedSwitchCase nsc = new NestedSwitchCase();

		nsc.ex1();
		nsc.ex2();
	}

	private void ex2() {
		int x = 100, y = 0;

		switch (x) {
		case 100:
		case 150:
		case 170:
		case 190: {
			y++;
		}
		default:
		}

		System.out.printf("%ny: %d", y);

	}

	private void ex1() {
		int i = 10, k;

		switch (i) {
		case 1: {
			k = 3;
		}
		case 2: {
			k = 6;
		}
		case 3:
		case 4: {
			k = 10;
		}
		default:
			k = 20;
		}

		System.out.printf("k: %d", k);
	}

}
