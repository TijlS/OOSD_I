package cui;

import java.security.SecureRandom;

public class SecureRandomDemo {

	public static void main(String[] args) {
		
		new SecureRandomDemo().werkMetSecureRandom();
	}
	
	private void werkMetSecureRandom()	{
		
		SecureRandom randomNumbers = new SecureRandom();
		int frequentie[] = new int[6];

		for (int i = 1; i <= 6000000; i++)
			++frequentie[randomNumbers.nextInt(6)];

		System.out.printf("%s%25s%n", "Worp", "Aantal keer geworpen");
		for (int i = 0; i < frequentie.length; i++) {
			System.out.printf("%3d%15d%n", i + 1, frequentie[i]);
		}
	}	
}
