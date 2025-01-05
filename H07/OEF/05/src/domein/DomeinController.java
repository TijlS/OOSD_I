package domein;

import java.util.ArrayList;
import java.util.List;

import dto.VerplaatsingDTO;

public class DomeinController {
	private final VerplaatsingRepository verplaatsRepo;

	public DomeinController() {
		verplaatsRepo = new VerplaatsingRepository();
	}

	public List<VerplaatsingDTO> geefVerplaatsingDTOs() {
		List<VerplaatsingDTO> lijst = new ArrayList<>();
		Verplaatsing[] vpn = verplaatsRepo.getVpn();

		for (Verplaatsing verplaatsing : vpn) {
			if (verplaatsing instanceof VerplaatsingPerAuto va) {
				lijst.add(new VerplaatsingDTO(va.getVan(), va.getNaar(), 0, false, 'A'));
			} else if (verplaatsing instanceof VerplaatsingPerBusTram v) {
				lijst.add(new VerplaatsingDTO(v.getVan(), v.getNaar(), v.getLijnnr(), v.isBus(), 'B'));
			}
		}

		return lijst;
	}

	public double geefKostenVerplaatsing(int index) {
		return verplaatsRepo.geefKostenVerplaatsing(index);
	}

	public double geefTotaleKosten() {
		return verplaatsRepo.geefTotaleKosten();
	}
}
