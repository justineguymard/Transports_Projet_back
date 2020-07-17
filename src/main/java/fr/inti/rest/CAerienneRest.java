package fr.inti.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.inti.entities.CargaisonAerienne;

import fr.inti.service.ICAerienneService;

@Component

@Path(value = "CAerienne")
public class CAerienneRest {

	// Transformation UML to JAVA
	@Autowired
	private ICAerienneService cAerienneService;

	@Path(value = "liste")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<CargaisonAerienne> getAllCAeriennes() {
		return cAerienneService.getAllCAeriennes();
	}
	
	//test: /ProblemeWS/rest/CAerienne/find?pId=1
	@Path(value = "/find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CargaisonAerienne getOne(@QueryParam("pId") int id) {

		return cAerienneService.getCAerienne(id);
	}

	
	@Path(value = "/ca")
	@POST
	@Produces(MediaType.APPLICATION_JSON) // pour le format en sortie
	@Consumes(MediaType.APPLICATION_JSON) // pour le format en entrée
	public CargaisonAerienne addCAerienne(CargaisonAerienne cargAerienne) {

		return cAerienneService.addCAerienne(cargAerienne);
	}

	@Path(value = "/ca")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // pour le format en entrée
	public CargaisonAerienne updateEmployee(CargaisonAerienne cargAerienne) {

		System.out.println(cargAerienne.toString());
		cAerienneService.updateCAerienne(cargAerienne);
		System.out.println(cargAerienne.toString());

		return cargAerienne;
	}

	@Path(value="/ca/{pId}")
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public Response deleteEmployee(@PathParam("pId") int idCR) {
		boolean check = cAerienneService.deleteCAerienne(idCR);

		if (check) {
			return Response.status(202).build();
		} else {
			return Response.status(418).build();
		}

	}
	
//	@Path(value="/add/{pRef}")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
//	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
//	public void addMarchandise(Marchandise march,@PathVariable("pRef") String refCarg){
//		
//		cAerienneService.addMarchandise(march, refCarg);
//	}
//	
//	@Path(value="liste/{pRef}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<Marchandise> getMarchParCarg(@PathVariable("pRef")String refCarg){
//		return cAerienneService.getMarchParCarg(refCarg);
//	}
//	
//	@Path(value="/crAdd")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
//	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
//	public void addCAerienne2(CargaisonAerienne carg){
//			cAerienneService.addCargaison(carg);
//	}

}
