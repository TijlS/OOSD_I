package domein;

import java.util.ArrayList;
import java.util.List;

import dto.PersonageDTO;

public class DomeinController {
	private CategorieRepository categorieRepo;
	private PersonageRepository personageRepo;
	private Categorie huidigeCategorie;
	private Personage huidigPersonage;

	public DomeinController() {
		categorieRepo = new CategorieRepository();
		personageRepo = new PersonageRepository();
	}

	public void maakCategorie(String omschrijving, int snelheid, int kracht, int lenigheid) {
		categorieRepo.voegToe(new Categorie(omschrijving, snelheid, kracht, lenigheid));
	}

	public PersonageDTO geefDetailsPersonage() {
		if (huidigPersonage == null)
			return null; // exception werpen

		Categorie personageCat = huidigPersonage.getCategorie();

		return new PersonageDTO(huidigPersonage.getNaam(), personageCat.getOmschrijving(), personageCat.getKracht(),
				personageCat.getSnelheid(), personageCat.getLenigheid());

	}

	public List<PersonageDTO> geefPersonages() {
		List<Personage> personagesLijst = personageRepo.getPersonages();

		List<PersonageDTO> personages = new ArrayList<>();

		for (Personage p : personagesLijst) {
			Categorie personageCat = p.getCategorie();
			PersonageDTO personageDTO = new PersonageDTO(p.getNaam(), personageCat.getOmschrijving());

			personages.add(personageDTO);
		}

		return personages;
	}

	public void selecteerPersonage(String naam) {
		huidigPersonage = personageRepo.geefPersonage(naam);
	}

	public List<String> geefCategorieen() {
		List<String> categorieen = new ArrayList<>();

		for (Categorie c : categorieRepo.getCategorieen())
			categorieen.add(c.getOmschrijving());

		return categorieen;
	}

	public void selecteerCategorie(String omschrijving) {
		huidigeCategorie = categorieRepo.geefCategorie(omschrijving);
	}

	public void registreerPersonage(String naam) {
		if (huidigeCategorie != null) {
			Personage personage = new Personage(naam, huidigeCategorie);
			boolean toegevoegd = personageRepo.voegToe(personage);
			if (toegevoegd)
				huidigPersonage = personage;
		}
	}

}
