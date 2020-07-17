package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Marchandise;

public interface IMarchandiseDao {
	
	//CRUD
	
	public List<Marchandise> getAllMarchandises();
	
	public Marchandise addMarchandise (Marchandise marchandiseIn);
	
	public Marchandise getMarchandise (int idIn);
	
	public Marchandise updateMarchandise (Marchandise marchandiseIn);
	
	public Marchandise deleteMarchandise (int idIn);
	
	
	//Autres
	
	public Marchandise assignCargaisonAerienne(Marchandise marchandiseIn, int idCarg);

	public Marchandise assignCargaisonRoutiere(Marchandise marchandiseIn, int idCarg);
	
	public List<Marchandise> getMarchByCAerienne(String refCarg); 

	public List<Marchandise> getMarchByCRoutiere(String refCarg);
	
	public List<Marchandise> getMarchByKeyword(String Keyword);

	
	
}
