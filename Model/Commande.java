package Model;

import java.sql.*;
import java.util.ArrayList;
import Config.Connexion;

public class Commande {

    int IDCommande;
    Date DateCommande;

    ArrayList<Produit> _produits;

    public String toString() {
        String str = "Commande : " + IDCommande;
        for (int i=0 ; i<_produits.size() ; i++){
            str += _produits.get(i).toString();
        }
        return str;
    }
    
    public Commande(int id, Date date, ArrayList<Produit> prod){
    	IDCommande = id;
    	DateCommande = date;
    	_produits = prod;
    }
    
    public void getCommandes (Connection proj, int limite) {
    	 String req = "SELECT C.IDCommande, C.DateCommande, LC.quantite, P.IDProduit, P.NomProduit, P.PrixProduit, CP.quantite, I.IDIngredient, I.NomProduit\r\n"
    	 		+ "FROM Commande C\r\n"
    	 		+ "NATURAL JOIN LigneCommande LC\r\n"
    	 		+ "NATURAL JOIN Produit Pr\r\n"
    	 		+ "NATURAL JOIN ComposeProduit CP\r\n"
    	 		+ "NATURAL JOIN Ingredient I\r\n"
    	 		+ "WHERE IDPizzeria = " + Pizzeria.getIDPizzeria()
    	 		+ "AND IDStatut = 0;";
    	 
    	 Connexion.print(req, proj, limite);
    	 
    	 String update = "UPDATE Commande\r\n"
    	 		+ "    	 SET ID = 1\r\n"
    	 		+ "    	 WHERE ID = 0;\r\n";
    	 
    	 Connexion.print(update, proj, limite);
    	 
    	 
    }
    
    
}


/*
// Méthode pour obtenir une liste de commandes à partir d'un ResultSet
    public List<Commande> getCommandesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Commande> commandes = new ArrayList<>();

        while (resultSet.next()) {
            int idCommande = resultSet.getInt("IDCommande");
            Date dateCommande = resultSet.getDate("DateCommande");

            // Créer une nouvelle commande
            Commande commande = new Commande(idCommande, dateCommande);

            // Ajouter des produits à la commande
            Produit produit = new Produit(
                resultSet.getInt("IDProduit"),
                resultSet.getString("NomProduit"),
                resultSet.getDouble("PrixProduit"),
                new ArrayList<>(), // Liste d'ingrédients (à remplir ultérieurement)
                resultSet.getInt("quantiteProduit")
            );

            // Ajouter des ingrédients au produit
            Ingredient ingredient = new Ingredient(
                resultSet.getInt("IDIngredient"),
                resultSet.getString("NomIngredient"),
                resultSet.getInt("quantiteIngredient")
            );

            produit.getIngredients().add(ingredient);

            // Ajouter le produit à la commande
            commande.getProduits().add(produit);

            // Ajouter la commande à la liste
            commandes.add(commande);
        }

        return commandes;
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("VOTRE_REQUETE_SQL");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            CommandeDAO commandeDAO = new CommandeDAO();
            List<Commande> commandes = commandeDAO.getCommandesFromResultSet(resultSet);

            // Faire quelque chose avec la liste de commandes
            for (Commande commande : commandes) {
                System.out.println("Commande #" + commande.getIDCommande() + ", Date: " + commande.getDateCommande());
                for (Produit produit : commande.getProduits()) {
                    System.out.println("   Produit: " + produit.getNomProduit() + ", Prix: " + produit.getPrixProduit());
                    for (Ingredient ingredient : produit.getIngredients()) {
                        System.out.println("      Ingrédient: " + ingredient.getNomIngredient() + ", Quantité: " + ingredient.getQuantiteIngredient());
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        // Remplacez ceci par votre logique de connexion à la base de données
        return null;
    }
*/