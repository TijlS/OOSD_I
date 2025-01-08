package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.ResultatenLijst;

class ResultatenlijstTest {

	private final static int MIN_RESULTAAT = 0;
	private final static int MAX_RESULTAAT = 20;

	private ResultatenLijst rl;

	@BeforeEach
	void before() {
		rl = new ResultatenLijst();
	}

	private void vulResulatenLijst(int[] resultaten) {
		for (int i : resultaten) {
			rl.voegResultaatToe(i);
		}
	};

	@Test
	void maakLegeResultatenlijst_MaaktResultatenLijstZonderGetallen() {
		assertTrue(rl.getResultaten().isEmpty());
	}

	@Test
	void maakLegeResulatenlijst_berekenGemiddelde_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new ResultatenLijst().geefGemiddelde());
	}

	@ParameterizedTest
	@ValueSource(ints = { -5, MIN_RESULTAAT - 1, MAX_RESULTAAT + 1, 25 })
	void voegResultaatToe_OngeldigeWaardeEnLijstNogNietVol_WerptException(int resultaat) {
		vulResulatenLijst(new int[] { 2, 7, 8 });
		assertThrows(IllegalArgumentException.class, () -> rl.voegResultaatToe(resultaat));
	}

	@ParameterizedTest
	@ValueSource(ints = { MIN_RESULTAAT, 10, MAX_RESULTAAT })
	void voegResultaatToe_GeldigeWaardeEnLijstNogNietVol_voegtResultaatToe(int resultaat) {
		vulResulatenLijst(new int[] { 2, 7, 8 });

		rl.voegResultaatToe(resultaat);

		assertEquals(4, rl.getResultaten().size());
		assertTrue(rl.getResultaten().contains(resultaat));
	}

	@Test
	void voegResultaatToe_GeldigResultaatEnLijstNetNietVol_VoegtResultaatToe() {
		vulResulatenLijst(new int[] { 2, 7, 8, 9 });

		rl.voegResultaatToe(10);

		assertEquals(5, rl.getResultaten().size());
		assertTrue(rl.getResultaten().contains(10));
	}

	@Test
	void voegResultaatToe_GeldigeResultaatEnLijstVol_WerptException() {
		vulResulatenLijst(new int[] { 2, 7, 8, 9, 10 });
		assertThrows(IllegalArgumentException.class, () -> rl.voegResultaatToe(11));
	}

	@Test
	void berekenGemiddelde_LijstMetResultaten_geeftJuisteGemiddelde() {
		vulResulatenLijst(new int[] { 10, 10, 10 });

		assertEquals(10, rl.geefGemiddelde());
	}

	@Test
	void berekenGemiddelde_LijstMetResultatenNul_geeftJuisteGemiddelde() {
		vulResulatenLijst(new int[] { 0, 0, 0 });

		assertEquals(0, rl.geefGemiddelde());
	}

	@Test
	void berekenGemiddelde_LijstMetEenResultaten_geeftJuisteGemiddelde() {
		vulResulatenLijst(new int[] { 10 });

		assertEquals(10.000, rl.geefGemiddelde());
	}

	@Test
	void berekenGemiddelde_LijstMetMaxResultaten_geeftJuisteGemiddelde() {
		vulResulatenLijst(new int[] { 4, 5, 10, 13, 15 });

		assertEquals(9.4, rl.geefGemiddelde());
	}

}
