package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Album;

/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class AlbumDaoTestCase {

private AlbumDao albumDao = new AlbumDao();

	/* On définit une entrée initiale dans la table */
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM album");
			statement.executeUpdate("INSERT INTO album(idAlbum, nomAlbum) VALUES (1,'album 1')");
			statement.executeUpdate("INSERT INTO album(idAlbum, nomAlbum) VALUES (2,'album 2')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
	@Test
	public void shouldListAlbum() throws Exception {
		//WHEN
		List<Album> actus = albumDao.listAlbum();
		//THEN
		Assertions.assertThat(actus).hasSize(2);
		Assertions.assertThat(actus).extracting("idAlbum","nomAlbum").containsOnly(
				Assertions.tuple(1,"album 1"),
				Assertions.tuple(2,"album 2")
				);
	}
	
	/* On teste que la champ ajouté se retrouve bien dans la bdd */
	
	@Test
	public void shouldAddAlbum() throws Exception {
		//WHEN
		albumDao.addAlbum(3, "new album");
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM album WHERE nomAlbum='new album'")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("idAlbum")).isNotNull();
			Assertions.assertThat(resultSet.getString("nomAlbum")).isEqualTo("new album");
			Assertions.assertThat(resultSet.next()).isFalse();
		}
	}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteAlbum() throws Exception {
		// GIVEN
		Album album1 = new Album(3, "new album");
		// WHEN
		albumDao.deleteAlbum(3);
		List<Album> listAlbum = albumDao.listAlbum();
		//THEN
		Assertions.assertThat(listAlbum).hasSize(2);
	}
	
}
