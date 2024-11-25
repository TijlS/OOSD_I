package domein;

public class Driehoek {
	private int a;
	private int b;
	private int c;
	private final static int DEFAULT_WAARDE = 1;

	public Driehoek(int a, int b, int c) {
		this.setA(a);
		this.setB(b);
		this.setC(c);
	}

	public Driehoek() {
		this(DEFAULT_WAARDE, DEFAULT_WAARDE, DEFAULT_WAARDE);
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return this.b;
	}

	public int getC() {
		return this.c;
	}

	private void setA(int a) {
		if (a > 0)
			this.a = a;
		else
			this.a = DEFAULT_WAARDE;
	}

	private void setB(int b) {
		if (b > 0)
			this.b = b;
		else
			this.b = DEFAULT_WAARDE;
	}

	private void setC(int c) {
		if (c > 0)
			this.c = c;
		else
			this.c = DEFAULT_WAARDE;
	}

	public boolean isRechthoekig() {
		return Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2) || Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)
				|| Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
	}
}
