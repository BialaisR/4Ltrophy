package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Photos;
import hei.devweb.trophy.pojos.Utilisateur;

public class UtilisateurDaoTestCase {
	
	private UtilisateurDao utilisateurDao = new UtilisateurDao();

	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM utilisateur");
			statement.executeUpdate("INSERT INTO utilisateur(identifiant,motDePasse,nom,prenom,mail,nbMessagesForum,dateInscription,participant,photo,classe,admin) VALUES ('identifiant1','12345','Surmont','Maxime','maxime.surmont@hei.yncrea.fr',5,'2017-03-13',false,'photo 1','H44',false)");
			statement.executeUpdate("INSERT INTO utilisateur(identifiant,motDePasse,nom,prenom,mail,nbMessagesForum,dateInscription,participant,photo,classe,admin) VALUES ('identifiant2','abcde','Barda','Nicolas','nicolas.barda@hei.yncrea.fr',46,'2017-01-25',false,'photo 8','H44',false)");
		}
	}
	
	@Test
	public void shouldListUtilisateur() throws Exception {
		//WHEN
		List<Utilisateur> utilisateur = utilisateurDao.listUtilisateur();
		//THEN
		Assertions.assertThat(utilisateur).hasSize(2);
		Assertions.assertThat(utilisateur).extracting("identifiant", "motDePasse", "nom", "prenom", "mail", "nbMessagesForum", "dateInscription", "participant", "photo", "classe", "admin").containsOnly(
				Assertions.tuple("identifiant1","12345","Surmont","Maxime","maxime.surmont@hei.yncrea.fr",5,"2017-03-13",false,"photo 1","H44",false),
				Assertions.tuple("identifiant2","abcde","Barda","Nicolas","nicolas.barda@hei.yncrea.fr",46,"2017-01-25",false,"photo 8","H44",false)
				);
	}
	
	
	
	@Test
	public void shouldAddUtilisateur() throws Exception {
		
		//WHEN
				utilisateurDao.addUtilisateur("identifiant3","motDePasse","Donque","Julien","julien.donque@hei.yncrea.fr",46,"2017-01-25",true,"photo 8","H44",false);
				//THEN
				List<Utilisateur> utilisateurs = utilisateurDao.listUtilisateur();
				Assertions.assertThat(utilisateurs).hasSize(3);
			
	}
	
	@Test
	public void shouldDeleteUtilisateur() throws Exception {
		// GIVEN
		Utilisateur user1 = new Utilisateur("identifiant3","motDePasse","Donque","Julien","julien.donque@hei.yncrea.fr",46,"2017-01-25",true,"photo 8","H44",false);
		// WHEN
		utilisateurDao.deleteUtilisateur("identifiant3");
		List<Utilisateur> listUtilisateur = utilisateurDao.listUtilisateur();
		//THEN
		Assertions.assertThat(listUtilisateur).hasSize(2);
	}

}
