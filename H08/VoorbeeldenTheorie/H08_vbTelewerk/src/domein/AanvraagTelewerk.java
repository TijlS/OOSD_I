package domein;

import java.util.List;
import java.util.ArrayList;

import utils.Weekdag;

public class AanvraagTelewerk {
	private final String naam;
	private List<Weekdag> dagenThuiswerk;
	
	private static final int MIN_AANTAL_TEKENS_NAAM = 2;
	private static final int MAX_AANTAL_DAGEN_TELEWERK = 3;
	private static final Weekdag VERBODEN_TELEWERK_DAG = Weekdag.MAANDAG;
	
	public AanvraagTelewerk(String naam) {
		controleerNaam(naam); 
		this.naam = naam; 
		this.dagenThuiswerk = new ArrayList<>(); 
	}
	
	private void controleerNaam(String naam) {
		if(naam == null || naam.isBlank())
			throw new IllegalArgumentException("Naam mag niet leeg zijn"); 
		if(naam.length()<MIN_AANTAL_TEKENS_NAAM)
			throw new IllegalArgumentException(String.format("Naam moet langer dan %d tekens zijn", naam)); 
	}
	
	public void voegDagToe(Weekdag dag) {
		if(dag.equals(VERBODEN_TELEWERK_DAG))
			throw new IllegalArgumentException(String.format("Telewerk is niet toegelaten op %s of in het weekend", VERBODEN_TELEWERK_DAG.name())); 
		if(dagenThuiswerk.contains(dag))
			throw new IllegalArgumentException("Deze dag staat al in de lijst!"); 
		dagenThuiswerk.add(dag);
	}
	
	public boolean controleerVoorVerzenden() {
		return !dagenThuiswerk.isEmpty() && dagenThuiswerk.size()<=MAX_AANTAL_DAGEN_TELEWERK;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public List<Weekdag> getDagenThuiswerk() {
		return dagenThuiswerk;
	}
}

/* ===== De klasse AanvraagTelewerk na code generatie uit VP ===== */
//public class AanvraagTelewerk {
//
//	private final String naam;
//	private List<Weekdag> dagenThuiswerk;
//
//	private static final int MIN_AANTAL_TEKENS_NAAM = 2;
//	private static final int MAX_AANTAL_DAGEN_TELEWERK = 3;
//	private static final Weekdag VERBODEN_TELEWERK_DAG = Dag.MAANDAG;
//
//
//	public AanvraagTelewerk(String naam) {
//		// TODO - implement AanvraagTelewerk.AanvraagTelewerk
//		throw new UnsupportedOperationException();
//	}
//
//	private void controleerNaam(String naam) {
//		// TODO - implement AanvraagTelewerk.controleerNaam
//		throw new UnsupportedOperationException();
//	}
//
//	public void voegDagToe(Weekdag dag) {
//		// TODO - implement AanvraagTelewerk.voegDagToe
//		throw new UnsupportedOperationException();
//	}
//
//	public boolean controleerVoorVerzenden() {
//		// TODO - implement AanvraagTelewerk.controleerVoorVerzenden
//		throw new UnsupportedOperationException();
//	}
//
//	public String getNaam() {
//		return this.naam;
//	}
//
//	public List<Weekdag> getDagenThuiswerk() {
//		return dagenThuiswerk;
//	}
//}
