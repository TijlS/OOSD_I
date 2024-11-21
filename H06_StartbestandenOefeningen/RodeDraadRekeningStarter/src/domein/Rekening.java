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
		// TODO
		this.rekeningnummer = rekeningnummer;
	}

	private void setHouder(String houder) {
		// TODO
		this.houder = houder;
	}

	private void setSaldo(BigDecimal saldo) {
		// TODO
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
		// TODO
	}

	public void haalAf(BigDecimal bedrag) {
		// TODO
	}

	public void schrijfOver(BigDecimal bedrag, Rekening naarRekening) {
		// TODO
	}

}