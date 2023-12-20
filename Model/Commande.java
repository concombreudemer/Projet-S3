package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Commande {

    int IDCommande;
    Date DateCommande;

    ArrayList<QuantiteProduit> _produits;

    public String toString() {
        String str = "Commande : " + IDCommande;
        for (int i=0 ; i<_produits.size() ; i++){
            str += _produits[i].getProduit().toString();
        }
        return str;
    }
}