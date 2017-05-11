package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* Classe implémentant les fonctions disponibles pour les contacts. 
 * Permet d'interagir avec la base de données.
 */

import hei.devweb.trophy.pojos.Contact;

public class ContactDao {
	
	/* cette fonction permet de sauvegarder le contact ajouté (méthode ajouter à la bdd)*/

	public Contact saveContact(Contact contact){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO contact(prenomContact,nomContact,mailContact,messageContact) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,contact.getPrenomContact());
			stmt.setString(2,contact.getNomContact());
			stmt.setString(3,contact.getMailContact());
			stmt.setString(4,contact.getMessageContact());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}
	
}
