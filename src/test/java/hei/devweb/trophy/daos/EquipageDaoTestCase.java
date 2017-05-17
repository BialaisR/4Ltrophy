package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Equipages;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class EquipageDaoTestCase {
	

	private EquipagesDao equipagesDao = new EquipagesDao();
	
	/* On définit une entrée initiale dans la table */
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM equipages");
			statement.executeUpdate("INSERT INTO equipages(numeroEquipage, nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1, mail2, classe1, classe2, photo1, photo2, photoEquipage) VALUES (123, 'Equipages 123 LES DHEIGLINGUES', 'Description des 2D', 'Dupont', 'Durant', 'DupontPrenom', 'DurantPrenom', 'Dupont@gmail', 'Durant@gmail', 'H44', 'H44aussi', 'img1', 'img2','img')");
			statement.executeUpdate("INSERT INTO equipages(numeroEquipage, nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1, mail2, classe1, classe2, photo1, photo2, photoEquipage) VALUES (456, 'Equipages 456 LES HEIPRPOUVETTE', 'Description des CB', 'Canu', 'Beghin', 'CPrenom', 'BPrenom', 'C@gmail', 'B@gmail', 'H44', 'H44aussi', 'img11', 'img22','img3')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
	@Test
	public void shouldListEquipages() throws Exception {
		//WHEN
		List<Equipages> equipages = equipagesDao.listEquipages();
		//THEN
		Assertions.assertThat(equipages).hasSize(2);
		Assertions.assertThat(equipages).extracting("numeroEquipage", "nomEquipage", "descriptionEquipage", "nom1", "nom2", "prenom1", "prenom2", "mail1", "mail2", "classe1", "classe2", "photo1", "photo2", "photoEquipage").containsOnly(
				Assertions.tuple(123, "Equipages 123 LES DHEIGLINGUES", "Description des 2D", "Dupont", "Durant", "DupontPrenom", "DurantPrenom", "Dupont@gmail", "Durant@gmail", "H44", "H44aussi", "img1", "img2","img"),
				Assertions.tuple(456, "Equipages 456 LES HEIPRPOUVETTE", "Description des CB", "Canu", "Beghin", "CPrenom", "BPrenom", "C@gmail", "B@gmail", "H44", "H44aussi", "img11", "img22","img3")
				);
	}
	
	/* On teste que la champ ajouté se retrouve bien dans la bdd */
	/*
	@Test
	public void shouldAddEquipages() throws Exception {
		//WHEN
		equipagesDao.addEquipages(125, "Equipages 125 LES DHEIGLINGUES", "Description des 2D", "Dupont", "Durant", "DupontPrenom", "DurantPrenom", "Dupont@gmail", "Durant@gmail", "H44", "H44aussi", "img1", "img2","img");
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM equipages WHERE numeroEquipage='125'")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("numeroEquipage")).isNotNull();
			Assertions.assertThat(resultSet.getString("nomEquipage")).isEqualTo("Equipages 125 LES DHEIGLINGUES");
			Assertions.assertThat(resultSet.getString("descriptionEquipage")).isEqualTo("Description des 2D");
			Assertions.assertThat(resultSet.getString("nom1")).isEqualTo("Dupont");
			Assertions.assertThat(resultSet.getString("nom2")).isEqualTo("Durant");
			Assertions.assertThat(resultSet.getString("prenom1")).isEqualTo("DupontPrenom");
			Assertions.assertThat(resultSet.getString("prenom2")).isEqualTo("DurantPrenom");
			Assertions.assertThat(resultSet.getString("mail1")).isEqualTo("Dupont@gmail");
			Assertions.assertThat(resultSet.getString("mail2")).isEqualTo("Durant@gmail");
			Assertions.assertThat(resultSet.getString("classe1")).isEqualTo("H44");
			Assertions.assertThat(resultSet.getString("classe2")).isEqualTo("H44aussi");
			Assertions.assertThat(resultSet.getString("photo1")).isEqualTo("img1");
			Assertions.assertThat(resultSet.getString("photo2")).isEqualTo("img2");
			Assertions.assertThat(resultSet.getString("photoEquipage")).isEqualTo("img");
			Assertions.assertThat(resultSet.next()).isFalse();
			
		}
		
	}*/
	
	@Test
	public void shouldAddEquipages() throws Exception {
		//WHEN
		equipagesDao.addEquipages(125, "Equipages 125 LES DHEIGLINGUES", "Description des 2D", "Dupont", "Durant", "DupontPrenom", "DurantPrenom", "Dupont@gmail", "Durant@gmail", "H44", "H44aussi", "img1", "img2","img");
		//THEN
		List<Equipages> equipages = equipagesDao.listEquipages();
		Assertions.assertThat(equipages).hasSize(3);
			
		}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteEquipages() throws Exception {
		// GIVEN
		Equipages equipage1 = new Equipages(125, "Equipages 123 LES DHEIGLINGUES", "Description des 2D", "Dupont", "Durant", "DupontPrenom", "DurantPrenom", "Dupont@gmail", "Durant@gmail", "H44", "H44aussi", "img1", "img2","img");
		// WHEN
		equipagesDao.deleteEquipages(222);
		List<Equipages> listEquip = equipagesDao.listEquipages();
		//THEN
		Assertions.assertThat(listEquip).hasSize(2);
	}
}

