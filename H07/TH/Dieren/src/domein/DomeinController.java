package domein;

import java.security.SecureRandom;

public class DomeinController 
{
	private DierenWinkel winkel;
	private SecureRandom random;
	
	public DomeinController() // <.>
	{
		winkel = new DierenWinkel();
		random = new SecureRandom();
	}

	public void initialiseerDierenWinkel() // <.>
	{
		Duif duif1 = new Duif("Blauwe geschelpte", 20180000001L); 
		winkel.voegHuisdierToe(duif1);
		Kat kat1 = new Kat("Minoe");
		winkel.voegHuisdierToe(kat1);
		Hond hond1 = new Hond("Rex");
		winkel.voegHuisdierToe(hond1);
		Hond hond2 = new Hond("Lassie");
		winkel.voegHuisdierToe(hond2);
		Duif duif2 = new Duif("Witoog", 20199876543L);
		winkel.voegHuisdierToe(duif2);
		Kat kat2 = new Kat("Garfield");
		winkel.voegHuisdierToe(kat2);
	}
	
	public String[] stelDierenVoor() // <.>
	{
		return winkel.stelDierenVoor();
	}

	public String geefSpuitjes() // <.>
	{
		String uitvoer = "";
		int aantalDieren, randomIndex;
		Huisdier patient;
		for (int i=0; i<3; i++)
		{
			aantalDieren = winkel.geefAantalDieren();
			randomIndex = random.nextInt(aantalDieren);
			patient = winkel.geefDierOpIndex(randomIndex);
			uitvoer += String.format("%s%n", winkel.geefSpuitje(patient));
		}
		return uitvoer;
	}
}
