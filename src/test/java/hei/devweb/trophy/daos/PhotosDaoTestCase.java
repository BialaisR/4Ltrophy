package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Photos;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class PhotosDaoTestCase {
	
	private PhotosDao photosDao = new PhotosDao();
	
	/* On définie une entrée initiale dans la table */
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM photos");
			statement.executeUpdate("INSERT INTO photos(idPhoto,photo,idAlbum) VALUES (1,'phototest 1',4)");
			statement.executeUpdate("INSERT INTO photos(idPhoto,photo,idAlbum) VALUES (2,'phototest 2',7)");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
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
	
	/* On teste que la nouvelle taille est bien de 1 de plus que la taille initiale après ajout */
	
	@Test
	public void shouldAddPhotos() throws Exception {
		//WHEN
		photosDao.addPhotos(3, "new photo",5);
		//THEN
		List<Photos> photos = photosDao.listPhotos();
		Assertions.assertThat(photos).hasSize(3);
	
	}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
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
