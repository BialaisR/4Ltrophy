package hei.devweb.trophy.daos;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Actualites;

/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */


public class ActualitesDaoTestCase {
	
private ActualitesDao actusDao = new ActualitesDao();

	/* On définit une entrée initiale dans la table */
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM actualites");
			statement.executeUpdate("INSERT INTO actualites(idActu,titreActu,actu) VALUES (1,'actualités test','descritpiton 1')");
			statement.executeUpdate("INSERT INTO actualites(idActu,titreActu,actu) VALUES (2,'actualités test 2','descritpiton 2dfgazeazeaezdgfdgrfgdfgazeaze')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
	@Test
	public void shouldListActualites() throws Exception {
		//WHEN
		List<Actualites> actus = actusDao.listActualites();
		//THEN
		Assertions.assertThat(actus).hasSize(2);
		Assertions.assertThat(actus).extracting("idActu","titreActu","actu").containsOnly(
				Assertions.tuple(1,"actualités test","descritpiton 1"),
				Assertions.tuple(2,"actualités test 2","descritpiton 2dfgazeazeaezdgfdgrfgdfgazeaze")
				);
	}
	
	/* On teste que la champ ajouté se retrouve bien dans la bdd */
	
	
	@Test
	public void shouldAddActualites() throws Exception {
		//WHEN
		actusDao.addActualites(3, "new actu","testaddnouvelle actu");
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM actualites WHERE titreActu='new actu'")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("idActu")).isNotNull();
			Assertions.assertThat(resultSet.getString("titreActu")).isEqualTo("new actu");
			Assertions.assertThat(resultSet.getString("actu")).isEqualTo("testaddnouvelle actu");
			Assertions.assertThat(resultSet.next()).isFalse();
			
		}
	}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteActualites() throws Exception {
		// GIVEN
		Actualites actu1 = new Actualites(3,"actualités test","descritpiton 1");
		// WHEN
		actusDao.deleteActualites(3);
		List<Actualites> listActus = actusDao.listActualites();
		//THEN
		Assertions.assertThat(listActus).hasSize(2);
	}
}
