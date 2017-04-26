package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Equipages;
import hei.devweb.trophy.pojos.Evenements;


public class EvenementsDaoTestCase {
	
	private EvenementsDao eventsDao = new EvenementsDao();

	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM evenements");
			statement.executeUpdate("INSERT INTO evenements(idEvent,dateEvent,event) VALUES (1,'2017-01-14','descritpiton evenement 1')");
			statement.executeUpdate("INSERT INTO evenements(idEvent,dateEvent,event) VALUES (2,'2017-04-19','descritpiton evenement 2')");
		}
	}
	
	@Test
	public void shouldListEvenements() throws Exception {
		//WHEN
		List<Evenements> events = eventsDao.listEvenements();
		//THEN
		Assertions.assertThat(events).hasSize(2);
		Assertions.assertThat(events).extracting("idEvent","dateEvent","event").containsOnly(
				Assertions.tuple(1,"2017-01-14","descritpiton evenement 1"),
				Assertions.tuple(2,"2017-04-19","descritpiton evenement 2")
				);
	}
	
	@Test
	public void shouldAddEvenements() throws Exception {
		Evenements eventstoAdd = new Evenements(5, "2017-04-08", "Ceci est un test");
		//WHEN
		eventsDao.addEvenements(eventstoAdd);
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM evenements WHERE idEvent=5")) {
			Assertions.assertThat(resultSet.next()).isTrue();
			Assertions.assertThat(resultSet.getInt("idEvent")).isNotNull();
			Assertions.assertThat(resultSet.getDate("dateEvent")).isEqualTo("2017-04-08");
			Assertions.assertThat(resultSet.getString("identifParticipant1")).isEqualTo("Ceci est un test");
			Assertions.assertThat(resultSet.next()).isFalse();
			
		}
	}
	
	@Test
	public void shouldDeleteEvenements() throws Exception {
		// GIVEN
		Evenements event1 = new Evenements(5, "2017-04-08", "Ceci est un test");
		// WHEN
		eventsDao.deleteEvenements(event1);
		List<Evenements> listEvent = eventsDao.listEvenements();
		//THEN
		Assertions.assertThat(listEvent).hasSize(2);
	}
}
