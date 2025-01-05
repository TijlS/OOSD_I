package domein;

public class Automaat {
	private int aantalItems;
	private int aantalMunten;
	private boolean muntInGleuf;
	private boolean ietsInBak;

	public Automaat(int aantalInhoud) {
		this.aantalItems = aantalInhoud;

		this.aantalMunten = 0;
		this.muntInGleuf = false;
		this.ietsInBak = false;
	}

	public void betaal() {
		setMuntInGleuf(true);
	}

	public boolean draaiHendel() {
		if (muntInGleuf && !ietsInBak && aantalItems > 0) {
			aantalItems--;
			aantalMunten++;

			setMuntInGleuf(false);
			setIetsInBak(true);

			return true;
		} else {
			setMuntInGleuf(false);

			return false;
		}
	}

	public void neemItem() {
		setIetsInBak(false);
	}

	public void neemMuntTerug() {
		setMuntInGleuf(false);
	}

	public int getAantalItems() {
		return aantalItems;
	}

	public void setAantalItems(int aantalItems) {
		this.aantalItems = aantalItems;
	}

	public int getAantalMunten() {
		return aantalMunten;
	}

	public void setAantalMunten(int aantalMunten) {
		this.aantalMunten = aantalMunten;
	}

	public boolean isMuntInGleuf() {
		return muntInGleuf;
	}

	public void setMuntInGleuf(boolean muntInGleuf) {
		this.muntInGleuf = muntInGleuf;
	}

	public boolean isItemInBak() {
		return ietsInBak;
	}

	public void setIetsInBak(boolean ietsInBak) {
		this.ietsInBak = ietsInBak;
	}

}
