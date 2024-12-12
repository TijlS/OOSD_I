package domein;

import java.util.List;

import persistentie.RekeningMapper;

public class RekeningRepository {
	private final RekeningMapper rm;
	private List<Rekening> rekeningen;

	public RekeningRepository() {
		super();
		rm = new RekeningMapper();
		rekeningen = rm.geefRekeningen();
	}

	public List<Rekening> getRekeningen() {
		return rekeningen;
	}

	public void wijzigRekeningen() {
		for (Rekening r : rekeningen) {
			if (r instanceof SpaarRekening) {
				r.stortOp(r.getSaldo() * SpaarRekening.getAangroeiIntrest() / 100);
			}
			if (r instanceof ZichtRekening zr) {
				zr.setMaxKredietOnderNul(zr.getMaxKredietOnderNul() - 10);
			}
		}
	}

}
