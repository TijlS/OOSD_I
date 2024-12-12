package cui;

import java.security.SecureRandom;

import domein.Hond;
import domein.Huisdier;
import domein.Kat;
import domein.Kip;

public class HuisdierApplicatieMetOvererving {
	public static void main(String[] args) {
		HuisdierApplicatieMetOvererving app = new HuisdierApplicatieMetOvererving();
//		app.doeIetsMetHuisdieren();

		app.speelMetHuisdieren();
	}

	private void speelMetHuisdieren() {
		SecureRandom sr = new SecureRandom();
		Object mijnKippetje;

		if (sr.nextBoolean())
			mijnKippetje = new Kip();
		else
			mijnKippetje = new Object();

		System.out.printf("mijKippetje.toString() geeft: %s%n", mijnKippetje.toString());

		if (mijnKippetje instanceof Kip k) {
			System.out.println(k.kakel(3));
			System.out.print(((Kip) mijnKippetje).kakel(6));
		}

	}

	private void doeIetsMetHuisdieren() {
		// <.>
		Huisdier hd = new Huisdier("Nijntje");
		Kat k = new Kat("Musti");
		Hond h = new Hond("Rintje");

		// <.>
		System.out.println("Dit zijn de huisdieren:");
		System.out.println(hd); // toString
		System.out.println(k);
		System.out.println(h);
		System.out.println();

		// <.>
		System.out.println("Ze kunnen ook allemaal een soort van geluid maken...");
		System.out.printf("%s maakt geluid %s%n", hd.getNaam(), hd.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", k.getNaam(), k.maakGeluid());
		System.out.printf("%s maakt geluid %s%n", h.getNaam(), h.maakGeluid());
		System.out.println();

		System.out.println("En de kat en de hond kunnen tenslotte nog iets bijzonders:");
		System.out.printf("Het bijzondere wat een %s kan, is %s%n", k.getClass().getSimpleName(), k.spin());
		System.out.printf("Het bijzondere wat een %s kan, is %s%n", h.getClass().getSimpleName(), h.kwispel());

	}
}
