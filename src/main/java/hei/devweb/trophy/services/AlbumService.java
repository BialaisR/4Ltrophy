package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.AlbumDao;
import hei.devweb.trophy.pojos.Album;

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
	
	public List<Album> listAlbum() {
		return albumDao.listAlbum();
	}
	
	public void addAlbum(int idAlbum, String nomAlbum){
		albumDao.addAlbum(idAlbum,nomAlbum);
	}
	
	public void deleteAlbum(Integer idAlbum){
		try {
			albumDao.deleteAlbum(idAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
