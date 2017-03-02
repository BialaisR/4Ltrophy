package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.UtilisateurDao;
import hei.devweb.trophy.pojos.Utilisateur;

public class UtilisateurService {

private UtilisateurDao utilisateurDao = new UtilisateurDao();
	
	private static class UtilisateurerviceHolder {
		private static UtilisateurService instance = new UtilisateurService();
	}
	
	public static UtilisateurService getInstance() {
		return UtilisateurerviceHolder.instance;
	}

	private UtilisateurService() {
	}
	
	public List<Utilisateur> listUtilisateur() {
		return utilisateurDao.listUtilisateur();
	}
	
	public void addUtilisateur(Utilisateur newUtilisateur){
		utilisateurDao.addUtilisateur(newUtilisateur);
	}
	
	public void deleteUtilisateur(String identifiant){
		try {
			utilisateurDao.deleteUtilisateur(identifiant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
