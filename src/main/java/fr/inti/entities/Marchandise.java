package fr.inti.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@SuppressWarnings("serial")
@Entity
@Table(name="marchandises")
@XmlRootElement
//@JsonIgnoreProperties({"listeMarchandisesA","listeMarchandisesR"})
public class Marchandise implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_m")
	private int id;
	private long numero;
	private double poids;
	private double volume;
	private String nom;

	//asociation UML en JAVA
	@ManyToOne
	@JoinColumn(name="CAerienne_id", referencedColumnName="id_c")
	private CargaisonAerienne cargaisonAerienne;
	
	@ManyToOne
	@JoinColumn(name="CRoutiere_id", referencedColumnName="id_c")
	private CargaisonRoutiere cargaisonRoutiere;
//	
	
	//Constructeur 
	public Marchandise() {
		super();
	}

	
	public Marchandise(long numero, double poids, double volume, String nom) {
	super();
	this.numero = numero;
	this.poids = poids;
	this.volume = volume;
	this.nom = nom;
}


	public Marchandise(int id, long numero, double poids, double volume, String nom) {
		super();
		this.id = id;
		this.numero = numero;
		this.poids = poids;
		this.volume = volume;
		this.nom=nom;
	}


	//Getters et Setters 
	//@XmlTransient
	@JsonIgnoreProperties({"listeMarchandisesA"})
	public CargaisonAerienne getCargaisonAerienne() {
		return cargaisonAerienne;
	}
	public void setCargaisonAerienne(CargaisonAerienne cargaisonAerienne) {
		this.cargaisonAerienne = cargaisonAerienne;
	}
	//@XmlTransient
	@JsonIgnoreProperties({"listeMarchandisesR"})
	public CargaisonRoutiere getCargaisonRoutiere() {
		return cargaisonRoutiere;
	}
	public void setCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere) {
		this.cargaisonRoutiere = cargaisonRoutiere;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Marchandise [id=" + id + ", numero=" + numero + ", poids=" + poids + ", volume=" + volume + ", nom="
				+ nom + "]";
	}



	
	
	
}
