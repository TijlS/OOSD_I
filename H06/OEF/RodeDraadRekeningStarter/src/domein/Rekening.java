package domein;

import java.math.BigDecimal;

public class Rekening {

	private long rekeningnummer;
	private String houder;
	private BigDecimal saldo;

	private static final int MAX_CIJFERS = 12;

	public Rekening(long rekeningnummer, String houder) {
		this(rekeningnummer, houder, BigDecimal.ZERO);
	}

	public Rekening(long rekeningnummer, String houder, BigDecimal saldo) {
		setRekeningnummer(rekeningnummer);
		setHouder(houder);
		setSaldo(saldo);
	}

	private void setRekeningnummer(long rekeningnummer) {
		if (Long.toString(rekeningnummer).length() > MAX_CIJFERS)
			throw new IllegalArgumentException(
					String.format("Rekeningnummer mag max. %d tekens lang zijn!", MAX_CIJFERS));
		this.rekeningnummer = rekeningnummer;
	}

	private void setHouder(String houder) {
		if (houder == null || houder.isBlank())
			throw new IllegalArgumentException("Houder moet ingevuld zijn!");
		this.houder = houder;
	}

	private void setSaldo(BigDecimal saldo) {
		if (saldo == null || saldo.signum() == -1)
			throw new IllegalArgumentException("Saldo mag niet negatief zijn!");
		this.saldo = saldo;
	}

	public long getRekeningnummer() {
		return rekeningnummer;
	}

	public String getHouder() {
		return houder;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void stort(BigDecimal bedrag) {
		if (bedrag.signum() == 1)
			this.setSaldo(this.saldo.add(bedrag));
	}

	public void haalAf(BigDecimal bedrag) {
		if (bedrag.signum() == 1)
			this.setSaldo(this.saldo.subtract(bedrag));
	}

	public void schrijfOver(BigDecimal bedrag, Rekening naarRekening) {
		if (naarRekening == null)
			throw new IllegalArgumentException("Ontvanger mag niet onbepaald zijn!");
		this.haalAf(bedrag);
		naarRekening.stort(bedrag);
	}

}