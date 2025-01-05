package domein;

import persistentie.VerplaatsingMapper;

public class VerplaatsingRepository {
	private final VerplaatsingMapper vMapper;
	private final Verplaatsing[] vpn;

	public VerplaatsingRepository() {
		vMapper = new VerplaatsingMapper();
		vpn = vMapper.geefVerplaatsingen();
	}

	public double geefKostenVerplaatsing(int index) {
		if (vpn[index] instanceof VerplaatsingPerBusTram verpl) {
			return verpl.berekenPrijs();
		}
		if (vpn[index] instanceof VerplaatsingPerAuto verpl) {
			return verpl.berekenPrijs();
		}

		return 0;
	}

	public double geefTotaleKosten() {
		double prijs = 0;

		for (int i = 0; i < vpn.length; i++) {
			prijs += geefKostenVerplaatsing(i);
		}

		return prijs;
	}

	public Verplaatsing[] getVpn() {
		return this.vpn;
	}
}
