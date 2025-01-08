package domein;

import java.math.BigDecimal;

public class ZichtRekening {
	private BigDecimal saldo;

	public ZichtRekening() {
		this.saldo = BigDecimal.ZERO;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void stort(BigDecimal bedrag) {
		if (bedrag == null || bedrag.compareTo(BigDecimal.valueOf(0.05)) == -1) {
			throw new IllegalArgumentException("Bedrag moet groter zijn dan €0.05");
		}

		setSaldo(saldo.add(bedrag));
	}

	private void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
