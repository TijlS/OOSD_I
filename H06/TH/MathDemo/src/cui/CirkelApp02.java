package cui;

import java.security.SecureRandom;

public class CirkelApp02 {

	public static void main(String[] args) {
		
		new CirkelApp02().werkMetMath();
	}
	
	private void werkMetMath(){
		
		SecureRandom random = new SecureRandom();
		final int min = 1;
		final int max = 100; 
		
		for (int i = 0; i < 10; i++) {
			double straal = random.nextDouble(min, max);
			System.out.printf("Een cirkel met straal %.2f heeft een oppervlakte van %.2f.%n", straal,
					Math.PI * Math.pow(straal, 2));
		
		}
	}
}
