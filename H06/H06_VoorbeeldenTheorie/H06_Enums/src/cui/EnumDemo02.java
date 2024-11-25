package cui;

import utils.Kleur;

public class EnumDemo02 {
	public static void toonAlleKleuren() {
		System.out.printf("%n%nAlle kleuren:%n");
		for (Kleur k : Kleur.values()) {
			System.out.printf("%s%n", k); // <1>
		}
	}

	public static void toonRgbCode(Kleur kleur) {
		System.out.printf("%n%s - %s ", kleur.name(), kleur.getRgbCode());
	}
}
