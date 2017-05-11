package hei.devweb.trophy.daos;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/* Cette classe permet de faire le lien avec la base de donnée en allant récupérer toutes 
 * les informations necessaires à cette connexion dans le fichier "jbdc.properties"
 * situé dans le dossier "resources"
 */

public class DataSourceProvider {

	private static class DataSourceProviderHolder {
		private final static DataSourceProvider instance = new DataSourceProvider();
	}
	
	public static DataSourceProvider getInstance() {
		return DataSourceProviderHolder.instance;
	}

	private MysqlDataSource dataSource;

	private DataSourceProvider() {
		initDataSource();
	}

	private void initDataSource() {
		Properties jdbcProperties = new Properties();
		InputStream configFileStream = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			jdbcProperties.load(configFileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Ici on récupère les identifiants nécessaires à la connexion */
		
		dataSource = new MysqlDataSource();
		dataSource.setServerName(jdbcProperties.getProperty("servername"));
		dataSource.setPort(Integer.parseInt(jdbcProperties.getProperty("port")));
		dataSource.setDatabaseName(jdbcProperties.getProperty("databasename"));
		dataSource.setUser(jdbcProperties.getProperty("user"));
		dataSource.setPassword(jdbcProperties.getProperty("password"));
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}