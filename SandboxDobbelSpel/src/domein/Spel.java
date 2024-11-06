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

		setScore(-1);
	}

	public void rolDobbelstenen() {
		for (Dobbelsteen dobbelsteen : dobbelstenen) {
			dobbelsteen.rol();
		}

		if (eersteWorp == 0)
			setEersteWorp(geefAantalOgenWorp());

		boolean negatieveScore = score == -1;
		int worp = geefAantalOgenWorp();

		if (negatieveScore && worpIs7Of11(eersteWorp))
			setScore(2);
		if (negatieveScore && eersteWorp != 0 && worp == eersteWorp) {
			if (worp == eersteWorp)
				setScore(1);
			if (worpIs7Of11(worp))
				setScore(0);
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

	public void setScore(int score) {
		this.score = score;
	}

}