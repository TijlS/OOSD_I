package domein.zonderOvererving;

//tag::HondZonderPackage[]
public class Hond
{
	private String naam;

	public Hond(String naam)
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
		return "waf waf";
	}
	public boolean luisterNaarNaam(String naam)
	{
		return naam.equals(this.naam);
	}
	public String kwispel()
	{
		return "kwispel-kwispel-kwispel";
	}
	public String toString() // <.>
	{
		return String.format("%s met naam %s", this.getClass().getSimpleName(), naam);
	}
}
//end::HondZonderPackage[]