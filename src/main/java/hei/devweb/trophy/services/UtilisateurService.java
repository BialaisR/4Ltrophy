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
	
	public void addUtilisateur(String identifiant, String motDePasse, String nom, String prenom, String mail,
			Integer nbMessagesForum, String dateInscription, Boolean participant, String photo, String classe,
			Boolean admin){
		utilisateurDao.addUtilisateur(identifiant, motDePasse, nom, prenom, mail,
				nbMessagesForum, dateInscription, participant,photo,classe,
				admin);
	}
	
	public void deleteUtilisateur(String identifiant){
		try {
			utilisateurDao.deleteUtilisateur(identifiant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
