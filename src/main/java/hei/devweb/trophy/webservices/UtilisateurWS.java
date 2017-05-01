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

import hei.devweb.trophy.services.UtilisateurService;

@Path("/utilisateurs")
public class UtilisateurWS {


		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		
		@POST
		@Path("")
		public Response addUtilisateur(@FormParam("identifiant") String identifiant, @FormParam("motDePasse") String motDePasse, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail,
				@FormParam("nbMessagesForum") Integer nbMessagesForum, @FormParam("dateInscription") String dateInscription, @FormParam("participant") Boolean participant, @FormParam("photo") String photo, @FormParam("classe") String classe,
				@FormParam("admin") Boolean admin){
			UtilisateurService userService = UtilisateurService.getInstance();
			try {
				userService.addUtilisateur(identifiant, motDePasse, nom, prenom, mail,
						nbMessagesForum, dateInscription, participant,photo,classe,
						admin);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@DELETE
		@Path("")
		public Response deleteUtilisateur(@FormParam("identifiant") String identifiant, @FormParam("motDePasse") String motDePasse, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("mail") String mail,
				@FormParam("nbMessagesForum") Integer nbMessagesForum, @FormParam("dateInscription") String dateInscription, @FormParam("participant") Boolean participant, @FormParam("photo") String photo, @FormParam("classe") String classe,
				@FormParam("admin") Boolean admin){
			UtilisateurService userService = UtilisateurService.getInstance();
			try {
				 userService.deleteUtilisateur(identifiant);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listUtilisateur")
		public Response listUtilisateur(){
			UtilisateurService userService = UtilisateurService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(userService.listUtilisateur())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	

}
