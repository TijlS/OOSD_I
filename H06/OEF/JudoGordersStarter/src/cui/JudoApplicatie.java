package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.Gordel;

public class JudoApplicatie {
	private Scanner invoer = new Scanner(System.in);

	public void start() {
		String kleur = voerKleurIn(geefGeldigeKleuren());

		Gordel gordel = Gordel.valueOf(kleur);

		System.out.printf("Proficiat, je graad is %s, dat is %s.%n", gordel.getGraad(), gordel.getJapanseNaam());

		if (gordel != Gordel.ZWART)
			System.out.printf("Focus en train met veel discipline en inzet, je volgende gordel is %s!",
					gordel.geefVolgende());
		else
			System.out.println("Je bent een meester!");
	}

	private String voerKleurIn(List<String> geldigeKleuren) {
		String kleur;
		boolean invoerOk;
		do {
			System.out.printf("Welke kleur heeft je gordel %s? ", geefKleurenAlsTekstInLijst(geldigeKleuren));
			kleur = invoer.nextLine();

			invoerOk = geldigeKleuren.contains(kleur.toLowerCase());

			if (!invoerOk) {
				System.out.println("Je gaf geen geldige kleur in... Probeer opnieuw!");
			}
		} while (!invoerOk);
		return kleur.toUpperCase();
	}

	private String geefKleurenAlsTekstInLijst(List<String> geldigeKleuren) {
		String lijst = "(";
		for (String kleur : geldigeKleuren) {
			lijst += String.format("%s ", kleur);
		}
		lijst += ")";
		return lijst;
	}

	private List<String> geefGeldigeKleuren() {
		List<String> kleuren = new ArrayList<>();

		for (Gordel gordel : Gordel.values())
			kleuren.add(gordel.name().toLowerCase());
		return kleuren;
	}

}
