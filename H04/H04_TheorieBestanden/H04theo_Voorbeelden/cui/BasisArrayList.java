package cui;

//tag::basisArrayList[]
import java.util.ArrayList;
import java.util.List;

public class BasisArrayList {
	public static void main(String[] args) {
		List<String> benodigdheden = new ArrayList<>();

		// tag::AL_methods[]
		benodigdheden.add("hamer");
		benodigdheden.add("plank");
		benodigdheden.add("nagel");
		benodigdheden.add(1, "tang");
		System.out.printf("We hebben een %d zaken nodig...", benodigdheden.size());

		if (benodigdheden.isEmpty())
			System.out.println("We hebben niets nodig...");
		else
			System.out.printf("We hebben een %d zaken nodig...", benodigdheden.size());
		String benodigdheid = benodigdheden.get(2);
		System.out.println("We hebben een " + benodigdheid + " nodig.");
		benodigdheden.set(2, "balk");
		String oud = benodigdheden.set(2, "stok");
		System.out.printf("We hebben niet langer een %s nodig. We gaan een %s gebruiken", oud, benodigdheden.get(2));
		new BasisArrayList().toonBenodigdheden(benodigdheden);
		String verwijderd = benodigdheden.remove(2);
		System.out.printf("De lijst van benodighdheden bevat niet langer %s...", verwijderd);
		if (benodigdheden.remove("tank"))
			System.out.printf("We hebben een tank verwijderd");
		if (benodigdheden.remove("tang"))
			System.out.printf("We hebben een tang verwijderd");
	}

	private void toonBenodigdheden(List<String> benodigdheden) {
		for (String b : benodigdheden) {
			System.out.println(b);
		}
	}
	// end::AL_methods[]
}
//end::basisArrayList[]
