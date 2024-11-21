package domein;

public class Coordinaat {
	private static int ondergrens = -10000; // static -> class variable
	private static final int BOVENGRENS = 10000; // final -> only 1 value, not able to edit

	private int x;
	private int y;

	public Coordinaat(int x, int y) {
		// Final values can only be assigned in constructor
		setX(x);
		setY(y);
	}

	public void verplaats(String richting) {
		verplaats(richting, 1);
	}

	public void verplaats(String richting, int verschuiving) {
		switch (richting) {
		case "boven" -> setY(y + verschuiving);
		case "onder" -> setY(y - verschuiving);
		case "links" -> setX(x - verschuiving);
		case "rechts" -> setX(x + verschuiving);
		}
	}

	public static void setOndergrens(int ondergrens) { // Call on class, instead of object
		// So Coorinaat.setOndergrens
		// Coordinaat.ondergrens needs to be static, but not final!
		Coordinaat.ondergrens = ondergrens;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void setX(int x) {
		controleerGrenzen(x);
		this.x = x;
	}

	private void setY(int y) {
		controleerGrenzen(y);
		this.y = y;
	}

	private void controleerGrenzen(int waarde) {
		if (waarde < ondergrens || waarde > BOVENGRENS)
			throw new IllegalArgumentException(
					String.format("x en y moeten in interval [%d, %d] liggen.", ondergrens, BOVENGRENS));
	}

	public void wisselXenY() {
		int temp = x;
		x = y;
		y = temp;
	}

	@Override
	public String toString() {
		return String.format("x = %d, y = %d", x, y);
	}

}
