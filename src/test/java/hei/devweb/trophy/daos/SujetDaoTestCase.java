package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Sujet;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */


public class SujetDaoTestCase {
	
	private SujetDao sujetDao = new SujetDao();
	
	/* On définie une entrée initiale dans la table */
	
	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM sujet");
			statement.executeUpdate("INSERT INTO sujet(idSujet,nomSujet,identifiantCreateur,dateLastPost,nbMessage,identifiantLastPost) VALUES (1,'Sujet1','Toto','2017-04-15',4,'Momo')");
			statement.executeUpdate("INSERT INTO sujet(idSujet,nomSujet,identifiantCreateur,dateLastPost,nbMessage,identifiantLastPost) VALUES (2,'Sujet2','Phil','2017-03-02',2,'Jean')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
	
	@Test
	public void shouldListSujet() throws Exception {
		//WHEN
		List<Sujet> sujets = sujetDao.listSujet();
		//THEN
		Assertions.assertThat(sujets).hasSize(2);
		Assertions.assertThat(sujets).extracting("idSujet", "nomSujet", "identifiantCreateur", "dateLastPost", "nbMessage", "identifiantLastPost").containsOnly(
				Assertions.tuple(2,"Sujet2","Phil","2017-03-02",2,"Jean"),
				Assertions.tuple(1,"Sujet1","Toto","2017-04-15",4,"Momo")
				
				);
	}   
	
	/* On teste que la nouvelle taille est bien de 1 de plus que la taille initiale après ajout */
	
	@Test
	public void shouldAddSujet() throws Exception {
		//WHEN
		sujetDao.addSujet(3, "Sujet3","Jacques","2017-02-18",8,"Momo");
		//THEN
		List<Sujet> sujets = sujetDao.listSujet();
		Assertions.assertThat(sujets).hasSize(3);
	}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteSujet() throws Exception {
		// GIVEN
		Sujet sujet1 = new Sujet(3, "Sujet3","Jacques","2017-02-18",8,"Momo");
		// WHEN
		sujetDao.deleteSujet(3);
		List<Sujet> listSujet = sujetDao.listSujet();
		//THEN
		Assertions.assertThat(listSujet).hasSize(2);
	}
	

}
