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
	
	public void addUtilisateur(Integer idUser, String nom, String prenom, String mail,
			String photo, String classe, String identif){
		utilisateurDao.addUtilisateur(idUser,nom, prenom, mail,
				photo,classe,identif);
	}
	
	public void deleteUtilisateur(Integer idUser){
		try {
			utilisateurDao.deleteUtilisateur(idUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
