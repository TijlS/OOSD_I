package cui;

public class ArrayApp03 {
	
	public static void main(String[] args) {
		int[] getallen = { 1, 2, 3, 4, 5 };

		System.out.printf("Voor aanroep, getallen bevat: %s%n", geefAlsString(getallen));
		wijzigInhoudDoorgegevenArray(getallen);
		System.out.printf("Na aanroep, getallen bevat: %s%n", geefAlsString(getallen));
	}

	public static void wijzigInhoudDoorgegevenArray(int[] doorgegevenArray) {
		for (int i = 0; i < doorgegevenArray.length; i++) { // <1>
			doorgegevenArray[i] *= 2;
		}
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
