package cui;

public class FaculteitCalculator {
	public void toonFaculteiten() {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%d! = %d%n", i, faculteitRecursive(i));
		}
	}

	public long faculteit(int getal) {

		if (getal < 0)
			throw new IllegalArgumentException("Geen natuurlijk getal");

		long resultaat = 1;
		for (int i = getal; i >= 1; i--) {
			resultaat *= i;
		}

		return resultaat;
	}

	public long faculteitRecursive(int getal) {
//		if (getal < 0)
//			throw new IllegalArgumentException("Geen natuurlijk getal");
//
//		if (getal == 0)
//			return 1;
//		return getal * faculteitRecursive(getal - 1);

		long resultaat;

		if (getal == 0)
			resultaat = 1;
		else
			resultaat = getal * faculteitRecursive(getal - 1);

		return resultaat;
	}

}
