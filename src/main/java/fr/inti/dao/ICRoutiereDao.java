package fr.inti.dao;

import java.util.List;

import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;

public interface ICRoutiereDao {
	
	public List<CargaisonRoutiere> getAllCRoutieres();
	
	public CargaisonRoutiere addCRoutiere (CargaisonRoutiere CRoutiereIn);
	
	public CargaisonRoutiere getCRoutiere(int idIn);
	
	public CargaisonRoutiere updateCRoutiere (CargaisonRoutiere CRoutiereIn);
	
	public CargaisonRoutiere deleteCRoutiere (int idIn);
	
	// 
	
	

}
