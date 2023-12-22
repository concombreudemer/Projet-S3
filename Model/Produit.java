package Model;

import java.util.ArrayList;

public class Produit {

    int IDProduit;
    String NomProduit;
    double PrixProduit;
    int _nbUtilisations;

    ArrayList<Ingredient> _ingredients;

    public String toString() {
        String str = "\tProduit : " + NomProduit + "\t" + _nbUtilisations + "\n";
        for (int i=0 ; i<_ingredients.size() ; i++){
            str += _ingredients.get(i).toString();
        }
        return str;
    }
}