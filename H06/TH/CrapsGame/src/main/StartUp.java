package main;

import cui.CrapsApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new CrapsApplicatie(new DomeinController()).startSpel();
	}

}