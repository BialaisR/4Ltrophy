package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Contact;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class ContactDaoTestCase {
	
	private ContactDao contactDao = new ContactDao();

	/* On teste que la champ ajouté se retrouve bien dans la bdd */
	
	@Test
	public void shouldSaveContact() throws Exception {
		// GIVEN
		Contact contactToAdd = new Contact("Jean","LaSalle","jeanlasalle@hotmail.fr","Bonjour chers français");
		// WHEN
		Contact contactAdded = contactDao.saveContact(contactToAdd);
		// THEN
		Assertions.assertThat(contactAdded).isNotNull();
		Assertions.assertThat(contactAdded.getNomContact()).isEqualTo("LaSalle");
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM contact WHERE nomContact = ?")) {
			stmt.setString(1,contactAdded.getNomContact());
			try (ResultSet rs = stmt.executeQuery()) {
				Assertions.assertThat(rs.next()).isTrue();
				Assertions.assertThat(rs.getString("mailContact")).isEqualTo("jeanlasalle@hotmail.fr");
			}
		}
	}
}
