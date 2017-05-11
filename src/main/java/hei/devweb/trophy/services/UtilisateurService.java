package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.UtilisateurDao;
import hei.devweb.trophy.pojos.Utilisateur;

/* Classe définissant les méthodes disponibles pour chaque utilisateur */

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
	
	/* méthode de listage */
	
	public List<Utilisateur> listUtilisateur() {
		return utilisateurDao.listUtilisateur();
	}
	
	/* méthode d'ajout */
	
	public void addUtilisateur(Integer idUser, String nom, String prenom, String mail,
			String photo, String classe, String identif){
		utilisateurDao.addUtilisateur(idUser,nom, prenom, mail,
				photo,classe);
	}
	
	/* méthode de suppression */
	
	public void deleteUtilisateur(Integer idUser){
		try {
			utilisateurDao.deleteUtilisateur(idUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
