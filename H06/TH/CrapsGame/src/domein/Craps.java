package domein;

import utils.Status;

public class Craps {
	// constanten voor de belangrijkste worpen
	private final static int SNAKE_EYES = 2;
	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;

	private int totaalEersteWorp;
	private Status spelStatus = Status.SPELEN; // enum voor de status van het spel
	private Dobbelsteen[] dobbelstenen;

	public Craps()
	{
		dobbelstenen = new Dobbelsteen[2];
		for (int index = 0; index < dobbelstenen.length; index++)
			dobbelstenen[index] = new Dobbelsteen();
	}
	
	public void speelEersteRonde() {
		rolDobbelstenen();
		int som = geefTotaalGeworpen();
		switch (som) {
		case SEVEN, YO_LEVEN -> spelStatus = Status.GEWONNEN;
		case SNAKE_EYES, TREY, BOX_CARS -> spelStatus = Status.VERLOREN;
		default -> totaalEersteWorp = som;
		}
	}

	public void speelVerder() {
		rolDobbelstenen();
		int nieuweSom = geefTotaalGeworpen();
		if (nieuweSom == totaalEersteWorp)
			spelStatus = Status.GEWONNEN;
		else if (nieuweSom == SEVEN)
			spelStatus = Status.VERLOREN;
	}

	public int getTotaalEersteWorp() {
		return totaalEersteWorp;
	}

	public Status getSpelStatus() {
		return spelStatus;
	}

	// methode die een array retourneert
	public int[] geefAantalOgenDobbelStenen() {
		int[] resultaat = new int[dobbelstenen.length];
		int index = 0;
		for (Dobbelsteen dobbelsteen : dobbelstenen)
			resultaat[index++] = dobbelsteen.getAantalOgen();
		return resultaat;
	}

	public boolean isNogBezig() {
		return spelStatus == Status.SPELEN;
	}

	public int geefTotaalGeworpen() {
		int somAantalOgen = 0;
		for (Dobbelsteen dobbelsteen : dobbelstenen)
			somAantalOgen += dobbelsteen.getAantalOgen();
		return somAantalOgen;
	}

	private void rolDobbelstenen() {
		for (Dobbelsteen dobbelsteen : dobbelstenen)
			dobbelsteen.rol();
	}
}
