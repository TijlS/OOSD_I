package domein;

import java.math.BigDecimal;

public class Zichtrekening {

	private BigDecimal saldo;

	/**
	 * Class constructor. Een nieuwe zichtrekening heeft een saldo van 0 Euro.
	 * 
	 */
	public Zichtrekening() {
		// TODO - implement Zichtrekening.Zichtrekening
		throw new UnsupportedOperationException();
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	private void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/**
	 * Stort een bedrag op deze zichtrekening. Het bedrag die gestort wordt moet
	 * minstens 0.05 Euro bedragen.
	 * 
	 * @param bedrag de <code>BigDecimal</code> waarmee het saldo van deze
	 *               zichtrekening moet verhoogd worden
	 * @throws IllegalArgumentException voor een ongeldig bedrag
	 * 
	 */
	public void stort(BigDecimal bedrag) {
		// TODO - implement Zichtrekening.stort
		throw new UnsupportedOperationException();
	}

}