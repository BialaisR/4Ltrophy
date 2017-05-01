package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Actualites;
import hei.devweb.trophy.pojos.Equipages;

public class EquipageDaoTestCase {
	

	private EquipagesDao equipagesDao = new EquipagesDao();
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM equipages");
			statement.executeUpdate("INSERT INTO equipages(numeroEquipage, nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage) VALUES (123, 'Equipages 1', 'jean', 'eude', 'coucou c nous', 'img')");
			statement.executeUpdate("INSERT INTO equipages(numeroEquipage, nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage) VALUES (456, 'Equipages 2', 'jean2', 'makoun', 'coucou c nous aussi', 'img2')");
		}
	}
	
	@Test
	public void shouldListEquipages() throws Exception {
		//WHEN
		List<Equipages> equipages = equipagesDao.listEquipages();
		//THEN
		Assertions.assertThat(equipages).hasSize(2);
		Assertions.assertThat(equipages).extracting("numeroEquipage","nomEquipage","identifParticipant1", "identifParticipant2", "descriptionEquipage", "photoEquipage").containsOnly(
				Assertions.tuple(123,"Equipages 1","jean", "eude", "coucou c nous", "img"),
				Assertions.tuple(456,"Equipages 2", "jean2", "makoun", "coucou c nous aussi", "img2")
				);
	}
	
	@Test
	public void shouldAddEquipages() throws Exception {
		Equipages equipagestoAdd = new Equipages(222, "new Equipage","nom1" , "nom2", "description bro", "pas image");
		//WHEN
		equipagesDao.addEquipages(222, "new Equipage","nom1" , "nom2", "description bro", "pas image");
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM equipages WHERE numeroEquipage=222")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("numeroEquipage")).isNotNull();
			Assertions.assertThat(resultSet.getString("nomEquipage")).isEqualTo("new Equipage");
			Assertions.assertThat(resultSet.getString("identifParticipant1")).isEqualTo("nom1");
			Assertions.assertThat(resultSet.getString("identifParticipant2")).isEqualTo("nom2");
			Assertions.assertThat(resultSet.getString("descriptionEquipage")).isEqualTo("description bro");
			Assertions.assertThat(resultSet.getString("photoEquipage")).isEqualTo("pas image");
			Assertions.assertThat(resultSet.next()).isFalse();
			
		}
	}
	
	@Test
	public void shouldDeleteEquipages() throws Exception {
		// GIVEN
		Equipages equipage1 = new Equipages(222, "new Equipage","nom1" , "nom2", "description bro", "pas image");
		// WHEN
		equipagesDao.deleteEquipages(222);
		List<Equipages> listEquip = equipagesDao.listEquipages();
		//THEN
		Assertions.assertThat(listEquip).hasSize(2);
	}
}

