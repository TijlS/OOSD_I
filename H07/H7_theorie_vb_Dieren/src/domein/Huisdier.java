package domein;

//tag::HuisdierZonderMaakGeluid[]
public class Huisdier extends Object // <.>
{
	private String naam;
	
	public Huisdier(String naam) // <.>
	{
		setNaam(naam); // <.>
	}
	public String getNaam() 
	{
		return naam;
	}
	public final void setNaam(String naam) // <.>
	{
		this.naam = naam;
	}
	public boolean luisterNaarNaam(String naam) // <.>
	{
		return (naam.equals(this.naam));
	}
	public String toString() // <.>
	{
		return String.format("%s met naam %s", this.getClass().getSimpleName(), naam);
	}
	//end::HuisdierZonderMaakGeluid[]
	
	//tag::HuisdierMaakGeluid[]
	public String maakGeluid()
	{
		return "!";
	}
	//end::HuisdierMaakGeluid[]
}
