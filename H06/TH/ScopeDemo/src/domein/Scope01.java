package domein;

public class Scope01 {
	private int x = 10;

	public int speelMetScope(int x) {
		int z = 30;
		this.x = x;
		z = x;
		return x + this.x + z;
	}

}
