package fr.inti.service;

import java.util.List;

import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;

public interface ICRoutiereService {
	
	public List<CargaisonRoutiere> getAllCRoutieres();
	
	public CargaisonRoutiere addCRoutiere (CargaisonRoutiere CRoutiereIn);
	
	public CargaisonRoutiere getCRoutiere(int idIn);
	
	public CargaisonRoutiere updateCRoutiere (CargaisonRoutiere CRoutiereIn);
	
	public boolean deleteCRoutiere (int idIn);
	
	//autres 
	
//	public void addMarchandise(Marchandise march, String refCarg);
//	
//	public List<Marchandise> getMarchParCarg(String refCarg);
//	
//	public void addCargaison (CargaisonRoutiere carg);
	

}
