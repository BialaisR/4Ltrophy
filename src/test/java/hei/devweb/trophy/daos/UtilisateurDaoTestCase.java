package hei.devweb.trophy.daos;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hei.devweb.trophy.pojos.Utilisateur;


/* Cette classe permet de tester les différentes méthodes créées dans les dao
 * en testant l'interaction avec la base de donnée
 */

public class UtilisateurDaoTestCase {
	
	private UtilisateurDao utilisateurDao = new UtilisateurDao();
	
	/* On définie une entrée initiale dans la table */

	@Before
	public void initDatabase() throws Exception{
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement()){
			statement.executeUpdate("DELETE FROM utilisateur");
			statement.executeUpdate("INSERT INTO utilisateur(idUser,nom,prenom,mail,photo,classe,identif) VALUES (1,'Surmont','Maxime','maxime.surmont@hei.yncrea.fr','photo 1','H44','SurmontMaximeH44')");
			statement.executeUpdate("INSERT INTO utilisateur(idUser,nom,prenom,mail,photo,classe,identif) VALUES (2,'Barda','Nicolas','nicolas.barda@hei.yncrea.fr','photo 8','H44','BardaNicolasH44')");
		}
	}
	
	/* On teste que l'affichage correspond à ce que l'on a rentré */
	
	@Test
	public void shouldListUtilisateur() throws Exception {
		//WHEN
		List<Utilisateur> utilisateur = utilisateurDao.listUtilisateur();
		//THEN
		Assertions.assertThat(utilisateur).hasSize(2);
		Assertions.assertThat(utilisateur).extracting("idUser", "nom", "prenom", "mail", "photo", "classe","identif").containsOnly(
				Assertions.tuple(2,"Barda","Nicolas","nicolas.barda@hei.yncrea.fr","photo 8","H44","BardaNicolasH44"),
				Assertions.tuple(1,"Surmont","Maxime","maxime.surmont@hei.yncrea.fr","photo 1","H44","SurmontMaximeH44")
				
				);
	}
	
	/* On teste que la nouvelle taille est bien de 1 de plus que la taille initiale après ajout */
	
	@Test
	public void shouldAddUtilisateur() throws Exception {
		
		//WHEN
				utilisateurDao.addUtilisateur(3,"Donque","Julien","julien.donque@hei.yncrea.fr","photo 8","H44");
				//THEN
				List<Utilisateur> utilisateurs = utilisateurDao.listUtilisateur();
				Assertions.assertThat(utilisateurs).hasSize(3);
			
	}
	
	/* On teste que la taille après suppression du nouveau champ est bien égale à la taille initiale */
	
	@Test
	public void shouldDeleteUtilisateur() throws Exception {
		// GIVEN
		Utilisateur user1 = new Utilisateur(3,"Donque","Julien","julien.donque@hei.yncrea.fr","photo 8","H44","DonqueJulien");
		// WHEN
		utilisateurDao.deleteUtilisateur(3);
		List<Utilisateur> listUtilisateur = utilisateurDao.listUtilisateur();
		//THEN
		Assertions.assertThat(listUtilisateur).hasSize(2);
	}

}
