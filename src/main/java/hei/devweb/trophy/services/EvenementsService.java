package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.EvenementsDao;
import hei.devweb.trophy.pojos.Evenements;

public class EvenementsService {
	
private EvenementsDao evenementsDao = new EvenementsDao();
	
	private static class EvenementserviceHolder {
		private static EvenementsService instance = new EvenementsService();
	}
	
	public static EvenementsService getInstance() {
		return EvenementserviceHolder.instance;
	}

	private EvenementsService() {
	}
	
	public List<Evenements> listEvenements() {
		return evenementsDao.listEvenements();
	}
	
	public void addEvenements(Integer idEvent, String dateEvent, String event){
		evenementsDao.addEvenements(idEvent, dateEvent, event);
	}
	
	public void deleteEvenements(Integer idEvent){
		try {
			evenementsDao.deleteEvenements(idEvent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
