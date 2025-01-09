package domein;

public class Lift {
	private final int laagsteVerdieping;
	private final int hoogsteVerdieping;
	private int verdieping;

	public Lift(int laagsteVerdieping, int hoogsteVerdieping) {
		controleerLaagsteEnHoogsteVerdieping(laagsteVerdieping, hoogsteVerdieping);

		this.laagsteVerdieping = laagsteVerdieping;
		this.hoogsteVerdieping = hoogsteVerdieping;
	}

	public void gaNaarOmhoog(int aantalVerdiepingen) {
		if (aantalVerdiepingen <= 0)
			throw new IllegalArgumentException("Het aantal verdiepingen moet groter zijn dan 0!");

		if (aantalVerdiepingen + verdieping > hoogsteVerdieping)
			setVerdieping(hoogsteVerdieping);
		else
			setVerdieping(aantalVerdiepingen + verdieping);
	}

	private void controleerLaagsteEnHoogsteVerdieping(int laagsteVerdieping, int hoogsteVerdieping) {
		if (laagsteVerdieping >= 0)
			throw new IllegalArgumentException("Laagste verdieping moet een strikt getal kleiner dan nul zijn!");

		if (hoogsteVerdieping <= 0)
			throw new IllegalArgumentException("Hoogste verdieping moet strikt positief zijn!");
	}

	private void setVerdieping(int verdieping) {
		if (verdieping < laagsteVerdieping || verdieping > hoogsteVerdieping)
			throw new IllegalArgumentException(String.format("Verdieping moet in intervan [%d, %d] liggen!",
					laagsteVerdieping, hoogsteVerdieping));

		this.verdieping = verdieping;
	}

	public int getVerdieping() {
		return verdieping;
	}

	public int getLaagsteVerdieping() {
		return laagsteVerdieping;
	}

	public int getHoogsteVerdieping() {
		return hoogsteVerdieping;
	}

}
