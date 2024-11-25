package domein;

public class Spel {

	private Dobbelsteen[] dobbelstenen;
	private int score;
	private int eersteWorp;

	public Spel() {
		this.dobbelstenen = new Dobbelsteen[2];
		for (int i = 0; i < dobbelstenen.length; i++) {
			dobbelstenen[i] = new Dobbelsteen();
		}

		this.score = -1;
	}

	public void rolDobbelstenen() {
		for (Dobbelsteen dobbelsteen : dobbelstenen) {
			dobbelsteen.rol();
		}

		if (!isEindeSpel()) {
			int worp = geefAantalOgenWorp();

			if (eersteWorp == 0) {
				setEersteWorp(geefAantalOgenWorp());
				if (worpIs7Of11(eersteWorp))
					score = 2;
			} else {
				if (worp == eersteWorp)
					score = 1;
				if (worpIs7Of11(worp))
					score = 0;
			}
		}
	}

	public int geefAantalOgenWorp() {
		int totaal = 0;
		for (Dobbelsteen dobbelsteen : dobbelstenen) {
			totaal += dobbelsteen.getAantalOgen();
		}

		return totaal;
	}

	/**
	 * 
	 * @param eersteWorp
	 */
	private void setEersteWorp(int eersteWorp) {
		this.eersteWorp = eersteWorp;
	}

	public boolean isEindeSpel() {
		return score != -1;
	}

	private boolean worpIs7Of11(int worp) {
		return worp == 7 || worp == 11;
	}

	public int getScore() {
		return this.score;
	}

}