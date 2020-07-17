package fr.inti.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.inti.entities.Cargaison;
import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.CargaisonRoutiere;
import fr.inti.service.ICAerienneService;
import fr.inti.service.ICRoutiereService;

@Component

@Path(value = "carg")
public class CargaisonRest {

	// Transformation UML to JAVA
	@Autowired
	private ICAerienneService cAerienneService;

	// Transformation UML to JAVA
	@Autowired
	private ICRoutiereService cRoutiereService;

	@Path(value = "liste")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List <Cargaison> getAllCargaisons() {
		
		List <CargaisonAerienne> LCA = cAerienneService.getAllCAeriennes();
		List <CargaisonRoutiere> LCR = cRoutiereService.getAllCRoutieres();
		
		List <Cargaison> listeCarg = Stream.concat(LCA.stream(), LCR.stream()).collect(Collectors.toList());
		listeCarg.stream().forEach(System.out::println);

		return listeCarg;
	}

}
