package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Message;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class MessageDaoTestCase {
	
/* On définit une entrée initiale dans la table */

	private MessageDao messageDao = new MessageDao();
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM message");
			statement.executeUpdate("INSERT INTO message(idMessage,texteMessage,datePost,idSujet) VALUES (1,'test1 message','2017-03-02',5)");
			statement.executeUpdate("INSERT INTO message(idMessage,texteMessage,datePost,idSujet) VALUES (2,'test2 message','2017-01-07',6)");
			}
	}

	/* On teste que l'affichage correspond à ce que l'on a rentré */

	@Test
	public void shouldListMessage() throws Exception {
		//WHEN
		List<Message> message = messageDao.listMessage();
		//THEN
		Assertions.assertThat(message).hasSize(2);
		Assertions.assertThat(message).extracting("idMessage","texteMessage","datePost","idSujet").containsOnly(
				Assertions.tuple(1,"test1 message","2017-03-02",5),
				Assertions.tuple(2,"test2 message","2017-01-07",6)
				);
	}

	/* On teste que la champ ajouté se retrouve bien dans la bdd */

	@Test
	public void shouldAddMessage() throws Exception {
		//WHEN
		messageDao.addMessage(3, "new message","2017-01-01",21);
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Message WHERE texteMessage='new message'")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("idMessage")).isNotNull();
			Assertions.assertThat(resultSet.getString("texteMessage")).isEqualTo("new message");
			Assertions.assertThat(resultSet.getDate("datePost")).isEqualTo("2017-01-01");
			Assertions.assertThat(resultSet.next()).isFalse();
		}
	}

	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */

	@Test
	public void shouldDeleteMessage() throws Exception {
		// GIVEN
		Message message1 = new Message(3, "new message","2017-01-01",21);
		// WHEN
		messageDao.deleteMessage(3);
		List<Message> listMessage = messageDao.listMessage();
		//THEN
		Assertions.assertThat(listMessage).hasSize(2);
	}
}