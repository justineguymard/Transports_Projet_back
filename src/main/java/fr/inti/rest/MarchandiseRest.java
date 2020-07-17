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
import org.springframework.web.bind.annotation.RequestParam;

import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;
import fr.inti.service.IMarchandiseService;

@Component
@Path(value="marchandise")
public class MarchandiseRest {
	
	//Transformation UML to JAVA
	@Autowired
	private IMarchandiseService marchandiseService;
	
	@Path(value="liste")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Marchandise> getAllMarchandises(){
		return marchandiseService.getAllMarchandises();
	}
	
	@Path(value="/find")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Marchandise getOne(@QueryParam("pId") int idIn){
		
		return marchandiseService.getMarchandise(idIn) ;
	}
	
	@Path(value="/mc")
	@POST
	@Produces(MediaType.APPLICATION_JSON) //pour le format en sortie
	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
	public Marchandise addMarchandise(Marchandise marchandiseIn){
		
		return marchandiseService.addMarchandise(marchandiseIn);
	}
	
	
	@Path(value="/mc")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) //pour le format en entrée
	public Marchandise updateMarchandise(Marchandise marchandiseIn){
		
		System.out.println(marchandiseIn.toString());
		marchandiseService.updateMarchandise(marchandiseIn);
		System.out.println(marchandiseIn.toString());
		
		return marchandiseIn;
	}
	
	@Path(value="/mc/{pId}")
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public Response deleteMarchandise(@PathParam("pId")int idMC) {
		boolean check = marchandiseService.deleteMarchandise(idMC);
		
		if (check) {
			return Response.status(202).build();
		}else {
			return Response.status(418).build();
		}
		
	}
	
	@PUT
	@Path("/addCA/{pId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void AssignCargaisonAerienne(Marchandise marchandiseIn,@PathParam("pId") int idCarg) {
		marchandiseService.assignCargaisonAerienne(marchandiseIn, idCarg);
	}

	@PUT
	@Path("/addCR/{pId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void AssignCargaisonRoutiere(Marchandise marchandiseIn,@PathParam("pId")int idCarg) {
		marchandiseService.assignCargaisonRoutiere(marchandiseIn, idCarg);
	}

	@GET
	@Path("/ca")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchByCAerienne(@QueryParam("pRef")String refCarg) {
		return marchandiseService.getMarchByCAerienne(refCarg);
	}
	
	@GET
	@Path("/cr")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchByCRoutiere(@QueryParam("pRef")String refCarg) {
		return marchandiseService.getMarchByCRoutiere(refCarg);
	}
	
	@GET
	@Path("/mc/{kw}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchByKeyword(@PathParam("kw")String keyword) {
		return marchandiseService.getMarchByKeyword(keyword);
	}
	
	
	
	
	
	
	
	
	
	
}
