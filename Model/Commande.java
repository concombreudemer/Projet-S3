package Model;

import java.sql.*;
import java.util.ArrayList;

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
    
    public void getCommandes (Connection proj) {
    	 String req = "SELECT C.IDCommande, C.DateCommande, LC.quantite, P.IDProduit, P.NomProduit, P.PrixProduit, CP.quantite, I.IDIngredient, I.NomProduit\r\n"
    	 		+ "FROM Commande C\r\n"
    	 		+ "NATURAL JOIN LigneCommande LC\r\n"
    	 		+ "NATURAL JOIN Produit P\r\n"
    	 		+ "NATURAL JOIN ComposeProduit CP\r\n"
    	 		+ "NATURAL JOIN Ingredient I\r\n"
    	 		+ "WHERE IDPizzeria = " + Pizzeria.getIDPizzeria()
    	 		+ ""
    	 		+ ""
    	 		+ ""
    	 		+ ""
    	 		+ "";
    	 
    	 v
    	 
    	 
    }
}