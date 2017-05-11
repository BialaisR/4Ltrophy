package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Message;

/* classe implémentant les fonctions disponibles pour les équipages. 
 * Les trois fonctions sont les suivantes : lister, ajouter, supprimer.
 * Permet d'interagir avec la base de données.
 */

public class MessageDao {
	
	/* on liste par date de post décroissante */

	public List<Message> listMessage(){
		
		List<Message> message = new ArrayList<Message>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM message ORDER BY datePost DESC")) {
				while (resultSet.next()) {
					message.add(new Message(resultSet.getInt("idMessage"), resultSet.getString("texteMessage"), resultSet.getString("datePost"),resultSet.getInt("idSujet")));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return message;
		}
	
	/* on prend tous les paramètres lorsque l'on souhaite ajouter */
	
	
	public void addMessage(Integer idMessage, String texteMessage, String datePost, Integer idSujet) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO message(texteMessage, datePost,idSujet) VALUES (?,?,?)")) {
			statement.setString(1, texteMessage);
			statement.setString(2,datePost);
			statement.setInt(3,idSujet);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
	

	/* on supprime avec en paramètre l'identifiant */
	
	public void deleteMessage(Integer idMessage){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE FROM message WHERE idMessage=?")){
			statement.setInt(1,idMessage);  
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}