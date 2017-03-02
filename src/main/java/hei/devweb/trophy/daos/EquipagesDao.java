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

	public void addEquipages(Equipages newEquipages) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO equipages(numeroEquipage, nomEquipage, identifParticipant1, identifParticipant2, descriptionEquipage, photoEquipage) VALUES (?,?,?,?,?,?)")) {
			statement.setInt(1, newEquipages.getNumeroEquipage());
			statement.setString(2, newEquipages.getNomEquipage());
			statement.setString(3, newEquipages.getIdentifParticipant1());
			statement.setString(4, newEquipages.getIdentifParticipant2());
			statement.setString(5, newEquipages.getDescriptionEquipage());
			statement.setString(6, newEquipages.getPhotoEquipage());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEquipage(Integer numeroEquipage){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection(); 
			PreparedStatement statement = connection.prepareStatement("DELETE * FROM equipages WHERE numeroEquipage=?")) {
			
			statement.setInt(1, numeroEquipage);
			statement.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
