
package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Actualites;

public class ActualitesDao {

	public List<Actualites> listActualites(){
		List<Actualites> actus = new ArrayList<Actualites>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM actualites ORDER BY idActu DESC")) {
				while (resultSet.next()) {
					actus.add(new Actualites(resultSet.getInt("idActu"), resultSet.getString("titreActu"), resultSet.getString("actu")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return actus;
		}
	
	
	public void addActualites(Actualites newActualites) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO actualites(titreActu, actu) VALUES (?,?)")) {
			statement.setString(1, newActualites.getTitreActu());
			statement.setString(2,newActualites.getActu());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteActualites(Integer idActu){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE * FROM actualites WHERE idActu=?")) {
			
			statement.setInt(1, idActu);
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

