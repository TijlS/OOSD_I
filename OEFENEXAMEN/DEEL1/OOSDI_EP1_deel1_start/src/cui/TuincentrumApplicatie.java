package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Plant;

public class TuincentrumApplicatie 
{
	private final DomeinController dc;
	
	private Scanner input = new Scanner(System.in);

	public TuincentrumApplicatie(DomeinController dc) {
		//TODO
	}

	public void start() 
	{
		String[] menuKeuzes = {"Toon overzicht alle planten", "Toon overzicht voorradige planten","Voeg plant toe","Geef overzicht per hoogte",  "Geef verkoopwaarde", "Stoppen"};
		int keuze = maakMenuKeuze(menuKeuzes,"Wat kies je? ");
		//TODO
			
	}
	
	private int maakMenuKeuze(String[] keuzes, String hoofding) 
	{
		//TODO
	}
	

	private void voegPlantToe()
	{
		//TODO
	}
	
	
	// Bepaal aantal planten tss 0-80cm, 80cm-1m, groter dan 1 m
	private void maakOverzichtPlantenPerHoogte()
	{
		//TODO
	}
	
	private void geefPlantenInVoorraad(boolean inVoorraad)
	{
		//TODO
		
	}
}
