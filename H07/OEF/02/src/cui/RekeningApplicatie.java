package cui;

import java.util.List;

import domein.DomeinController;
import dto.RekeningDTO;

public class RekeningApplicatie {
	private DomeinController dc;

	public RekeningApplicatie(DomeinController dc) {
		super();
		this.dc = dc;
	}

	public void werkMetRekeningen() {
		toonAlleRekeningen(dc.geefRekeningDTOs());

		dc.wijzigRekeningen();

		toonAlleRekeningen(dc.geefRekeningDTOs());
	}

	public void toonAlleRekeningen(List<RekeningDTO> dtos) {
		for (RekeningDTO dto : dtos) {
			System.out.printf("%S op naam van %s met rekeningnummer %d heeft saldo van %.2f ",
					dto.soort() == 'S' ? "spaarrekening" : "zichtrekening", dto.houder(), dto.rekeningnummer(),
					dto.saldo());

			if (dto.soort() == 'S')
				System.out.printf("Aangroeiintrest = %.2f%n", dto.aangroeiIntrest());
			if (dto.soort() == 'Z')
				System.out.printf("Max krediet onder nul = %.2f%n", dto.maxKredietOnderNul());
		}
	}

}
