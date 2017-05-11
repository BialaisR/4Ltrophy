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

import hei.devweb.trophy.services.PhotosService;

/* Les webs services n'ont finalement pas d'utilité dans notre projet. Nous les avons laissés car ils pourraient servir dans le
cas d'une poursuite du projet */

@Path("/photosws")
public class PhotosWS {


		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		
		@POST
		@Path("")
		public Response addPhotos(@FormParam("idPhoto") int idPhoto, @FormParam("photo") String photo, @FormParam("idAlbum") int idAlbum){
			PhotosService photosService = PhotosService.getInstance();
			try {
				photosService.addPhotos(idPhoto,photo,idAlbum);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@DELETE
		@Path("")
		public Response deletePhotos(@FormParam("idPhoto") int idPhoto, @FormParam("photo") String photo, @FormParam("idAlbum") int idAlbum){
			PhotosService photosService = PhotosService.getInstance();
			try {
				 photosService.deletePhotos(idPhoto);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listPhotos")
		public Response listPhotos(){
			PhotosService photosService = PhotosService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(photosService.listPhotos())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	

}
