package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Utilisateur;

public class UtilisateurDao {
	
	public List<Utilisateur> listUtilisateur(){
		List<Utilisateur> Utilisateur = new ArrayList<Utilisateur>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Utilisateur ORDER BY nom")) {
				while (resultSet.next()) {
					Utilisateur.add(new Utilisateur(resultSet.getString("identifiant"), resultSet.getString("motDePasse"), resultSet.getString("nom"),
							resultSet.getString("prenom"),resultSet.getString("mail"),resultSet.getInt("nbMessagesForum"), resultSet.getString("dateInscription"),
							resultSet.getBoolean("participant"),resultSet.getString("photo"),resultSet.getString("classe"),resultSet.getBoolean("admin")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return Utilisateur;
		}
	
	
	public void addUtilisateur(String identifiant, String motDePasse, String nom, String prenom, String mail,
			Integer nbMessagesForum, String dateInscription, Boolean participant, String photo, String classe,
			Boolean admin) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Utilisateur(identifiant, motDePasse, nom, prenom, mail, nbMessagesForum, dateInscription, participant, photo, classe, admin) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
			statement.setString(1, identifiant); 
			statement.setString(2,motDePasse);
			statement.setString(3,nom);
			statement.setString(4,prenom);
			statement.setString(5,mail);
			statement.setInt(6,nbMessagesForum);
			statement.setString(7,dateInscription);
			statement.setBoolean(8,participant);
			statement.setString(9,photo);
			statement.setString(10,classe);
			statement.setBoolean(11,admin);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUtilisateur(String identifiant){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM utilisateur WHERE identifiant=?")){
			statement.setString(1, identifiant);  
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
