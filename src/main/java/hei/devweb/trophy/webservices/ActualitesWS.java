package hei.devweb.trophy.webservices;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hei.devweb.trophy.services.ActualitesService;

public class ActualitesWS {

	@Path("/actualites")
	public class ContactWS {
		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		
		@POST
		@Path("")
		public Response addActualites(@FormParam("idActu") int idActu, @FormParam("titreActu") String titreActu, @FormParam("actu") String actu){
			ActualitesService actuService = ActualitesService.getInstance();
			try {
				actuService.addActualites(idActu,titreActu,actu);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@DELETE
		@Path("")
		public Response deleteContact(@FormParam("idActu") int idActu, @FormParam("titreActu") String titreActu, @FormParam("actu") String actu){
			ActualitesService actuService = ActualitesService.getInstance();
			try {
				 actuService.deleteActualites(idActu);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listActu")
		public Response listActualites(){
			ActualitesService actuService = ActualitesService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(actuService.listActualites())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}

}
