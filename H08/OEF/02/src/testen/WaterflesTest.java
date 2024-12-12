package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Waterfles;

public class WaterflesTest {
	private final static int MAX_CAPACITEIT = 2000;
	private final static int CAPACITEIT = 250;

	private Waterfles waterflesMetInhoud50;

	@BeforeEach
	private void maakWaterflesMetInhoud50EnCapaciteit250() {
		waterflesMetInhoud50 = new Waterfles(CAPACITEIT);
		waterflesMetInhoud50.vulBij(50);
	}

	/*
	 * Volgende waarden voor capaciteit:
	 * 
	 * 50: maakWaterfles_CapaciteitTeKlein_WerptException 99:
	 * maakWaterfles_CapaciteitNetTeKlein_WerptException - 100 ->
	 * maakWaterfles_GeldigeCapaciteitKleinstMogelijk_MaaktWaterflesMetOpgegevenCapaciteit
	 * - 1789 ->
	 * maakWaterfles_GeldigeCapaciteit_MaaktWaterflesMetOpgegevenCapaciteit - 2000
	 * ->
	 * maakWaterfles_GeldigeCapaciteitGrootstMogelijk_MaaktWaterflesMetOpgegevenCapaciteit
	 * - 2001 -> maakWaterfles_CapaciteitNetTeGroot_WerptException - 3500 ->
	 * maakWaterfles_CapaciteitTeGroot_WerptException
	 */

	@ParameterizedTest
	@ValueSource(ints = { 50, 99, MAX_CAPACITEIT + 1, 3500 })
	void maakWaterfles_OngeldigeCapaciteit_WerptException(int capaciteit) {
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
	}

	@ParameterizedTest
	@ValueSource(ints = { 100, 1789, MAX_CAPACITEIT })
	void maakWaterfles_GeldigeCapaciteit_MaaktWaterflesMetOpgegevenCapaciteit(int capaciteit) {
		Waterfles fles = new Waterfles(capaciteit);

		assertEquals(capaciteit, fles.getCapaciteit());
		assertEquals(0, fles.getInhoud());
	}

	/*
	 * CAP INH HVWATER NAAM 250 50 -5 HoeveelheidWaterIsKleinerDanNul_WerptException
	 * 250 50 0 HoeveelheidWaterIsNul_WerptException 250 50 1
	 * HoeveelheidWaterIsKleinstMogelijk_VermeerderdInhoudVanFles 250 50 50
	 * HoeveelheidWaterDoetFlesNietOverlopen_VermeerderdInhoudVanFles 250 50 200
	 * HoeveelheidWaterDoetFlesNetNietOverlopen_VermeerderdInhoudVanFles 250 50 201
	 * HoeveelheidWaterDoetFlesNetOverlopen_VermeerderdInhoudVanFlesTotZijnCapaciteit
	 * 250 50 250
	 * HoeveelheidWaterDoetFlesOverlopen_VermeerderdInhoudVanFlesTotZijnCapaciteit
	 */

	@ParameterizedTest
	@ValueSource(ints = { -5, 0 })
	void vulBij_HoeveelheidWaterOngeldig_WerptException(int hoeveelheidWater) {
		assertThrows(IllegalArgumentException.class, () -> waterflesMetInhoud50.vulBij(hoeveelheidWater));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 50, 200 })
	void vulBij_HoeveelheidWaterDoetFlesNietOverlopen_VermeerderdInhoudVanFles(int hoeveelheidWater) {
		waterflesMetInhoud50.vulBij(hoeveelheidWater);

		assertEquals(50 + hoeveelheidWater, waterflesMetInhoud50.getInhoud());
	}

	@ParameterizedTest
	@ValueSource(ints = { 201, 250 })
	void vulBij_HoeveelheidWaterDoetFlesOverlopen_VermeerderdInhoudVanFlesTotCapaciteit(int hoeveelheidWater) {
		waterflesMetInhoud50.vulBij(hoeveelheidWater);

		assertEquals(CAPACITEIT, waterflesMetInhoud50.getInhoud());
	}
}
