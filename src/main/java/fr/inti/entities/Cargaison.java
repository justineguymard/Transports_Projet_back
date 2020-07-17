package fr.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass

public abstract class Cargaison implements Serializable{
	
	//attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_c")
	protected int id;
	protected String reference;
	protected double distanceParcours;
	@Temporal(TemporalType.DATE)
	protected Date dateLivraison;
	

	
	
	// Constructeurs
	public Cargaison() {
		super();
	}
	
	
	public Cargaison(String reference, double distanceParcours, Date dateLivraison) {
			super();
			this.reference = reference;
			this.distanceParcours = distanceParcours;
			this.dateLivraison = dateLivraison;
		}


	public Cargaison(int id, String reference, double distanceParcours, Date dateLivraison) {
		super();
		this.id = id;
		this.reference = reference;
		this.distanceParcours = distanceParcours;
		this.dateLivraison = dateLivraison;
	}


	//Getters et Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getDistanceParcours() {
		return distanceParcours;
	}
	public void setDistanceParcours(double distanceParcours) {
		this.distanceParcours = distanceParcours;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


//	@Override
//	public String toString() {
//		return "Cargaison [id=" + id + ", reference=" + reference + ", distanceParcours=" + distanceParcours
//				+ ", dateLivraison=" + dateLivraison + "]";
//	}
	
	

}
