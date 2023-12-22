import java.sql.*;
import java.util.Scanner;
import oracle.jdbc.pool.OracleDataSource;

public class Connexion {

    public static Connection openConnection(String url){
        Connection co = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("il manque le driver mysql");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("impossible de se connecter à l'url : " + url);
			System.exit(1);
		}
		print("Connecté !");
		return co;
    }

    public static Connection openConnection2() { // si mot de passe avec des caractères spéciaux
		Connection co = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		try {
			OracleDataSource ds = new OracleDataSource();
			ds.setDriverType("thin");
			ds.setServerName("oracle.iut-orsay.fr");
			ds.setPortNumber(1521);
			ds.setDatabaseName("etudom");
			co = ds.getConnection("toto", "mdpToto");
		} // ou les saisir
		catch (SQLException e) {
			System.out.println("impossible de se connecter à l'url");
			System.exit(1);
		}
		return co;
	}











}