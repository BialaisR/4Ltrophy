package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Sujet;

public class SujetDao {
	
	public List<Sujet> listSujet(){
		List<Sujet> Sujet = new ArrayList<Sujet>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Sujet ORDER BY idSujet DESC")) {
				while (resultSet.next()) {
					Sujet.add(new Sujet(resultSet.getInt("idSujet"), resultSet.getString("identifiantCreateur"), resultSet.getString("nomSujet"), resultSet.getDate("dateLastPost").toLocalDate(),
							resultSet.getInt("nbMessages"),resultSet.getString("identifiantLastPost")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return Sujet;
		}
	
	
	public void addSujet(Sujet newSujet) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Sujet(idSujet, identifiantCreateur, nomSujet ,dateLastPost,nbMessage,identifiantLastPost) VALUES (?,?,?,?,?,?)")) {
			statement.setString(1, newSujet.getIdentifiantCreateur());
			statement.setDate(2,Date.valueOf(newSujet.getDateLastPost()));
			statement.setInt(3,newSujet.getNbMessages());
			statement.setString(4,newSujet.getIdentifiantLastPost());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSujet(Integer idSujet){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM sujet WHERE idSujet=?")){
			statement.setInt(1, idSujet);  
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
