package domein;

import java.security.SecureRandom;

//tag::KatEnkelConstructor[]
public class Kat extends Huisdier
{
	public Kat(String naam)
	{
		super(naam);
	}
	
	//end::KatEnkelConstructor[]

	//tag::KatMaakGeluid[]
	@Override
	public String maakGeluid() // deze methode bestaat al in de superklasse, maar krijgt hier een nieuwe definitie (specialisatie)
	{
		return "miauw";
	}
	//end::KatMaakGeluid[]
	
	//tag::KatLuisterNaarNaam[]
	private SecureRandom r = new SecureRandom();

	@Override
	public boolean luisterNaarNaam(String naam) // deze methode bestaat al in de superklasse, maar krijgt hier een nieuwe definitie (specialisatie)
	{
		if (r.nextInt(10) == 5)
			return super.luisterNaarNaam(naam);
		return false;
	}
	//end::KatLuisterNaarNaam[]

	//tag::KatSpin[]
	public String spin() // deze methode is nieuw tov de superklasse (uitbreiding)
	{
		return String.format("%s spint", getNaam());
	}
	//end::KatSpin[] */
}
