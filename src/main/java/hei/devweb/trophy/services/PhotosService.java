package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.PhotosDao;
import hei.devweb.trophy.pojos.Photos;

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
	
	public List<Photos> listPhotos() {
		return photosDao.listPhotos();
	}
	
	public void addPhotos(Photos newPhotos){
		photosDao.addPhotos(newPhotos);
	}
	
	public void deletePhotos(Integer idPhotos){
		try {
			photosDao.deletePhotos(idPhotos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
