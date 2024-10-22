package cui;

public class Kassa {

	public static void main(String[] args) {
		int ontvangenBedrag = 100, teBetalen = 45;

		System.out.printf("Te betalen = %d%n", teBetalen);
		System.out.printf("Ontvangen bedrag = %d%n", ontvangenBedrag);
		System.out.printf("Terug = %d%n", ontvangenBedrag - teBetalen);
	}

}
