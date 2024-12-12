// Zonder @Before en constanten
//package testen;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import domein.Rechthoek;
//
//class RechthoekTest {
//
//	@Test
//	void maakRechthoek_LengteEnBreedtePositief_MaaktRechthoek() {
//		Rechthoek r = new Rechthoek(10, 5);
//		assertEquals(10, r.getLengte());
//		assertEquals(5, r.getBreedte());
//	}
//
//	@Test
//	void maakRechthoek_LengteNetGroterDanNul_MaaktRechthoek() {
//		Rechthoek r = new Rechthoek(Double.MIN_VALUE, 5);
//		assertEquals(Double.MIN_VALUE, r.getLengte());
//		assertEquals(5, r.getBreedte());
//	}
//
//	@Test
//	void maakRechthoek_BreedteNetGroterDanNul_MaaktRechthoek() {
//		Rechthoek r = new Rechthoek(10, Double.MIN_VALUE);
//		assertEquals(10, r.getLengte());
//		assertEquals(Double.MIN_VALUE, r.getBreedte());
//	}
//
//	@ParameterizedTest
//	@ValueSource(doubles = { 0, -10 })
//	void maakRechthoek_LengteNietStriktPositief_WerptException(double lengte) {
//		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(lengte, 5));
//	}
//
//	@ParameterizedTest
//	@ValueSource(doubles = { 0, -5 })
//	void maakRechthoek_BreedteNietStriktPositief_WerptException(double breedte) {
//		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(10, breedte));
//	}
//
//	@Test
//	void geefOmtrek_RetourneertDeOmtrek() {
//		Rechthoek r = new Rechthoek(10, 5);
//		assertEquals(30, r.geefOmtrek());
//	}
//
//	@Test
//	void geefOppervlakte_RetourneertDeOppervlakte() {
//		Rechthoek r = new Rechthoek(10, 5);
//		assertEquals(50, r.geefOppervlakte());
//	}
//
//	@Test
//	void schaal_GeldigPrecentage_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10, 5);
//		r.schaal(50);
//		assertEquals(5, r.getLengte(), 0.01);
//		assertEquals(2.5, r.getBreedte(), 0.01);
//	}
//
//	@Test
//	void schaal_PercentageGrootstMogelijk_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10, 5);
//		r.schaal(200);
//		assertEquals(20, r.getLengte(), 0.01);
//		assertEquals(10, r.getBreedte(), 0.01);
//	}
//
//	@Test
//	void schaal_PercentageKleinstMogelijk_SchaaltDeRechthoek() {
//		Rechthoek r = new Rechthoek(10, 5);
//		r.schaal(1);
//		assertEquals(0.1, r.getLengte(), 0.01);
//		assertEquals(0.05, r.getBreedte(), 0.01);
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = { 0, -10, 201, 210 })
//	void schaal_OngeldigSchalingsPercentage_WerptException(int percentage) {
//		Rechthoek r = new Rechthoek(10, 5);
//		assertThrows(IllegalArgumentException.class, () -> r.schaal(percentage));
//	}
//}

// Met @Before en constanten
package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Rechthoek;

class RechthoekTest {
	private Rechthoek r;
	
	private static final int MIN_LENGTE_BREEDTE = 0;
	private static final int MIN_PERCENTAGE_SCHAAL = 1;
	private static final int MAX_PERCENTAGE_SCHAAL = 200;
	private static final int EEN_CORRECTE_LENGTE = 10;
	private static final int EEN_CORRECTE_BREEDTE = 5;

	@BeforeEach
	void setUp() {
		r = new Rechthoek(EEN_CORRECTE_LENGTE, EEN_CORRECTE_BREEDTE);
	}

	@Test
	void maakRechthoek_LengteEnBreedtePositief_MaaktRechthoek() {
		assertEquals(10, r.getLengte());
		assertEquals(5, r.getBreedte());
	}

	@Test
	void maakRechthoek_LengteNetGroterDanNul_MaaktRechthoek() {
		Rechthoek r = new Rechthoek(Double.MIN_VALUE, EEN_CORRECTE_BREEDTE);
		assertEquals(Double.MIN_VALUE, r.getLengte());
		assertEquals(5, r.getBreedte());
	}

	@Test
	void maakRechthoek_BreedteNetGroterDanNul_MaaktRechthoek() {
		Rechthoek r = new Rechthoek(EEN_CORRECTE_LENGTE, Double.MIN_VALUE);
		assertEquals(10, r.getLengte());
		assertEquals(Double.MIN_VALUE, r.getBreedte());
	}

	@ParameterizedTest
	@ValueSource(doubles = { MIN_LENGTE_BREEDTE, -10 })
	void maakRechthoek_LengteNietStriktPositief_WerptException(double lengte) {
		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(lengte, EEN_CORRECTE_BREEDTE));
	}

	@ParameterizedTest
	@ValueSource(doubles = { MIN_LENGTE_BREEDTE, -10 })
	void maakRechthoek_BreedteNietStriktPositief_WerptException(double breedte) {
		assertThrows(IllegalArgumentException.class, () -> new Rechthoek(EEN_CORRECTE_LENGTE, breedte));
	}

	@Test
	void geefOmtrek_RetourneertDeOmtrek() {
		assertEquals(30, r.geefOmtrek());
	}

	@Test
	void geefOppervlakte_RetourneertDeOppervlakte() {
		assertEquals(50, r.geefOppervlakte());
	}

	@Test
	void schaal_GeldigPercentage_SchaaltDeRechthoek() {
		r.schaal(50);
		assertEquals(5, r.getLengte(), 0.01);
		assertEquals(2.5, r.getBreedte(), 0.01);
	}

	@Test
	void schaal_PercentageGrootstMogelijk_SchaaltDeRechthoek() {
		r.schaal(MAX_PERCENTAGE_SCHAAL);
		assertEquals(20, r.getLengte(), 0.01);
		assertEquals(10, r.getBreedte(), 0.01);
	}

	@Test
	void schaal_PercentageKleinstMogelijk_SchaaltDeRechthoek() {
		r.schaal(MIN_PERCENTAGE_SCHAAL);
		assertEquals(0.1, r.getLengte(), 0.01);
		assertEquals(0.05, r.getBreedte(), 0.01);
	}

	@ParameterizedTest
	@ValueSource(ints = { MIN_PERCENTAGE_SCHAAL-1, -10, MAX_PERCENTAGE_SCHAAL+1, 210 })
	void schaal_OngeldigSchalingsPercentage_WerptException(int percentage) {
		assertThrows(IllegalArgumentException.class, () -> r.schaal(percentage));
	}
}
