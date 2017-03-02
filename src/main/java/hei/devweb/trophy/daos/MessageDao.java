package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Message;

public class MessageDao {

	public List<Message> listMessage(){
		List<Message> message = new ArrayList<Message>();
		
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Message ORDER BY datepost DESC")) {
				while (resultSet.next()) {
					message.add(new Message(resultSet.getInt("idMessage"), resultSet.getString("textMessage"), resultSet.getDate("datepost").toLocalDate()));
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return message;
		}
	
	
	public void addMessage(Message newMessage) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO message(idMessage, textMessage, datepost) VALUES (?,?,?)")) {
			statement.setString(1, newMessage.getTexteMessage());
			statement.setDate(2,Date.valueOf(newMessage.getDatePost()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}