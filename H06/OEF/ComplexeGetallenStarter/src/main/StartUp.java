package main;

import cui.ComplexApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		DomeinController dc = new DomeinController();
		ComplexApplicatie ca = new ComplexApplicatie(dc);

		ca.start();
	}

}