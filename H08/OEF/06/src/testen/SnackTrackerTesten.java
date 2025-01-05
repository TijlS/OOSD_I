package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Categorie;
import domein.Snack;
import domein.SnackTracker;

class SnackTrackerTesten {
	private static final int MAX_SNACKS = 10;
	private SnackTracker st;
	private Snack gezondeSnack;
	private Snack ongezondeSnack;

	@BeforeEach
	void setup() {
		st = new SnackTracker();
		gezondeSnack = new Snack("Appel", Categorie.FRUIT);
		ongezondeSnack = new Snack("M&M", Categorie.SNOEP);
	}

	private void registreerSnacks(Snack[] snacks) {
		for (Snack snack : snacks) {
			st.registreerSnack(snack);
		}
	}

	@Test
	void maakSnackTracker_MaaktSnackTrackerZonderSnacks() {
		for (Snack s : st.getSnacks()) {
			assertNull(s);
		}
	}

	@Test
	void maakSnackTracker_MaaktSnackTrackerMetPlaatsVoorExact10Snacks() {
		assertEquals(MAX_SNACKS, st.getSnacks().length);
	}

	@Test
	void isGezondGesnackt_GeenGeregistreerdeSnack_RetourneertTrue() {
		assertTrue(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_EenGezondeSnackGeregistreerd_RetourneertTrue() {
		registreerSnacks(new Snack[] { gezondeSnack });
		assertTrue(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_EenOngezondeSnackGeregistreerd_RetourneertFalse() {
		registreerSnacks(new Snack[] { ongezondeSnack });
		assertFalse(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_EvenveelGezondeOngezondeSnacksGeregistreerd_RetourneertFalse() {
		registreerSnacks(new Snack[] { ongezondeSnack, gezondeSnack });
		assertFalse(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_AantalGezondeSnacksIsNietDeHelftVanDeGeregistreerdeSnacks_RetourneertFalse() {
		registreerSnacks(new Snack[] { ongezondeSnack, ongezondeSnack, ongezondeSnack });
		assertFalse(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_AantalGezondeSnacksIsNetDeHelftVanDeGeregistreerdeSnacks_RetourneertFalse() {
		registreerSnacks(new Snack[] { ongezondeSnack, ongezondeSnack, gezondeSnack });
		assertFalse(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_MeerDanDeHelftVanDeGeregistreerdeSnacksZijnGezond_RetourneertTrue() {
		registreerSnacks(new Snack[] { gezondeSnack, gezondeSnack, gezondeSnack });
		assertTrue(st.isGezondGesnackt());
	}

	@Test
	void isGezondGesnackt_NetMeerDanDeHelftVanDeGeregistreerdeSnacksZijnGezond_RetourneertTrue() {
		registreerSnacks(new Snack[] { gezondeSnack, gezondeSnack, ongezondeSnack });
		assertTrue(st.isGezondGesnackt());
	}

	@Test
	void registreerSnack_SnackIsNull_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> st.registreerSnack(null));
	}

	private void registreerGezondeSnacksVastAantal(int aantal) {
		for (int i = 0; i < aantal; i++) {
			st.registreerSnack(gezondeSnack);
		}
	}

	@Test
	void registreerSnack_MaxAantalSnacksReedsGeregistreerd_WerptException() {
		registreerGezondeSnacksVastAantal(MAX_SNACKS);
		assertThrows(IllegalArgumentException.class, () -> st.registreerSnack(gezondeSnack));
	}

	@Test
	void registreerSnack_NetGeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {
		registreerGezondeSnacksVastAantal(MAX_SNACKS - 1);
		st.registreerSnack(ongezondeSnack);
		assertEquals(MAX_SNACKS, st.geefAantalGeregistreerdeSnacks());
		assertTrue(Arrays.asList(st.getSnacks()).indexOf(ongezondeSnack) != -1);
	}

	@Test
	void registreerSnack_GeenMaxAantalSnacksGeregistreerd_RegistreertDeSnack() {
		registreerSnacks(new Snack[] { gezondeSnack, gezondeSnack, gezondeSnack, ongezondeSnack });
		assertEquals(4, st.geefAantalGeregistreerdeSnacks());
		assertTrue(Arrays.asList(st.getSnacks()).indexOf(ongezondeSnack) != -1);

	}

	@Test
	void geefAantalGeregistreerdeSnacks_LegeSnackTracker_Retourneert0() {
		assertEquals(0, st.geefAantalGeregistreerdeSnacks());
	}

	@Test
	void geefAantalGeregistreerdeSnacks_NietLegeSnackTracker_RetourneertAantalGeregistreerdeSnacks() {
		registreerSnacks(new Snack[] { gezondeSnack, ongezondeSnack });
		assertEquals(2, st.geefAantalGeregistreerdeSnacks());
	}

}
