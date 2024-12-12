package domein;

public class Kluis {
	private final String code;
	private static final int LENGTH_CODE = 4;

	public Kluis(String code) {
		controleerCode(code);
		this.code = code;
	}

	private void controleerCode(String code) {
		// DR: 4 tekens
		if (code == null || code.isEmpty() || code.length() != LENGTH_CODE)
			throw new IllegalArgumentException("Code moet uit 4 tekens bestaan!");

		// DR: cijfers
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) < '0' || code.charAt(i) > '9') {
				throw new IllegalArgumentException("Code mag enkel uit cijfers bestaan!");
			}
		}

		// DR: niet allemaal dezelfde cijfers
		for (int i = 0; i < code.length() - 1; i++) {
			if (code.charAt(i) != code.charAt(i + 1)) {
				return;
			}

			throw new IllegalArgumentException("Code mag niet dezelfde cijfers gebruiker!");
		}
	}

	public boolean valideerCode(String code) {
		if (code == this.code)
			return true;
		return false;
	}

	public String getCode() {
		return code;
	}

}
