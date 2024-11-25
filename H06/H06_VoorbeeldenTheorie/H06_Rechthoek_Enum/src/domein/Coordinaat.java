package domein;

import utils.Richting;

public class Coordinaat {
	public static final int ONDERGRENS = -1000;
	public static final int BOVENGRENS = 1000;

	private int x;
	private int y;

	public Coordinaat(int x, int y) {
		setX(x);
		setY(y);
	}

	public void verplaats(Richting richting) {
		verplaats(richting, 1);
	}

	public void verplaats(Richting richting, int verschuiving) {
		switch (richting) {
		case BOVEN -> setY(y + verschuiving);
		case ONDER -> setY(y - verschuiving);
		case LINKS -> setX(x - verschuiving);
		case RECHTS -> setX(x + verschuiving);
		}
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
		if (waarde < ONDERGRENS || BOVENGRENS > 1000)
			throw new IllegalArgumentException(
					String.format("x en y moeten in interval [%d, %d] liggen.", ONDERGRENS, BOVENGRENS));
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