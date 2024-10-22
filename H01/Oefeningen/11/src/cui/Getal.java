package cui;

import java.util.Scanner;

public class Getal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Geef een getal (> 999 en <= 9999) in: ");
		int getal = input.nextInt();
		while (getal <= 999 || getal > 9999) {
			System.out.print("Getal voldoet niet aan de voorwaarden. (> 999 en <= 9999) in: ");
			getal = input.nextInt();
		}

		int duizendTallen = (getal / 1000) % 10;
		int honderdTallen = (getal / 100) % 10;
		int tientTallen = (getal / 10) % 10;
		int eenheden = (getal / 1) % 10;

//		int duizendTallen = getal / 1000;
//		int rest = getal % 1000;
//		int honderdTallen = rest / 100;
//		rest = rest % 100;
//		int tientTallen = rest / 10;
//		rest = rest % 10;
//		int eenheden = rest / 1;

		System.out.println("Het getal bestaat uit:");
		System.out.printf("%d duizendtallen %n", duizendTallen);
		System.out.printf("%d honderdtallen %n", honderdTallen);
		System.out.printf("%d tientallen %n", tientTallen);
		System.out.printf("%d eenheden %n", eenheden);

		input.close();
	}
}
