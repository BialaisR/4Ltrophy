package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Date;
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
							resultSet.getString("prenom"),resultSet.getString("mail"),resultSet.getInt("nbMessagesForum"), resultSet.getDate("dateInscription").toLocalDate(),
							resultSet.getBoolean("participant"),resultSet.getString("photo"),resultSet.getString("classe"),resultSet.getBoolean("admin")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return Utilisateur;
		}
	
	
	public void addUtilisateur(Utilisateur newUtilisateur) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Utilisateur(identifiant, motDePasse, nom, prenom, mail, nbMessagesForum, dateInscription, participant, photo, classe, admin) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
			// statement.setString(1, newUtilisateur.getIdentifiant()); 
			statement.setString(1,newUtilisateur.getMotDePasse());
			statement.setString(2,newUtilisateur.getNom());
			statement.setString(3,newUtilisateur.getPrenom());
			statement.setString(4,newUtilisateur.getMail());
			statement.setInt(5,newUtilisateur.getNbMessagesForum());
			statement.setDate(6,Date.valueOf(newUtilisateur.getDateInscription()));
			statement.setBoolean(7,newUtilisateur.getParticipant());
			statement.setString(8,newUtilisateur.getPhoto());
			statement.setString(9,newUtilisateur.getClasse());
			statement.setBoolean(10,newUtilisateur.getAdmin());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
