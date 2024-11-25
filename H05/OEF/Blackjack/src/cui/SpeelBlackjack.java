package cui;

import java.math.BigDecimal;
import java.util.Scanner;

import domein.DomeinController;
import dto.KaartDTO;

public class SpeelBlackjack {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		SpeelBlackjack sb = new SpeelBlackjack();
		DomeinController dc = new DomeinController();

		sb.startNieuwSpel(dc);

//		input.close();
	}

	private void startNieuwSpel(DomeinController dc) {
		BigDecimal inzet = vraagInzet();

		dc.startBlackjack(inzet);
		toonSpeelbord(dc);

		while (vraagOfVerderSpelen(dc)) {
			dc.neemKaart();
			toonSpeelbord(dc);
		}

		if (dc.geefPunten() > 21)
			System.out.println("Verbrand!");

		System.out.println("Het spel is gedaan");
		System.out.printf("Je winst is: €%.2f%n", dc.geefWinst());

	}

	private boolean vraagOfVerderSpelen(DomeinController dc) {
		if (!dc.isPuntenTotaalOnder21())
			return false;

		System.out.print("\nWil je nog een kaart trekken (j/n)? ");
		String answer = input.next();

		return answer.equalsIgnoreCase("ja") || answer.equalsIgnoreCase("j");
	}

	private void toonSpeelbord(DomeinController dc) {
		KaartDTO[] speelbord = dc.geefSpeelbord();

		System.out.println("\nSpeelbord: ");
		for (KaartDTO kaartDTO : speelbord) {
			System.out.printf("- %s %s%n", kaartDTO.kleur(), kaartDTO.waarde());
		}
		System.out.printf("Punten: %d%n", dc.geefPunten());
		System.out.println();
	}

	private BigDecimal vraagInzet() {
		System.out.print("Hoeveel euro wil je inzetten? €");
		BigDecimal inzet = input.nextBigDecimal();

		return inzet;
	}
}
