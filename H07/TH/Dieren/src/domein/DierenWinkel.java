package domein;

import java.util.ArrayList;
import java.util.List;

public class DierenWinkel 
{
	//tag::DierenWinkelAttribuut[]
	private List<Huisdier> lijstHuisdieren;
	//end::DierenWinkelAttribuut[]
	
	//tag::DierenWinkelConstructor[]
	public DierenWinkel()
	{
		lijstHuisdieren = new ArrayList<>();
	}
	//end::DierenWinkelConstructor[]
	
	//tag::DierenWinkelStelDierenVoor[]
	public String[] stelDierenVoor()
	{
		String[] voorstelling = new String[lijstHuisdieren.size()];
		int index = 0;
		for (Huisdier dier : lijstHuisdieren)
		{
			voorstelling[index] = String.format("%s zegt %s.%n", dier.toString(), dier.maakGeluid());
		//TODO : toevoegen : Hond kwispelt, Kat spint
			index++;
		}
		return voorstelling;
	}
	//end::DierenWinkelStelDierenVoor[]
	
	//tag::DierenWinkelGeefSpuitje[]
	public String geefSpuitje(Huisdier dier){
		return String.format("Awwwwww... dat doet pijn! %s", dier.maakGeluid());
	}
	//end::DierenWinkelGeefSpuitje[]
	
	//tag::DierenWinkelVoegHuisdierToe[]
	public void voegHuisdierToe (Huisdier dier)
	{
		if (dier != null)
			lijstHuisdieren.add(dier);
	}
	//end::DierenWinkelVoegHuisdierToe[]

	//tag::DierenWinkelGeefDierOpIndex[]
	public Huisdier geefDierOpIndex(int index) 
	{
		return lijstHuisdieren.get(index);
	}
	//end::DierenWinkelGeefDierOpIndex[]
	
	//tag::DierenWinkelGeefAantalDieren[]
	public int geefAantalDieren() 
	{
		return lijstHuisdieren.size();
	}
	//end::DierenWinkelGeefAantalDieren[]
}