package cui;

public class FibonacciCalculator {
	
	public long fibonacci(int getal) {
		
		if (getal < 0)
			throw new IllegalArgumentException("Geen natuurlijk getal");
		
		if ((getal == 0) || (getal == 1)) 
			return getal; 
		return fibonacci(getal - 1) + fibonacci(getal - 2);
	}

	public void toonReeks(int aantalGetallen) {
		System.out.printf("De eerste %d getallen in de reeks van fibonacci:%n", aantalGetallen);
		for (int i = 0; i < aantalGetallen; i++)
			System.out.printf("%d%s", fibonacci(i), i < aantalGetallen - 1 ? ", " : "");
	}
}
