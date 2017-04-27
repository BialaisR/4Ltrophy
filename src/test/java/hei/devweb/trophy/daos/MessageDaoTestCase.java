package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Message;

public class MessageDaoTestCase {

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

@Test
public void shouldListMessage() throws Exception {
	//WHEN
	List<Message> message = messageDao.listMessage();
	//THEN
	Assertions.assertThat(message).hasSize(2);
	Assertions.assertThat(message).extracting("idMessage","texteMessage","datePost").containsOnly(
			Assertions.tuple(1,"test1 message","2017-03-02",5),
			Assertions.tuple(2,"test2 message","2017-01-07",6)
			);
}

@Test
public void shouldAddMessage() throws Exception {
	Message MessagetoAdd = new Message(3, "new message","2017-01-01",21);
	//WHEN
	messageDao.addMessage(MessagetoAdd);
	//THEN
	try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Message WHERE texteMessage='new message'")) {
		Assertions.assertThat(resultSet.next()).isTrue();
		Assertions.assertThat(resultSet.getInt("idMessage")).isNotNull();
		Assertions.assertThat(resultSet.getString("textMessage")).isEqualTo("new message");
		Assertions.assertThat(resultSet.getDate("datePost")).isEqualTo("2017-01-01");
		Assertions.assertThat(resultSet.next()).isFalse();
	}
}


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