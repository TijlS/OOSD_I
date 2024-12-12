package main;

import cui.PizzaApp;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) {
		new PizzaApp(new DomeinController()).start();
	}

}
