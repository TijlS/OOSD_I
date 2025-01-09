package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Lift;

class LiftTest {

	private static final int GELDIGE_LAAGSTE_VERDIEPING = -3;
	private static final int GELDIGE_HOOGSTE_VERDIEPING = 3;

	private Lift l;

	@BeforeEach
	void before() {
		l = new Lift(GELDIGE_LAAGSTE_VERDIEPING, GELDIGE_HOOGSTE_VERDIEPING);
	}

	@Test
	void maakLift_OngeldigeLaagsteVerdiepingEnOngeldieHoogsteVerdieping() {
		assertThrows(IllegalArgumentException.class, () -> new Lift(0, 0));
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1 })
	void maakLift_OngeldigeLaagsteVerdiepingEnGeldigeHoogsteVerdieping_WerptException(int laagsteVerdieping) {
		assertThrows(IllegalArgumentException.class, () -> new Lift(laagsteVerdieping, GELDIGE_HOOGSTE_VERDIEPING));
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, 0 })
	void maakLift_GeldigeLaagsteVerdiepingEnOngeldigeHoogsteVerdieping_WerptException(int hoogsteVerdieping) {
		assertThrows(IllegalArgumentException.class, () -> new Lift(GELDIGE_LAAGSTE_VERDIEPING, hoogsteVerdieping));
	}

	/**
	 * gaNaarOmhoog <br>
	 * - negatief verdiep -> EXCEPTION <br>
	 * - verdiep 0 -> EXCEPTION <br>
	 * - geen verdiep -> EXCEPTION <br>
	 * - wel verdiep, minder dan hoogste -> OMHOOG <br>
	 * - wel verdiep, hoger dan hoogste -> TOT HOOGSTE
	 */

	@ParameterizedTest
	@ValueSource(ints = { -3, 0 })
	void gaNaarOmhoog_OngeldigVerdiep_WerptException(int verdiep) {
		assertThrows(IllegalArgumentException.class, () -> l.gaNaarOmhoog(verdiep));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, GELDIGE_HOOGSTE_VERDIEPING - 1, GELDIGE_HOOGSTE_VERDIEPING })
	void gaNaarOmhoog_GeldigVerdiepGelijkAanHoogste_gaatOmhoog(int verdiep) {
		l.gaNaarOmhoog(verdiep);

		assertEquals(verdiep, l.getVerdieping());
	}

	@Test
	void gaNaarOmhoog_GeldigVerdiepHogerDanHoogste_gaatOmhoog() {
		l.gaNaarOmhoog(GELDIGE_HOOGSTE_VERDIEPING + 1);

		assertEquals(GELDIGE_HOOGSTE_VERDIEPING, l.getVerdieping());
	}

}
