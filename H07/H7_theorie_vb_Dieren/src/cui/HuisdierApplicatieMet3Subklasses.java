package cui;

import domein.Duif;
import domein.Hond;
import domein.Huisdier;
import domein.Kat;

public class HuisdierApplicatieMet3Subklasses 
{
	public static void main(String[] args) 
	{
		HuisdierApplicatieMet3Subklasses app = new HuisdierApplicatieMet3Subklasses();
		app.doeIetsMetHuisdieren();
	}	
		
	private void doeIetsMetHuisdieren()
	{
		Huisdier hd = new Huisdier("Nijntje");
		Kat k = new Kat("Musti");
		Hond h = new Hond("Rintje");
		Duif d = new Duif("Wittekop", 20201234567L); // <.>
		
		System.out.println("Dit zijn de huisdieren:");
		System.out.println(hd);
		System.out.println(k);
		System.out.println(h);
		System.out.println(d); 	// <.>
		System.out.println();
	}
}
