package Model;

public class Ingredient {

    int IDIngredient;
    String NomIngredient;

    public void toString() {
        String str = "\t\tIngrédient : " + NomIngredient;
        return str;
    }
}