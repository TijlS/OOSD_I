package main;

import cui.HogerLagerApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		HogerLagerApplicatie hla = new HogerLagerApplicatie(dc);

		hla.startHogerLagerSpel();
	}

}
