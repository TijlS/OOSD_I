package cui;

import java.util.Scanner;

import domein.Driehoek;

public class DriehoekApp {

	public static void main(String[] args) {
		DriehoekApp da = new DriehoekApp();

		da.speelMetDriehoeken();
	}

	private void speelMetDriehoeken() {
		int a = geefLengte('A');
		int b = geefLengte('B');
		int c = geefLengte('C');
		Driehoek driehoek1 = new Driehoek(a, b, c);

		System.out.printf("Dit is %seen rechthoekige driehoek", driehoek1.isRechthoekig() ? "" : "g");
	}

	private int geefLengte(char zijde) {
		Scanner input = new Scanner(System.in);
		int length;
		boolean inputOk;

		do {
			System.out.printf("Geef de lengte voor zijde %s: ", zijde);
			length = input.nextInt();
			inputOk = length > 0;
			if (!inputOk)
				System.out.println("Lengte > 0");
		} while (!inputOk);

		return length;
	}

}
