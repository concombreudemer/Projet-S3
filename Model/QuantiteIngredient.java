package Model;

public class QuantiteIngredient {
    private int _quantite;
    private Ingredient _ingredient;

    public Ingredient getIngredient (){
        return _ingredient;
    }

    public int getQuantite () {
        return _quantite;
    }

    public  void  decrIngredient (){
        if (_quantite < 1){
            throw (new IllegalStateException("ERREUR : Impossible de mettre à 0 la quantité d'un ingredient"));
        } else {
            _quantite--;
        }
    }

    public  void  IncrIngredient (){
        _quantite++;
    }


}