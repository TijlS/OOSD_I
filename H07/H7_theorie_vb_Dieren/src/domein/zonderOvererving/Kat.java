package domein.zonderOvererving;

//tag::KatZonderPackage[]
public class Kat
{
	private String naam;

	public Kat(String naam)	
	{
		setNaam(naam);
	}
	public String getNaam() 
	{
		return naam;
	}
	public final void setNaam(String naam) 
	{
		this.naam = naam;
	}
	public String maakGeluid() 
	{
		return "miauw";
	}
	public boolean luisterNaarNaam(String naam)
	{
		return naam.equals(this.naam);
	}
	public String spin()
	{
		return naam + " spint";
	}
	public String toString() // <.>
	{
		return String.format("%s met naam %s", this.getClass().getSimpleName(), naam);
	}
}
//end::KatZonderPackage[]