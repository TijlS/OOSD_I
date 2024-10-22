package cui;

public class ZooAnimals {

	public static void main(String[] args) {
		ZooAnimals za = new ZooAnimals();

		za.amountOfLions();

	}

	private void amountOfLions() {
		int startAmount = 50;
		int currentAmount = startAmount;
		int endAmount = 1000;
		double annualGrowth = 0.15;
		int years = 0;

		while (currentAmount <= endAmount) {
			currentAmount += currentAmount * annualGrowth;
			years++;
		}

		System.out.printf("Het duurt %d jaar voordat er meer dan %d leeuwen zijn.%n", years, endAmount);
	}

}
