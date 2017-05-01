package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.trophy.pojos.Equipages;

public class EquipagesDao {

	public List<Equipages> listEquipages() {
		List<Equipages> equipage = new ArrayList<Equipages>();

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM equipages ORDER BY numeroEquipage ASC")) {
			while (resultSet.next()) {
				equipage.add(new Equipages(resultSet.getInt("numeroEquipage"), resultSet.getString("nomEquipage"),
						resultSet.getString("identifParticipant1"), resultSet.getString("identifParticipant2"),
						resultSet.getString("descriptionEquipage"), resultSet.getString("photoEquipage")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipage;
	}

	public void addEquipages(int numeroEquipage, String nomEquipage, String identifParticipant1, String identifParticipant2, String descriptionEquipage, String photoEquipage) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO equipages(numeroEquipage, nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage) VALUES (?,?,?,?,?,?)")) {
			statement.setInt(1, numeroEquipage);
			statement.setString(2, nomEquipage);
			statement.setString(3, identifParticipant1);
			statement.setString(4, identifParticipant2);
			statement.setString(5, descriptionEquipage);
			statement.setString(6, photoEquipage);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
