package hei.devweb.trophy.daos;

import java.sql.Connection;
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
				ResultSet resultSet = statement.executeQuery("SELECT * FROM sujet ORDER BY idSujet DESC")) {
				while (resultSet.next()) {
					Sujet.add(new Sujet(resultSet.getInt("idSujet"), resultSet.getString("identifiantCreateur"), resultSet.getString("nomSujet"), resultSet.getString("dateLastPost"),
							resultSet.getInt("nbMessage"),resultSet.getString("identifiantLastPost")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return Sujet;
		}
	
	
	public void addSujet(Sujet newSujet) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Sujet(nomSujet, identifiantCreateur, dateLastPost,nbMessage,identifiantLastPost) VALUES (?,?,?,?,?)")) {
			statement.setString(1, newSujet.getNomSujet());
			statement.setString(2, newSujet.getIdentifiantCreateur());
			statement.setString(3,newSujet.getDateLastPost());
			statement.setInt(4,newSujet.getNbMessage());
			statement.setString(5,newSujet.getIdentifiantLastPost());
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
