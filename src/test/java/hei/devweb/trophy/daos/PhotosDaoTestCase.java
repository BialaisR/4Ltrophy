package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Evenements;
import hei.devweb.trophy.pojos.Photos;

public class PhotosDaoTestCase {
	
	private PhotosDao photosDao = new PhotosDao();

	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM photos");
			statement.executeUpdate("INSERT INTO photos(idPhoto,photo,idAlbum) VALUES (1,'phototest 1',4)");
			statement.executeUpdate("INSERT INTO photos(idPhoto,photo,idAlbum) VALUES (2,'phototest 2',7)");
		}
	}
	
	@Test
	public void shouldListPhotos() throws Exception {
		//WHEN
		List<Photos> photos = photosDao.listPhotos();
		//THEN
		Assertions.assertThat(photos).hasSize(2);
		Assertions.assertThat(photos).extracting("idPhoto","photo","idAlbum").containsOnly(
				Assertions.tuple(1,"phototest 1",4),
				Assertions.tuple(2,"phototest 2",7)
				);
	}
	
	@Test
	public void shouldAddPhotos() throws Exception {
		Photos photostoAdd = new Photos(5, "new photo",5);
		//WHEN
		photosDao.addPhotos(photostoAdd);
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM photos WHERE photo='new photo'")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("idPhoto")).isNotNull();
			Assertions.assertThat(resultSet.getString("photo")).isEqualTo("new photo");
			Assertions.assertThat(resultSet.getString("idAlbum")).isEqualTo(5);
			Assertions.assertThat(resultSet.next()).isFalse();
			
		}
	}
	
	@Test
	public void shouldDeletePhotos() throws Exception {
		// GIVEN
		Photos photo1 = new Photos(5, "new photo",5);
		// WHEN
		photosDao.deletePhotos(photo1);
		List<Photos> listPhotos = photosDao.listPhotos();
		//THEN
		Assertions.assertThat(listPhotos).hasSize(2);
	}
}
