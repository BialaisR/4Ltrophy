package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Equipages;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

public class EquipagesDao {
	
	/* on liste par id croissant */

	public List<Equipages> listEquipages() {
		List<Equipages> equipage = new ArrayList<Equipages>();

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM equipages ORDER BY numeroEquipage ASC")) {
			while (resultSet.next()) {
				equipage.add(new Equipages(resultSet.getInt("numeroEquipage"), resultSet.getString("nomEquipage"),
						resultSet.getString("identifParticipant1"), resultSet.getString("identifParticipant2"),
						resultSet.getString("descriptionEquipage"), resultSet.getString("photoEquipage")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipage;
	}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */

	public void addEquipages(Integer numeroEquipage, String nomEquipage, String identifParticipant1, String identifParticipant2, String descriptionEquipage, String photoEquipage) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO equipages(nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage) VALUES (?,?,?,?,?)")) {
			statement.setString(1, nomEquipage);
			statement.setString(2, identifParticipant1);
			statement.setString(3, identifParticipant2);
			statement.setString(4, descriptionEquipage);
			statement.setString(5, photoEquipage);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* on supprime avec en paramètre l'identifiant */
	
	public void deleteEquipages(Integer numeroEquipage){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE * FROM equipages WHERE numeroEquipage=?")) {
			
			statement.setInt(1, numeroEquipage);
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
