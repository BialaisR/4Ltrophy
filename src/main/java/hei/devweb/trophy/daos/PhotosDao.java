package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Photos;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */
public class PhotosDao {
	
	/* on liste par id décroissant */

	public List<Photos> listPhotos(){
		List<Photos> photos = new ArrayList<Photos>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Photos ORDER BY idPhoto DESC")) {
				while (resultSet.next()) {
					photos.add(new Photos(resultSet.getInt("idPhoto"), resultSet.getString("photo"), resultSet.getInt("idAlbum")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return photos;
		}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */
	
	public void addPhotos(int idPhoto, String photo, int idAlbum) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Photos(photo, idAlbum) VALUES (?,?)")) {
			statement.setString(1, photo);
			statement.setInt(2,idAlbum);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/* on supprime avec en paramètre l'identifiant */
	
	public void deletePhotos(Integer idPhoto){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM photo WHERE idPhoto=?")){
			statement.setInt(1, idPhoto);  
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
