package cui;

public class OutputApplications {

	public static void main(String[] args) {
		OutputApplications oa = new OutputApplications();

		oa.ex1();
	}

	private void ex1() {
		int y, x = 1, total = 0;

		for (; x <= 10; x = x + 1) {
			y = x * x;
			System.out.printf("%d%n", y);
			total = total + y;
		}

		System.out.printf("Total is %d%n", total);

//		GUESS: OK
//		1
//		4
//		9
//		16
//		25
//		36
//		49
//		64
//		81
//		100
//		Total is 385
	}

}
