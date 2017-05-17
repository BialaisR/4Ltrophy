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

import hei.devweb.trophy.services.EquipagesService;

/* Les webs services n'ont finalement pas d'utilité dans notre projet. Nous les avons laissés car ils pourraient servir dans le
cas d'une poursuite du projet */

@Path("/equipagesws")
public class EquipagesWS {


		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		/* mis en commentaire car besoin de modifier les parametres
		@POST
		@Path("")
		public Response addEquipages(@FormParam("numeroEquipage") int numeroEquipage, @FormParam("nomEquipage") String nomEquipage,  @FormParam("identifParticipant") String identifParticipant1,  @FormParam("identifParticipant2") String identifParticipant2 , @FormParam("descriptionEquipage") String descriptionEquipage, @FormParam("photoEquipage") String photoEquipage){
			EquipagesService equipageService = EquipagesService.getInstance();
			try {
				equipageService.addEquipages(numeroEquipage, nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1, mail2, classe1, classe2, photo1, photo2, photoEquipage);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		*/
		
		@DELETE
		@Path("")
		public Response deleteEquipages(@FormParam("numeroEquipage") int numeroEquipage, @FormParam("nomEquipage") String nomEquipage,  @FormParam("identifParticipant") String identifParticipant1,  @FormParam("identifParticipant2") String identifParticipant2 , @FormParam("descriptionEquipage") String descriptionEquipage, @FormParam("photoEquipage") String photoEquipage){
			EquipagesService equipageService = EquipagesService.getInstance();
			try {
				 equipageService.deleteEquipages(numeroEquipage);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listEquipages")
		public Response listEquipages(){
			EquipagesService equipageService = EquipagesService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(equipageService.listEquipages())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	

}
