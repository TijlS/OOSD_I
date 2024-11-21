package cui;

public class ArrayApp02 {
	
	public static void main(String[] args) {
		int[] getallen = { 1, 2, 3, 4, 5 };

		System.out.printf("Voor aanroep, getallen bevat: %s%n", geefAlsString(getallen));
		wijzigReferentieDoorgegevenArray(getallen);
		System.out.printf("Na aanroep, getallen bevat: %s%n", geefAlsString(getallen));
	}

	private static void wijzigReferentieDoorgegevenArray(int[] doorgegevenArray) {
		doorgegevenArray = new int[100];
	}

	public static String geefAlsString(int[] doorgegevenArray) {
		String resultaat = "[";
		for (int i = 0; i < doorgegevenArray.length; i++) {
			resultaat += String.format("%d%s", doorgegevenArray[i], i == doorgegevenArray.length - 1 ? "" : ", ");
		}
		resultaat += "]";
		return resultaat;
	}

}