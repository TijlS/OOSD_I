package domein;

public class Kluis {
	private final String code;

	public Kluis(String code) {
		controleerCode(code);
		this.code = code;
	}

	private void controleerCode(String code) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public boolean valideerCode(String code) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public String getCode() {
		return code;
	}

}
