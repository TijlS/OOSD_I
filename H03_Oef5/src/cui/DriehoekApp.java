package cui;

import domein.Driehoek;

public class DriehoekApp {

	public static void main(String[] args) {
		DriehoekApp da = new DriehoekApp();

		da.speelMetDriehoeken();
	}

	private void speelMetDriehoeken() {
		Driehoek driehoek1 = new Driehoek(0, 0, 0);

		System.out.println(driehoek1.getA());
	}

}
