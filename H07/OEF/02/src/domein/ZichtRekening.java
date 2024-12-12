package domein;

public class ZichtRekening extends Rekening {
	private double maxKredietOnderNul;

	public ZichtRekening(long rekeningNr, String houder, double maxKredietOnderNul) {
		super(rekeningNr, houder);
		this.setMaxKredietOnderNul(maxKredietOnderNul);
	}

	public double getMaxKredietOnderNul() {
		return maxKredietOnderNul;
	}

	public final void setMaxKredietOnderNul(double maxKredietOnderNul) {
		if (!(maxKredietOnderNul <= 0 && maxKredietOnderNul <= super.getSaldo()))
			throw new IllegalArgumentException("MaxKredietOnderNul moet negatief en <= saldo zijn!");

		this.maxKredietOnderNul = maxKredietOnderNul;
	}

	@Override
	public boolean haalAf(double bedrag) {
		if (getSaldo() - bedrag < maxKredietOnderNul)
			return false;

		return super.haalAf(bedrag);
	}

	@Override
	public String toString() {
		return String.format("%s. Max krediet onder nu= %.2f", super.toString(), this.maxKredietOnderNul);
	}
}
