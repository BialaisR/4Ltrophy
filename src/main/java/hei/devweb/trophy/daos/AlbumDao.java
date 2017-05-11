package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

import hei.devweb.trophy.pojos.Album;

public class AlbumDao {
	
	/* on liste par nom d'album*/

	public List<Album> listAlbum() {
		List<Album> album = new ArrayList<Album>();

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM album ORDER BY nomAlbum")) {
			while (resultSet.next()) {
				album.add(new Album(resultSet.getInt("idAlbum"), resultSet.getString("nomAlbum")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */

	public void addAlbum(int idAlbum, String nomAlbum) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO album(nomAlbum) VALUES (?)")) {
			statement.setString(1, nomAlbum);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/* on supprime avec en paramètre l'identifiant */
	
	public void deleteAlbum(Integer idAlbum){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE * FROM album WHERE idAlbum=?")) {
			
			statement.setInt(1, idAlbum);
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
