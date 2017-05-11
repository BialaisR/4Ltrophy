package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Evenements;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class EvenementsDaoTestCase {
	
	private EvenementsDao eventsDao = new EvenementsDao();
	
	/* On définit une entrée initiale dans la table */

	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM evenements");
			statement.executeUpdate("INSERT INTO evenements(idEvent,dateEvent,event) VALUES (1,'2017-01-14','descritpiton evenement 1')");
			statement.executeUpdate("INSERT INTO evenements(idEvent,dateEvent,event) VALUES (2,'2017-04-19','descritpiton evenement 2')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
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
	
	/* On teste que la nouvelle taille est bien de 1 de plus que la taille initiale après ajout */
	
	@Test
	public void shouldAddEvenements() throws Exception {
		//WHEN
		eventsDao.addEvenements(5, "2017-04-08", "Ceci est un test");
		//THEN
		List<Evenements> event = eventsDao.listEvenements();
		Assertions.assertThat(event).hasSize(3);
			
		
	}

	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteEvenements() throws Exception {
		// GIVEN
		Evenements event1 = new Evenements(5, "2017-04-08", "Ceci est un test");
		// WHEN
		eventsDao.deleteEvenements(5);
		List<Evenements> listEvent = eventsDao.listEvenements();
		//THEN
		Assertions.assertThat(listEvent).hasSize(2);
	}
}
