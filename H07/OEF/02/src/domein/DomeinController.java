package domein;

import java.util.ArrayList;
import java.util.List;

import dto.RekeningDTO;

public class DomeinController {
	private RekeningRepository rr;

	public DomeinController() {
		super();
		rr = new RekeningRepository();
	}

	public void wijzigRekeningen() {
		rr.wijzigRekeningen();
	}

	public List<RekeningDTO> geefRekeningDTOs() {
		List<RekeningDTO> resultaat = new ArrayList<>();

		for (Rekening r : rr.getRekeningen()) {
			if (r instanceof ZichtRekening zr) {
				resultaat.add(new RekeningDTO(zr.getRekeningNr(), zr.getSaldo(), zr.getHouder(),
						zr.getMaxKredietOnderNul(), 0, 'Z'));
			}
			if (r instanceof SpaarRekening sr) {
				resultaat.add(new RekeningDTO(sr.getRekeningNr(), sr.getSaldo(), sr.getHouder(), 0,
						SpaarRekening.getAangroeiIntrest(), 'S'));
			}
		}

		return resultaat;
	}

}
