package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.AanvraagTelewerk;
import utils.Weekdag;

class AanvraagTelewerkTest {

	// tag::constructor[]
	private AanvraagTelewerk at;
	 
	private static final String CORRECTE_NAAM = "Abcde";
	
	@ParameterizedTest
	@NullAndEmptySource		//<1>
	@ValueSource(strings= {"\t\t", "    ", "A"})	//<2>
	void maakAanvraagTelewerk_NaamLeegOfTeKort_WerptException(String naam) {
		assertThrows(IllegalArgumentException.class, ()-> new AanvraagTelewerk(naam)); 
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Ab", CORRECTE_NAAM})
	void maakAanvraagTelewerk_GeldigeNaam_maaktAanvraagTelewerk(String naam) {
		 AanvraagTelewerk at=new AanvraagTelewerk(naam);
		 assertEquals(naam, at.getNaam());
		 assertTrue(at.getDagenThuiswerk().isEmpty());
	}
	// end::constructor[]
	
	// tag::voegDagToe[]
	private static final String VERBODEN_DAG_ALS_STRING = "MAANDAG";
	private static final String AL_GEKOZEN_DAG_ALS_STRING = "DINSDAG";
	
	private static final Weekdag AL_GEKOZEN_DAG = Weekdag.valueOf(AL_GEKOZEN_DAG_ALS_STRING);

	private void maakAanvraagMetAl1GekozenDag() {
		at = new AanvraagTelewerk(CORRECTE_NAAM);
		at.voegDagToe(AL_GEKOZEN_DAG);
	}
	
	@ParameterizedTest
	@EnumSource(		//<1>
			value = Weekdag.class, 		//<2>
			names= {VERBODEN_DAG_ALS_STRING,AL_GEKOZEN_DAG_ALS_STRING})		//<3> 
	void voegDagToe_OngeldigeDagen_WerptException(Weekdag dag) {			//<4>
		maakAanvraagMetAl1GekozenDag(); 
		assertThrows(IllegalArgumentException.class, ()-> at.voegDagToe(dag)); 
	}
	
	@ParameterizedTest
	@EnumSource(
			value = Weekdag.class, 
			names= {VERBODEN_DAG_ALS_STRING,AL_GEKOZEN_DAG_ALS_STRING},
			mode = EnumSource.Mode.EXCLUDE			//<5>
			)
	void voegDagToe_GeldigeDag_voegtDagToe(Weekdag dag) {
		maakAanvraagMetAl1GekozenDag(); 
		at.voegDagToe(dag);
		assertEquals(2, at.getDagenThuiswerk().size());
		assertTrue(at.getDagenThuiswerk().contains(AL_GEKOZEN_DAG));
		assertTrue(at.getDagenThuiswerk().contains(dag)); 			//<6>
	}
	// end::voegDagToe[]
	
	// tag::controleerVoorVerzenden[]
	private void maakAanvraagMetDagen(int aantalDagen) { 			//<1>
		at = new AanvraagTelewerk(CORRECTE_NAAM);
		for(int i=0; i<aantalDagen; i++)
			at.voegDagToe(Weekdag.values()[i+1]); 			//<2>
	}
	
	@ParameterizedTest
	@ValueSource(ints= {0, 4})
	void controleerVoorVerzenden_OngeldigAantalDagen_ReturnsFalse(int aantalDagen) {
		maakAanvraagMetDagen(aantalDagen); 
		assertFalse(at.controleerVoorVerzenden());
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1, 2, 3})
	void controleerVoorVerzenden_GeldigAantalDagen_ReturnsTrue(int aantalDagen) {
		maakAanvraagMetDagen(aantalDagen); 
		assertTrue(at.controleerVoorVerzenden());
	}
	// end::controleerVoorVerzenden[]

}
