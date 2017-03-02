package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Album;

public class AlbumDaoTestCase {

private AlbumDao albumDao = new AlbumDao();
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM album");
			statement.executeUpdate("INSERT INTO album(idAlbum, nomAlbum) VALUES (1,'album 1')");
			statement.executeUpdate("INSERT INTO album(idAlbum, nomAlbum) VALUES (2,'album 2')");
		}
	}
	
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
	
	@Test
	public void shouldAddAlbum() throws Exception {
		Album albumtoAdd = new Album(null, "new album");
		//WHEN
		albumDao.addAlbum(albumtoAdd);
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
}
