package fr.inti.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SuppressWarnings("serial")
@Entity
@Table(name = "cargaisonsRoutieres")
@XmlRootElement
public class CargaisonRoutiere extends Cargaison {

	// attributs
	private double temperature;

	// //transformation de l'association uml en Java
	@OneToMany(mappedBy = "cargaisonRoutiere", fetch=FetchType.EAGER)
	@Autowired
	private List<Marchandise> listeMarchandisesR;
	
	
	//constructeurs
	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String reference, double distanceParcours, Date dateLivraison, double temperature) {
		super(reference, distanceParcours, dateLivraison);
		this.temperature = temperature;
	}

	public CargaisonRoutiere(int id, String reference, double distanceParcours, Date dateLivraison,
			double temperature) {
		super(id, reference, distanceParcours, dateLivraison);
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}
	
	@JsonIgnoreProperties({"cargaisonRoutiere"})
	public List<Marchandise> getListeMarchandisesR() {
		return listeMarchandisesR;
	}

	public void setListeMarchandisesR(List<Marchandise> listeMarchandisesR) {
		this.listeMarchandisesR = listeMarchandisesR;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "CargaisonRoutiere [dateLivraison=" + dateLivraison + ", id=" + id + ", reference=" + reference
				+ ", distanceParcours=" + distanceParcours + ", temperature=" + temperature + "]";
	}

}
