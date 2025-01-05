package cui;

import java.util.List;

import domein.DomeinController;
import dto.VerplaatsingDTO;

public class VerplaatsingApplicatie {
	private DomeinController dc;

	public VerplaatsingApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		List<VerplaatsingDTO> vpn = dc.geefVerplaatsingDTOs();
		int index = 0;

		for (VerplaatsingDTO vpDTO : vpn) {
			System.out.printf("verplaatsing van %s naar %s %s", vpDTO.van(), vpDTO.naar(),
					vpDTO.type() == 'A' ? "per auto"
							: (vpDTO.isBus() ? String.format("met stadsbus %d", vpDTO.lijnnr())
									: String.format("met stadstram %d", vpDTO.lijnnr())));

			System.out.printf("%nKosten voor deze verplaatsing: €%.2f%n%n", dc.geefKostenVerplaatsing(index++));
		}

		System.out.printf("Totale kosten voor deze verplaatsingen: €%.2f", dc.geefTotaleKosten());
	}
}
