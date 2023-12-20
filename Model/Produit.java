package Model;

import java.util.ArrayList;

public class Produit {

    int IDProduit;
    String NomProduit;
    double PrixProduit;

    ArrayList<QuantiteIngredient> _ingredients;

    public String toString() {
        String str = "\tProduit : " + NomProduit + "\n";
        for (int i=0 ; i<_ingredients.size() ; i++){
            str += _ingredients[i].getIngredient().toString();
        }
        return str;
    }
}