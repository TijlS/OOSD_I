package main;

import cui.EnumDemo01;
import cui.EnumDemo02;
import utils.Kleur;

public class Startup {

	public static void main(String[] args) {
		EnumDemo01.toonAlleDagen();
		EnumDemo01.toonLangWeekend();
		EnumDemo01.toonDagMetOrdinaalWaarde(2);

		EnumDemo02.toonAlleKleuren();
		EnumDemo02.toonRgbCode(Kleur.ROOD);
	}

}