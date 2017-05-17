package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Evenements;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

public class EvenementsDao {
	
	/* on liste par id décroissant */

	public List<Evenements> listEvenements(){
		List<Evenements> event = new ArrayList<Evenements>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM evenements")) {
				while (resultSet.next()) {
					event.add(new Evenements(resultSet.getInt("idEvent"), resultSet.getString("dateEvent"), resultSet.getString("event")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return event;
		}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */
	
	public void addEvenements(Integer idEvent, String dateEvent, String event) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO evenements(dateEvent, event) VALUES (?,?)")) {
			statement.setString(1,dateEvent);
			statement.setString(2,event);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/* on supprime avec en paramètre l'identifiant */
	
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