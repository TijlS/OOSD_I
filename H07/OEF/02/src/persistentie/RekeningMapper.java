package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Rekening;
import domein.SpaarRekening;
import domein.ZichtRekening;

public class RekeningMapper {

	// sql`SELECT * FROM rekeningen`
	public List<Rekening> geefRekeningen() {
		Rekening rekening1 = new ZichtRekening(123456700082L, "Jan", -2000);
		rekening1.stortOp(1200);

		Rekening rekening2 = new SpaarRekening(123456780009L, "Sandra");
		rekening2.stortOp(5000);

		// Gaat niet werken
		Rekening rekening3 = new ZichtRekening(0L, "Stefaan", -1000);
		rekening3.haalAf(9900);

		List<Rekening> resultaat = new ArrayList<>();
		resultaat.add(rekening1);
		resultaat.add(rekening2);
		resultaat.add(rekening3);

		SpaarRekening.setAangroeiIntrest(2);

		return resultaat;
	}
}
