package domein;

public class Kip extends Object {

	public Kip() {
		super();
	}

	@Override
	public String toString() {
		return "Ik ben een kippetje, mijn details: " + super.toString();
	}

	public String kakel(int aantalKeer) {
		return "kakel ".repeat(aantalKeer);
	}
}
