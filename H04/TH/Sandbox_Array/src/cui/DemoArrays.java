package cui;

import java.util.Scanner;

public class DemoArrays {

	public static void main(String[] args) {
		DemoArrays da = new DemoArrays();

		da.startDemo();
	}

	private void startDemo() {
//						   Lengte array
//								 ▼
		int[] getallen = new int[5];

//		getallen[1] = 250;
//		getallen[3] = getallen[1] * 2;

		toonInhoudArray(getallen);

		wijzigGetallen(getallen);

		toonInhoudArray(getallen);

		System.out.println("===========");
		System.out.printf("De array bevat %d getallen.", getallen.length);
	}

	private void wijzigGetallen(int[] getallenArray) {
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < getallenArray.length; i++) {
			System.out.printf("Geef getal %d op: ", i + 1);
			getallenArray[i] = input.nextInt();
		}

		input.close();
	}

	private void toonInhoudArray(int[] getallen) {
		System.out.println("De array bevat de volgende getallen: ");
		for (int i : getallen) {
			System.out.println(i);
		}
	}

}
