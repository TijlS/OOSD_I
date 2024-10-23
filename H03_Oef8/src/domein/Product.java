package domein;

public class Product {
	private String naam;
	private double prijsExclBtw;
	private int btwPercentage;
	private int kortingStuksPercentage;

	private final static int DEFAULT_PRIJS_EXCL_BTW = 1;
	private final static int ONDERGRENS_BTW = 6;
	private final static int BOVENGRENS_BTW = 21;
	private final static int BOVENGRENS_KORTING_STUKS = 50;
	private final static int MINIMUM_AANTAL_STUKS = 6;

	public Product(String naam, double prijsExclBtw, int btwPercentage, int kortingStuksPercentage) {
		super();
		this.setNaam(naam);
		this.setPrijsExclBtw(prijsExclBtw);
		this.setBtwPercentage(btwPercentage);
		this.setKortingStuksPercentage(kortingStuksPercentage);
	}

	public double berekenPrijs(int aantal) {
		double prijsMetBtw = prijsExclBtw + (prijsExclBtw / 100 * btwPercentage);
		double totalePrijs = prijsMetBtw * aantal;
		double korting = aantal >= MINIMUM_AANTAL_STUKS ? (prijsMetBtw / 100 * kortingStuksPercentage) * aantal : 0;

		return totalePrijs - korting;
	}

	public double getPrijsExclBtw() {
		return prijsExclBtw;
	}

	public void setPrijsExclBtw(double prijsExclBtw) {
		if (prijsExclBtw > 0)
			this.prijsExclBtw = prijsExclBtw;
		else
			this.prijsExclBtw = DEFAULT_PRIJS_EXCL_BTW;
	}

	public int getBtwPercentage() {
		return btwPercentage;
	}

	public void setBtwPercentage(int btwPercentage) {
		if (btwPercentage >= ONDERGRENS_BTW && btwPercentage <= BOVENGRENS_BTW)
			this.btwPercentage = btwPercentage;
		else
			this.btwPercentage = BOVENGRENS_BTW;
	}

	public int getKortingStuksPercentage() {
		return kortingStuksPercentage;
	}

	public void setKortingStuksPercentage(int kortingStuksPercentage) {
		if (kortingStuksPercentage > 0 && kortingStuksPercentage <= BOVENGRENS_KORTING_STUKS)
			this.kortingStuksPercentage = kortingStuksPercentage;
		else
			this.kortingStuksPercentage = 0;
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		this.naam = naam;
	}

}
