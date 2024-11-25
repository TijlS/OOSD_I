package domein;

public class Marktkraam {
	private String kraamhouder;
	private int breedte;
	private double inkomsten;

	private static final double PRIJS_PER_M_TOT_5M = 3;
	private static final double PRIJS_PER_M = 2.5;

	public Marktkraam(String kraamhouder, int breedte) {
		super();
		this.setKraamhouder(kraamhouder);
		this.setBreedte(breedte);
	}

	public String getKraamhouder() {
		return kraamhouder;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setKraamhouder(String kraamhouder) {
		if (kraamhouder == null || kraamhouder.isBlank() || kraamhouder.isEmpty()) {
			this.kraamhouder = "anoniem";
		} else {
			this.kraamhouder = kraamhouder;
		}
	}

	private void setBreedte(int breedte) {
		if (breedte >= 2 && breedte <= 10) {
			this.breedte = breedte;
		} else {
			this.breedte = 10;
		}
	}

	public void ontvang(double bedrag) {
		if (bedrag >= 0)
			this.inkomsten += bedrag;
	}

	public double geefWinst() {
		double kostprijs = 0;

		if (this.breedte <= 5)
			kostprijs = this.breedte * PRIJS_PER_M_TOT_5M;
		else
			kostprijs = this.breedte * PRIJS_PER_M;

		return this.inkomsten - kostprijs;
	}
}
