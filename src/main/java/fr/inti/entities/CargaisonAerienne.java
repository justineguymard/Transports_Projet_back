package fr.inti.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SuppressWarnings("serial")
@Entity
@Table(name="cargaisonsaeriennes")
@XmlRootElement
public class CargaisonAerienne extends Cargaison {
	
	private double poidsMaximum;
	
	//association UML to JAVA
	@OneToMany(mappedBy="cargaisonAerienne", fetch=FetchType.EAGER)
	@Autowired
	private List <Marchandise> listeMarchandisesA;


	public CargaisonAerienne() {
		super();
	}

	public CargaisonAerienne(String reference, double distanceParcours, Date dateLivraison, double poidsMaximum) {
		super(reference, distanceParcours, dateLivraison);
		this.poidsMaximum = poidsMaximum;
	}

	public CargaisonAerienne(int id, String reference, double distanceParcours, Date dateLivraison,
			double poidsMaximum) {
		super(id, reference, distanceParcours, dateLivraison);
		this.poidsMaximum = poidsMaximum;
	}

	public double getPoidsMaximum() {
		return poidsMaximum;
	}
	
	@JsonIgnoreProperties({"cargaisonAerienne"})
	public List<Marchandise> getListeMarchandisesA() {
		return listeMarchandisesA;
	}

	public void setListeMarchandisesA(List<Marchandise> listeMarchandisesA) {
		this.listeMarchandisesA = listeMarchandisesA;
	}

	public void setPoidsMaximum(double poidsMaximum) {
		this.poidsMaximum = poidsMaximum;
	}

	@Override
	public String toString() {
		return "CargaisonAerienne [ dateLivraison=" + dateLivraison +", id=" + id + ", reference=" + reference
				+ ", distanceParcours=" + distanceParcours + ",  poidsMaximum=" + poidsMaximum +"]";
	}
	
	

}
