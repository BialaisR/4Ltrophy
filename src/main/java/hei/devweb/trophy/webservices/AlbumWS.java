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

import hei.devweb.trophy.services.AlbumService;

/* Les webs services n'ont finalement pas d'utilité dans notre projet. Nous les avons laissés car ils pourraient servir dans le
cas d'une poursuite du projet */

@Path("/album")
public class AlbumWS {


		
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		
		@POST
		@Path("")
		public Response addAlbum(@FormParam("idAlbum") int idAlbum, @FormParam("nomAlbum") String nomAlbum){
			AlbumService albumService = AlbumService.getInstance();
			try {
				albumService.addAlbum(idAlbum,nomAlbum);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		@DELETE
		@Path("")
		public Response deleteAlbum(@FormParam("idAlbum") int idAlbum, @FormParam("nomAlbum") String nomAlbum){
			AlbumService albumService = AlbumService.getInstance();
			try {
				 albumService.deleteAlbum(idAlbum);
				return Response.status(200).entity(gson.toJson("")).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@GET
		@Path("/listAlbum")
		public Response listAlbum(){
			AlbumService albumService = AlbumService.getInstance();
			try {
				return Response.status(200).entity(gson.toJson(albumService.listAlbum())).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	

}
