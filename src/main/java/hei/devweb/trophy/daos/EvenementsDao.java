package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Evenements;

public class EvenementsDao {

	public List<Evenements> listEvenements(){
		List<Evenements> event = new ArrayList<Evenements>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM evenements ORDER BY idActu DESC")) {
				while (resultSet.next()) {
					event.add(new Evenements(resultSet.getInt("idEvent"), resultSet.getDate("titreActu").toLocalDate(), resultSet.getString("event")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return event;
		}
	
	
	public void addEvenements(Evenements newEvenements) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO evenements(idEvent, dateEvent, event) VALUES (?,?,?)")) {
			statement.setDate(1, Date.valueOf(newEvenements.getDateEvent()));
			statement.setString(2,newEvenements.getEvent());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEvenements(Integer idEvent){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE * FROM evenements WHERE idEvent=?")) {
			
			statement.setInt(1, idEvent);
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}