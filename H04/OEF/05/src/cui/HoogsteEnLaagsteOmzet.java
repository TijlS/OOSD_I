package cui;

public class HoogsteEnLaagsteOmzet {
	public static void main(String[] args) {
		new HoogsteEnLaagsteOmzet().bepaalHoogsteEnLaagste();
	}

	private void bepaalHoogsteEnLaagste() {
		int[] omzetLijst = new int[] { 360, 2100, 450, 1450, 650, 780, 1200, 321, 560, 1850, 960, 420 };

		int hoogsteMaand = 0, laagsteMaand = Integer.MAX_VALUE;
		int hoogsteOmzet = 0, laagsteOmzet = Integer.MAX_VALUE;
		for (int i = 0; i < omzetLijst.length; i++) {
			if (omzetLijst[i] > hoogsteOmzet) {
				hoogsteMaand = i + 1;
				hoogsteOmzet = omzetLijst[i];
			}
			if (omzetLijst[i] < laagsteOmzet) {
				laagsteMaand = i + 1;
				laagsteOmzet = omzetLijst[i];
			}
		}

		System.out.printf("Hoogste omzet van %d Euro werd behaald in %d%s maand.%n", hoogsteOmzet, hoogsteMaand,
				bepaalAchtervoegsel(hoogsteMaand));
		System.out.printf("Laagste omzet van %d Euro werd behaald in %d%s maand.%n", laagsteOmzet, laagsteMaand,
				bepaalAchtervoegsel(laagsteMaand));
	}

	private String bepaalAchtervoegsel(int getal) {
		return getal == 1 || getal == 8 ? "ste" : "de";
	}
}
