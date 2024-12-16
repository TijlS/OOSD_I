package cui;

public class World {

	public static void main(String[] args) {
		/*
		 * System.out.printf("%-10S%-10s%n", "Jan", "Jansens");
		 * System.out.printf("%-10S%-10s%n", "Piet", "Pietersen");
		 * System.out.printf("%-10d= %-10s%n", 2 + 3, "2 + 3");
		 * System.out.printf("%10s%-10.2f%%%n", "", 50.3);
		 */

		/*
		 * *string: tekst; *int: geheel getal; *double: meer precies, meer ram,
		 * kommagetal; *float: kommagetal;
		 */

		System.out.printf("%-3s= %-10s%n", 20 + 3, "20 + 3");
		System.out.printf("%-3s= %-10s%n", 20 - 3, "20 - 3");
		System.out.printf("%-3s= %-10s%n", 20 * 3, "20 * 3");
		System.out.printf("%-3s= %-10s%n", 20 / 3, "20 / 3");
		System.out.printf("%-3s= %-10s%n", 20 % 3, "20 % 3");

		System.out.println("\\t = \t;");
		System.out.println("\\n = \n;");
		System.out.println("\\r = \r;");
		System.out.println("\\b = \b;");
		System.out.println("\\f = \f;");

	}

}