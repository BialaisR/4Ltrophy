package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

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
		Photos photostoAdd = new Photos(3, "new photo",5);
		//WHEN
		photosDao.addPhotos(photostoAdd);
		//THEN
		List<Photos> photos = photosDao.listPhotos();
		Assertions.assertThat(photos).hasSize(3);
	
	}
	
	@Test
	public void shouldDeletePhotos() throws Exception {
		// GIVEN
		Photos photo1 = new Photos(3, "new photo",5);
		// WHEN
		photosDao.deletePhotos(3);
		List<Photos> listPhotos = photosDao.listPhotos();
		//THEN
		Assertions.assertThat(listPhotos).hasSize(2);
	}
}
