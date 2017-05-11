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

import hei.devweb.trophy.services.EvenementsService;

/* Les webs services n'ont finalement pas d'utilité dans notre projet. Nous les avons laissés car ils pourraient servir dans le
cas d'une poursuite du projet */

@Path("/evenements")
public class EvenementsWS {


		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		
		@POST
		@Path("")
		public Response addEvenements(@FormParam("idEvent") int idEvent, @FormParam("dateEvent") String dateEvent, @FormParam("event") String event){
			EvenementsService eventService = EvenementsService.getInstance();
			try {
				eventService.addEvenements(idEvent, dateEvent, event);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@DELETE
		@Path("")
		public Response deleteEvenements(@FormParam("idEvent") int idEvent, @FormParam("dateEvent") String dateEvent, @FormParam("event") String event){
			EvenementsService eventService = EvenementsService.getInstance();
			try {
				 eventService.deleteEvenements(idEvent);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listEvenements")
		public Response listEvenements(){
			EvenementsService eventService = EvenementsService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(eventService.listEvenements())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	

}
