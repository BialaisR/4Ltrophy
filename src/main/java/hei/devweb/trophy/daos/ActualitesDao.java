package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Actualites;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

public class ActualitesDao {
	
	/* on liste par id décroissant */

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
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */
	
	public void addActualites(Integer idActu,String titreActu, String actu) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO actualites(titreActu, actu) VALUES (?,?)")) {
			statement.setString(1, titreActu);
			statement.setString(2, actu);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* on supprime avec en paramètre l'identifiant */
	
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

