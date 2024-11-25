package cui;

import java.security.SecureRandom;

public class CirkelApp01 {

	public static void main(String[] args) {
			
		new CirkelApp01().werkMetRandom();
	}
		
	private void werkMetRandom(){
			
		final int min = 1;
		final int max = 100;
		final SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			int straal = random.nextInt(min, max+1);
			System.out.printf("Cirkel met straal %d%n", straal);
		}
	}
}
