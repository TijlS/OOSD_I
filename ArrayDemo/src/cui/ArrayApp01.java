package cui;

public class ArrayApp01 {

	public static void main(String[] args) {
		int[] getallen = { 1, 2, 3, 4, 5 };

		System.out.printf("Array als argument bij methode aanroep:%n");
		System.out.printf("  getallen bevat: %s%n", geefAlsString(getallen));// <.>
	}

	public static String geefAlsString(int[] array) {
		String resultaat = "[";
		for (int i = 0; i < array.length; i++) {
			resultaat += String.format("%d%s", array[i], i == array.length - 1 ? "" : ", ");
		}
		resultaat += "]";
		return resultaat;
	}

}