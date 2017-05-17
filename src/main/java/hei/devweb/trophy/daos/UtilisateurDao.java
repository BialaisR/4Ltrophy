package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Utilisateur;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

public class UtilisateurDao {
	
	/* on liste par ordre alphabétique */
	
	public List<Utilisateur> listUtilisateur(){
		List<Utilisateur> Utilisateur = new ArrayList<Utilisateur>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Utilisateur ORDER BY nom")) {
				while (resultSet.next()) {
					Utilisateur.add(new Utilisateur(resultSet.getInt("idUser"), resultSet.getString("nom"),
							resultSet.getString("prenom"),resultSet.getString("mail"),resultSet.getString("photo"),resultSet.getString("classe"),resultSet.getString("identif")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return Utilisateur;
		}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */
	
	public void addUtilisateur(Integer idUser, String nom, String prenom, String mail,
			 String photo, String classe) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Utilisateur(nom, prenom, mail, photo, classe, identif) VALUES (?,?,?,?,?,?)")) {
			statement.setString(1,nom);
			statement.setString(2,prenom);
			statement.setString(3,mail);
			statement.setString(4,photo);
			statement.setString(5,classe);
			statement.setString(6,nom+prenom+classe);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/* on supprime avec en paramètre l'identifiant */
	
	public void deleteUtilisateur(Integer idUser){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM utilisateur WHERE idUser=?")){
			statement.setInt(1, idUser);  
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
