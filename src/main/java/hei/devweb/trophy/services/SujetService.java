package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.SujetDao;
import hei.devweb.trophy.pojos.Sujet;

/* Classe définissant les méthodes disponibles pour chaque sujet */

public class SujetService {
	
	private SujetDao sujetDao = new SujetDao();
	
	private static class SujeterviceHolder {
		private static SujetService instance = new SujetService();
	}
	
	public static SujetService getInstance() {
		return SujeterviceHolder.instance;
	}

	private SujetService() {
	}
	
	/* méthode de listage */
	
	public List<Sujet> listSujet() {
		return sujetDao.listSujet();
	}
	
	/* méthode d'ajout */
	
	public void addSujet(Integer idSujet, String nomSujet, String identifiantCreateur, String dateLastPost,
			Integer nbMessage, String identifiantLastPost){
		sujetDao.addSujet(idSujet, nomSujet, identifiantCreateur, dateLastPost,
				nbMessage, identifiantLastPost);
	}
	
	/* méthode de suppression */
	
	public void deleteSujet(Integer idSujet){
		try {
			sujetDao.deleteSujet(idSujet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
