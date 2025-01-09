package domein;

import java.util.List;

import persistentie.PlantMapper;

public class Tuincentrum 
{
	private List<Plant> planten;
	private final PlantMapper plantMapper;

	public Tuincentrum() 
	{
		plantMapper = new PlantMapper();
		this.planten = plantMapper.geefPlanten();
	}

	public void voegPlantToe(Plant plant) 
	{ 
		//TODO	
	}

	public List<Plant> getPlanten() {
		return planten;
	}

	//TODO maakOverzichtPlantenPerHoogte 
	
	

	public double bepaalWaardeVerkoop() {
		//TODO
	}

	//TODO geefPlanten
	
	
	

}
