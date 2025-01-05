package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {
	private List<Complex> complexeGetallen;

	public DomeinController() {
		complexeGetallen = new ArrayList<>();
	}

	public void voegComplexGetalToe(double reeel, double imaginair) {
		complexeGetallen.add(new Complex(reeel, imaginair));
	}

	public List<String> geefAlleComplexeGetallen() {
		List<String> result = new ArrayList<>();

		for (Complex complex : complexeGetallen) {
			result.add(complex.toString());
		}

		return result;
	}

	public String geefSomVanAlleComplexeGetallen() {
		return Complex.sommeer(complexeGetallen).toString();
	}
}
