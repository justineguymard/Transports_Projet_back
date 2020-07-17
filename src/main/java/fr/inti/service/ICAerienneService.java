package fr.inti.service;

import java.util.List;

import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.Marchandise;

public interface ICAerienneService {
	
	public List<CargaisonAerienne> getAllCAeriennes();
	
	public CargaisonAerienne addCAerienne (CargaisonAerienne CAerienneIn);
	
	public CargaisonAerienne getCAerienne(int idIn);
	
	public CargaisonAerienne updateCAerienne (CargaisonAerienne CAerienneIn);
	
	public boolean deleteCAerienne (int idIn);
	
	// autres méthodes demandées
	
//	public void addMarchandise(Marchandise march, String refCarg);
//	
//	public List<Marchandise> getMarchParCarg(String refCarg);
//	
//	public void addCargaison (CargaisonAerienne carg);

}
