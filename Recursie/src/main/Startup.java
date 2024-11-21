package main;

import cui.FaculteitCalculator;
import cui.FibonacciCalculator;

public class Startup {

	public static void main(String[] args) {
		int getal = 5;
		FaculteitCalculator faculteitCalculator = new FaculteitCalculator();
		System.out.printf("Faculteit van %d is %d%n", getal, faculteitCalculator.faculteit(getal));
		faculteitCalculator.toonFaculteiten();

		getal = 6;
		FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
		System.out.printf("%nHet %dde getal in de reeks van fibonacci is %d%n", getal,
				fibonacciCalculator.fibonacci(getal));
		fibonacciCalculator.toonReeks(20);

		double doubleValue = 5.75;
		System.out.println(faculteitCalculator.faculteit((int) doubleValue));
	}
}
