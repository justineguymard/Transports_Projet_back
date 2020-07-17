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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;
import fr.inti.service.ICRoutiereService;


@Component

@Path(value="CRoutiere")

public class CRoutiereRest {
	
	//Transformation UML to JAVA
	@Autowired
	private ICRoutiereService cRoutiereService;
	
	@Path(value="liste")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<CargaisonRoutiere> getAllCRoutieres(){
		return cRoutiereService.getAllCRoutieres();
	}

	
	@Path(value="/find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CargaisonRoutiere getOne(@QueryParam("pId") int id){
		
		return cRoutiereService.getCRoutiere(id) ;
	}
	
	@Path(value="/cr")
	@POST
	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
	public CargaisonRoutiere addCRoutiere(CargaisonRoutiere cargRoutiere){
		
		return cRoutiereService.addCRoutiere(cargRoutiere);
	}
	
	
	@Path(value="/cr")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
	public CargaisonRoutiere updateEmployee(CargaisonRoutiere cargRoutiere){
		
		System.out.println(cargRoutiere.toString());
		cRoutiereService.updateCRoutiere(cargRoutiere);
		System.out.println(cargRoutiere.toString());
		
		return cargRoutiere;
	}
	
	@Path(value="/cr/{pId}")
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public Response deleteEmployee(@PathParam("pId")int idCR) {
		boolean check = cRoutiereService.deleteCRoutiere(idCR);
		
		if (check) {
			return Response.status(202).build();
		}else {
			return Response.status(418).build();
		}
		
	}
	
	
//	
//	@Path(value="/add/{pRef}")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
//	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
//	public void addMarchandise(Marchandise march,@PathVariable("pRef") String refCarg){
//		
//		cRoutiereService.addMarchandise(march, refCarg);
//	}
//	
//	@Path(value="liste/{pRef}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<Marchandise> getMarchParCarg(@PathVariable("pRef")String refCarg){
//		return cRoutiereService.getMarchParCarg(refCarg);
//	}
//	
//	@Path(value="/crAdd")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
//	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
//	public void addCRoutiere2(CargaisonRoutiere carg){
//			cRoutiereService.addCargaison(carg);
//	}
//	
	
	
}
