package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.ActualitesDao;
import hei.devweb.trophy.pojos.Actualites;

public class ActualitesService {
	
private ActualitesDao actualitesDao = new ActualitesDao();
	
	private static class ActualiteserviceHolder {
		private static ActualitesService instance = new ActualitesService();
	}
	
	public static ActualitesService getInstance() {
		return ActualiteserviceHolder.instance;
	}

	private ActualitesService() {
	}
	
	public List<Actualites> listActualites() {
		return actualitesDao.listActualites();
	}
	
	public void addActualites(Integer idActu, String titreActu, String actu){
		actualitesDao.addActualites(idActu,titreActu,actu);
	}
	
	public void deleteActualites(Integer idActu){
		try {
			actualitesDao.deleteActualites(idActu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
