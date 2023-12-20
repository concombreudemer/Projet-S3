package Model;

public class Ingredient {

    int IDIngredient;
    String NomIngredient;
    int nbUtilisations;

    public String toString() {
        String str = "\t\tIngrédient : " + NomIngredient;
        return str;
    }
}