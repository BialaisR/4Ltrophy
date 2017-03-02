package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Photos;

public class PhotosDao {

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
	
	
	public void addPhotos(Photos newPhotos) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Photos(idPhoto, photo, idAlbum) VALUES (?,?,?)")) {
			statement.setString(1, newPhotos.getPhoto());
			statement.setInt(2,newPhotos.getIdAlbum());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
