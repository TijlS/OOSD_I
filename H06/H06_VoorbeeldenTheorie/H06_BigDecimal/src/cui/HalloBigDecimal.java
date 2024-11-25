package cui;

import java.math.BigDecimal;

public class HalloBigDecimal {

	public static void main(String[] args) {

		new HalloBigDecimal().werkMetBigDecimal();
	}

	private void werkMetBigDecimal(){

		BigDecimal bd1 = new BigDecimal("0.123"); // argument is String
		BigDecimal bd2 = new BigDecimal(0.0587); // argument is double
		BigDecimal bd3 = new BigDecimal(2500); // argument is int
		System.out.printf("bd1 = %f%nbd2 = %f%nbd3 = %f%n", bd1, bd2, bd3);
		
		BigDecimal bd4 = new BigDecimal(0.1);
		BigDecimal bd5 = BigDecimal.valueOf(0.1); // <1>
		System.out.printf("bd4 = %.30f%nbd5 = %.30f%n", bd4, bd5);
	}

}