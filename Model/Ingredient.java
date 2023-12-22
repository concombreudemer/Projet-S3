package Model;

public class Ingredient {

    int IDIngredient;
    String NomIngredient;
    int _nbUtilisations;

    public String toString() {
        String str = "\t\tIngrédient : " + NomIngredient + "\tQuantité : " + _nbUtilisations + "\n";
        return str;
    }

    public Ingredient (int id, String nom, int nb) {
    	IDIngredient = id;
    	NomIngredient = nom;
    	_nbUtilisations = nb;
    }
}