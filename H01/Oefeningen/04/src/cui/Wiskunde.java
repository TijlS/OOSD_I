package cui;

public class Wiskunde {
	public static void main(String[] args) {
		System.out.printf("1. %d%n", 2 + 3 * 4);
		System.out.printf("2. %d%n", (2 + 3) * 4);
		System.out.printf("3. %d%n", 6 * 3 / 2 * 4);
		System.out.printf("4. %d%n", 6 * 3 / (2 * 4));
		System.out.printf("5. %d%n", 6 * (8 % (2 * 3)));
		System.out.printf("6. %d%n", 17 / 8 + 9 % 5 - 3 * 2);
		System.out.printf("7. %d%n", 17 / (8 + 9) % (5 - 3) * 2);
		// System.out.printf("8. %d%n", 12 / (2 * 8 % 4));
		System.out.printf("8. DELEN DOOR NUL%n");
		System.out.printf("9. %f%n", 12.4 / (15 % 4));
		System.out.printf("10. %d%n", 20 * 17 / 8 % 4);
	}
}
