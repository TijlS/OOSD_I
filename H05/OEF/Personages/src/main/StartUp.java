package main;

import cui.PersonagesApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new PersonagesApplicatie(new DomeinController()).start();
	}

}
