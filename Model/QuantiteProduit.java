package Model;

public class QuantiteProduit {
    private int _quantite;
    private Produit _produit;

    public Produit getProduit() {
        return _produit;
    }

    public int getQuantite() {
        return _quantite;
    }

    public  void  decrProduit (){
        if (_quantite < 1){
            throw (new IllegalStateException("ERREUR : Impossible de mettre à 0 la quantité d'un ingredient"));
        } else {
            _quantite--;
        }
    }

    public  void  IncrProduit (){
        _quantite++;
    }
}