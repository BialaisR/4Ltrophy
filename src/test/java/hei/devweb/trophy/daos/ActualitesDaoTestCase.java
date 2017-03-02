package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Actualites;


public class ActualitesDaoTestCase {
	
private ActualitesDao actusDao = new ActualitesDao();
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM actualites");
			statement.executeUpdate("INSERT INTO actualites(idActu,titreActu,actu) VALUES (1,'actualités test','descritpiton 1azeazeazeaze')");
			statement.executeUpdate("INSERT INTO actualites(idActu,titreActu,actu) VALUES (2,'actualités test 2 motherfcker','descritpiton 2dfgazeazeaezdgfdgrfgdfgazeaze')");
		}
	}
	
	@Test
	public void shouldListActualites() throws Exception {
		//WHEN
		List<Actualites> actus = actusDao.listActualites();
		//THEN
		Assertions.assertThat(actus).hasSize(2);
		Assertions.assertThat(actus).extracting("idActu","titreActu","actu").containsOnly(
				Assertions.tuple(1,"actualités test","descritpiton 1azeazeazeaze"),
				Assertions.tuple(2,"actualités test 2 motherfcker","descritpiton 2dfgazeazeaezdgfdgrfgdfgazeaze")
				);
	}
	
	@Test
	public void shouldAddActualites() throws Exception {
		Actualites actualitestoAdd = new Actualites(null, "new actu","testaddnouvelle actu");
		//WHEN
		actusDao.addActualites(actualitestoAdd);
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
}
