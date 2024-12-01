package cui;

import domein.DomeinController;

public class HuisdierApplicatieMetPolymorfisme 
{
	public static void main(String[] args) 
	{
		HuisdierApplicatieMetPolymorfisme app = new HuisdierApplicatieMetPolymorfisme();
		app.doeIetsMetHuisdieren();
	}
	
	private void doeIetsMetHuisdieren()
	{
		// <.>
		DomeinController dc = new DomeinController();
		
		// <.>
		dc.initialiseerDierenWinkel();
		
		// <.>
		String[] overzicht = dc.stelDierenVoor();
		
		for (String eenDier : overzicht)
			System.out.println(eenDier);
		System.out.println();
		
		// <.>
		System.out.println(dc.geefSpuitjes());
	}
}
