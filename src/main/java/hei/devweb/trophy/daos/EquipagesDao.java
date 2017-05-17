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
						resultSet.getString("descriptionEquipage"),resultSet.getString("nom1"),resultSet.getString("nom2"), 
						resultSet.getString("prenom1"), resultSet.getString("prenom2"), resultSet.getString("mail1"),
						resultSet.getString("mail2"), resultSet.getString("classe1"), resultSet.getString("classe2"),
						resultSet.getString("photo1"), resultSet.getString("photo2"), resultSet.getString("photoEquipage")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipage;
	}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */

	public void addEquipages(Integer numeroEquipage, String nomEquipage, String descriptionEquipage, String nom1, String nom2, String prenom1, String prenom2, String mail1, String mail2, String classe1, String classe2, String photo1, String photo2, String photoEquipage) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO equipages(nomEquipage, descriptionEquipage, nom1, nom2, prenom1, prenom2, mail1, mail2, classe1, classe2, photo1, photo2, photoEquipage) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
			statement.setString(1, nomEquipage);
			statement.setString(2, descriptionEquipage);
			statement.setString(3, nom1);
			statement.setString(4, nom2);
			statement.setString(5, prenom1);
			statement.setString(6, prenom2);
			statement.setString(7, mail1);
			statement.setString(8, mail2);
			statement.setString(9, classe1);
			statement.setString(10, classe2);
			statement.setString(11, photo1);
			statement.setString(12, photo2);
			statement.setString(13, photoEquipage);
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
