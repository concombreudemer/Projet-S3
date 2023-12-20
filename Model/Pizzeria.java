package Model;

import java.util.ArrayList;

public class Pizzeria {

    int IDPizzeria;
    ArrayList<Commande> _commandes;

    public void retirerCommande (int indice) {
        try {
            _commandes.remove(indice);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("ERREUR : Pas d'objet à cet indice !");
        }
    }
    
}