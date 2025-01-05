package cui;

public class GetallenHerschikker {

	private static boolean isHerschikt(int[] getallen) {
		return geefIndexLaatsteNegatiefGetal(getallen) < geefIndexEerstePositiefGetal(getallen);
	}

	public static void herschikMetMutatie(int[] getallen) {
		while (!isHerschikt(getallen)) {
			wissel(getallen, geefIndexLaatsteNegatiefGetal(getallen), geefIndexEerstePositiefGetal(getallen));
		}
	}

	public static int[] herschikZonderMutatie(int[] getallen) {
		int[] herschikt = new int[getallen.length];
		for (int i = 0; i < herschikt.length; i++) {
			herschikt[i] = getallen[i];
		}

		while (!isHerschikt(herschikt)) {
			wissel(herschikt, geefIndexLaatsteNegatiefGetal(herschikt), geefIndexEerstePositiefGetal(herschikt));
		}

		return herschikt;

	}

	// Declareer en implementeer hieronder de private hulpmethodes
	private static int geefIndexLaatsteNegatiefGetal(int[] getallen) {
		int index = -1;

		for (int i = 0; i < getallen.length; i++) {
			if (getallen[i] < 0)
				index = i;
		}

		return index;
	}

	private static int geefIndexEerstePositiefGetal(int[] getallen) {
		for (int i = 0; i < getallen.length; i++) {
			if (getallen[i] > 0)
				return i;
		}

		return getallen.length;
	}

	private static void wissel(int[] getallen, int index1, int index2) {
		int getal1 = getallen[index1];
		int getal2 = getallen[index2];

		getallen[index1] = getal2;
		getallen[index2] = getal1;
	}
}
