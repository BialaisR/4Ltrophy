package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.EquipagesDao;
import hei.devweb.trophy.pojos.Equipages;

/* Classe définissant les méthodes disponibles pour chaque équipage */

public class EquipagesService {
private EquipagesDao equipagesDao = new EquipagesDao();
	
	private static class EquipageserviceHolder {
		private static EquipagesService instance = new EquipagesService();
	}
	
	public static EquipagesService getInstance() {
		return EquipageserviceHolder.instance;
	}

	private EquipagesService() {
	}
	
	/* méthode de listage */
	
	public List<Equipages> listEquipages() {
		return equipagesDao.listEquipages();
	}
	
	/* méthode d'ajout */
	
	public void addEquipages(Integer numeroEquipage, String nomEquipage, String descriptionEquipage, String nom1, String nom2, String prenom1, String prenom2, String mail1, String mail2, String classe1, String classe2, String photo1, String photo2, String photoEquipage){
		equipagesDao.addEquipages(numeroEquipage, nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1,
				mail2, classe1, classe2, photo1, photo2, photoEquipage);
	}
	
	/* méthode de suppression */
	
	public void deleteEquipages(Integer numeroEquipage){
		try {
			equipagesDao.deleteEquipages(numeroEquipage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
