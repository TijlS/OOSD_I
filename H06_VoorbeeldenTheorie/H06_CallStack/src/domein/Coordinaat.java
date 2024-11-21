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
		case "boven" -> y += verschuiving;
		case "onder" -> y -= verschuiving;
		case "links" -> x -= verschuiving;
		case "rechts" -> x += verschuiving;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void setX(int x) {
		this.x = x;
	}

	private void setY(int y) {
		this.y = y;
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
