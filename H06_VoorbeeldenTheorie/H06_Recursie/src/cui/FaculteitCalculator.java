package cui;

public class FaculteitCalculator {
	public void toonFaculteiten() {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%d! = %d%n", i, faculteit(i));
		}
	}

	public long faculteit(int getal) { 
		
		if (getal < 0) 
			throw new IllegalArgumentException("Geen natuurlijk getal");
		
		if (getal == 0) 
			return 1; 
		return getal * faculteit(getal - 1); 
	}

}
