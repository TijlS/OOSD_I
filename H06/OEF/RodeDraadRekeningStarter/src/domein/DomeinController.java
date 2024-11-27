package domein;

import java.math.BigDecimal;
import java.util.List;

import dto.RekeningDTO;

public class DomeinController {
	private Bank miniBank = new Bank();

	public void voegRekeningToe(long rekeningNummer, String houder) {
		Rekening rekening = new Rekening(rekeningNummer, houder);
		miniBank.voegRekeningToe(rekening);
	}

	public void voegRekeningToe(long rekeningNummer, String houder, BigDecimal saldo) {
		Rekening rekening = new Rekening(rekeningNummer, houder, saldo);
		miniBank.voegRekeningToe(rekening);
	}

	public RekeningDTO[] geefRekeningen() {
		List<Rekening> rekeningen = this.miniBank.getRekeningen();

		RekeningDTO[] rekeningDTOs = new RekeningDTO[rekeningen.size()];

		for (int i = 0; i < rekeningDTOs.length; i++) {
			rekeningDTOs[i] = new RekeningDTO(rekeningen.get(i).getRekeningnummer(), rekeningen.get(i).getHouder(),
					rekeningen.get(i).getSaldo());
		}

		return rekeningDTOs;
	}

	public void stort(int indexVanRekening, BigDecimal bedrag) {
		miniBank.stort(indexVanRekening, bedrag);
	}

	public void haalAf(int indexVanRekening, BigDecimal bedrag) {
		miniBank.haalAf(indexVanRekening, bedrag);
	}

	public void schrijfOver(int indexVanRekening, int indexNaarRekening, BigDecimal bedrag) {
		miniBank.schrijfOver(indexVanRekening, indexNaarRekening, bedrag);
	}

}
