package fr.inti.dao;


import java.util.List;


import fr.inti.entities.CargaisonAerienne;


public interface ICAerienneDao {
	
	public List<CargaisonAerienne> getAllCAeriennes();
	
	public CargaisonAerienne addCAerienne (CargaisonAerienne CAerienneIn);
	
	public CargaisonAerienne getCAerienne(int idIn);
	
	public CargaisonAerienne updateCAerienne (CargaisonAerienne CAerienneIn);
	
	public CargaisonAerienne deleteCAerienne (int idIn);
	
	
	// autres méthodes demandées

	
}
