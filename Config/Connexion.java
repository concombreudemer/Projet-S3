package Config;

import java.sql.*;
//import java.util.Scanner;

public class Connexion {

    public static Connection openConnection(String url){
        Connection co = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			co = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("Il manque le driver mysql.");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à l'url : " + url);
			System.exit(1);
		}
		print("Connecté !");
		return co;
    }
    

    public static Connection openConnection2() { // si mot de passe avec des caractères spéciaux
		Connection co = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Il manque le driver mysql.");
			System.exit(1);
		}
		/*try {
			OracleDataSource ds = new OracleDataSource();
			ds.setDriverType("thin");
			ds.setServerName("projets.iut-orsay.fr");
			ds.setPortNumber(1521);
			ds.setDatabaseName("etudom");
			co = ds.getConnection("saes3-cgelin", "PG/arObPST7m8OFp");
		} // ou les saisir
		catch (SQLException e) {
			System.out.println("Impossible de se connecter à l'url");
			System.exit(1);
		}*/
		return co;
	}
    

    public static void print(String str) {
		System.out.println(str);
	}

    
	public static void print(String req, Connection iut, int val) {
		ResultSet result;
		try {
			result = execRequete(req, iut, 0);
			if (result != null)
				while (result.next()) {
					String affichage = "";
					for (int i = 1; i < val; i++) {
						affichage += result.getString(i) + "\t";
					}
					print(affichage);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
    public static void closeConnection(Connection co) {
		try {
			co.close();
			System.out.println("Connexion fermée!");
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}
	}


    public static ResultSet execRequete(String requete, Connection co, int type) {
		ResultSet res = null;
		try {
			Statement st;
			if (type == 0) {
				st = co.createStatement();
			} else {
				st = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			}
			;
			res = st.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Problème lors de l'exécution de la requete : " + requete);
		}
		;
		return res;
	}

    
    public static void main (String[] args){

    	// Ouverture de la connection
    	
    	String url = "jdbc:mysql://192.70.36.54/saes3-cgelin?user=saes3-cgelin&password=PG/arObPST7m8OFp&zeroDateTimeBehavior=convertToNull";
    
    	Connection proj = openConnection(url);
    
    	// Test recuperation des commandes 
    	
    	int limite = 5;
    	
    	String req = "SELECT *\r\n"
    			+ "FROM Commande\r\n"
    			+ "LIMIT " + limite + "\r\n";
    	
    	print(req, proj, limite);
    	
    	
    	// Fermeture de la connection
    	
    	closeConnection(proj);
    }
}