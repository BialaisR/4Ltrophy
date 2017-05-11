package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.PhotosDao;
import hei.devweb.trophy.pojos.Photos;

/* Classe définissant les méthodes disponibles pour chaque photo */ 

public class PhotosService {
	
private PhotosDao photosDao = new PhotosDao();
	
	private static class PhotoserviceHolder {
		private static PhotosService instance = new PhotosService();
	}
	
	public static PhotosService getInstance() {
		return PhotoserviceHolder.instance;
	}

	private PhotosService() {
	}
	
	/* méthode de listage */
	
	public List<Photos> listPhotos() {
		return photosDao.listPhotos();
	}
	
	/* méthode d'ajout */
	
	public void addPhotos(Integer idPhoto, String photo, int idAlbum){
		photosDao.addPhotos(idPhoto,photo,idAlbum);
	}
	
	/* méthode de suppression */
	
	public void deletePhotos(Integer idPhotos){
		try {
			photosDao.deletePhotos(idPhotos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
