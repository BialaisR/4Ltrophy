package hei.devweb.trophy.services;

import java.util.List;

import hei.devweb.trophy.daos.EquipagesDao;
import hei.devweb.trophy.pojos.Equipages;

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
	
	public List<Equipages> listEquipages() {
		return equipagesDao.listEquipages();
	}
	
	public void addEquipages(int numeroEquipage, String nomEquipage, String identifParticipant1, String identifParticipant2, String descriptionEquipage, String photoEquipage){
		equipagesDao.addEquipages(numeroEquipage, nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage);
	}
	
	public void deleteEquipages(Integer numeroEquipage){
		try {
			equipagesDao.deleteEquipages(numeroEquipage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
