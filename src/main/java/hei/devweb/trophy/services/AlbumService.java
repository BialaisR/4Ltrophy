package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.AlbumDao;
import hei.devweb.trophy.pojos.Album;

/* Classe définissant les méthodes disponibles pour chaque album 
 * Cette classe n'intervient finalement pas sur notre projet mais
 * nous l'avons conservée car elle pourra être utile par la suite
 */


public class AlbumService {
	
private AlbumDao albumDao = new AlbumDao();
	
	private static class AlbumerviceHolder {
		private static AlbumService instance = new AlbumService();
	}
	
	public static AlbumService getInstance() {
		return AlbumerviceHolder.instance;
	}

	private AlbumService() {
	}
	
	/* méthode de listage */
	
	public List<Album> listAlbum() {  
		return albumDao.listAlbum();
	}
	
	/* méthode d'ajout */
	
	public void addAlbum(Integer idAlbum, String nomAlbum){
		albumDao.addAlbum(idAlbum,nomAlbum);
	}
	
	/* méthode de suppression */
	
	public void deleteAlbum(Integer idAlbum){
		try {
			albumDao.deleteAlbum(idAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
