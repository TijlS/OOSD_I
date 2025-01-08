package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.ZichtRekening;

class ZichtrekeningTest {
	private final static double MIN_STORT_BEDRAG = 0.05;

	private ZichtRekening zr;

	@BeforeEach
	void before() {
		zr = new ZichtRekening();
	}

	private void stortBedragen(double[] bedragen) {
		for (double d : bedragen) {
			zr.stort(BigDecimal.valueOf(d));
		}
	}

	@Test
	void maakNieuweZichtrekening_ZonderBedrag_HeeftSaldoVanNulEuro() {
		assertEquals(BigDecimal.ZERO, zr.getSaldo());
	}

	@ParameterizedTest
	@ValueSource(doubles = { -10, MIN_STORT_BEDRAG - 0.01 })
	void stortBedrag_BedragTeKlein_WerptException(double bedrag) {
		assertThrows(IllegalArgumentException.class, () -> zr.stort(BigDecimal.valueOf(bedrag)));
	}

	@Test
	void stortBedrag_BedragIsNull_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> zr.stort(null));
	}

	@ParameterizedTest
	@ValueSource(doubles = { MIN_STORT_BEDRAG, 10 })
	void stortBedrag_BedragInOrdeLegeRekening_StortBedrag(double bedrag) {
		zr.stort(BigDecimal.valueOf(bedrag));

		assertEquals(BigDecimal.valueOf(bedrag), zr.getSaldo());
	}

	@Test
	void stortBedrag_BedragInOrdeEnAlGestort_VermeerderdSaldo() {
		stortBedragen(new double[] { 10, 15, 0.7 });

		zr.stort(BigDecimal.valueOf(10));

		assertEquals(BigDecimal.valueOf(35.7), zr.getSaldo());
	}

}
