package testen;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Kluis;

class KluisTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "1", "123", "1234567", "12345", "12A3", "3333" })
	void maakKluis_OngeldigeCode_WerptException(String ongeldigeCode) {
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeBestaatUitNetGeen4GelijkeCijfers_MaaktKluis() {
		// arrange
		String geldigeCode = "3133";
		// act & assert
		assertDoesNotThrow(() -> new Kluis(geldigeCode));
	}

	@Test
	void valideer_CodesKomenOvereen_RetourneertTrue() {
		// arrange
		String geldigeCode = "3133";
		Kluis kluis = new Kluis(geldigeCode);
		// act
		boolean resultaat = kluis.valideerCode(geldigeCode);
		// assert
		assertTrue(resultaat);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "1222", "1286" })
	void valideer_CodesVerschillen_RetourneertFalse(String code) {
		// arrange
		String geldigeCode = "1285";
		Kluis kluis = new Kluis(geldigeCode);
		// act
		boolean resultaat = kluis.valideerCode(code);
		// assert
		assertFalse(resultaat);
	}
}