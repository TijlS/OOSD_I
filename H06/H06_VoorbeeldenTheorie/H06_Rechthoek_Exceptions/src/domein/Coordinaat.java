package domein;

public class Coordinaat {
	private int x;
	private int y;

	public Coordinaat(int x, int y) {
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
		if (waarde < -1000 || waarde > 1000)
			throw new IllegalArgumentException(
					String.format("x en y moeten in interval [%d, %d] liggen.", -1000, 1000));
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
