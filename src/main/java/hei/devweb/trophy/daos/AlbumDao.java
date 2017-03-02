package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Album;

public class AlbumDao {

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

	public void addAlbum(Album newAlbum) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO album(idAlbum, nomAlbum) VALUES (?,?)")) {
			statement.setString(1, newAlbum.getNomAlbum());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
