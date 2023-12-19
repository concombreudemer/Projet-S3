package View;

import javax.swing.*;

public class ConnexionFrame extends JFrame {

    private JPanel PnlConnection, PnlNomPizzeria, PnlIDPizzeria, PnlBoutonValider;

    private JLabel LblExplication, LblNomPizzeria, LblIDPizzeria;

    private JTextField TxfNomPizzeria, TxfIDPizzeria;

    private JButton BtnValider;


    private JPanel createConnexionPanel() {

        // Création des deux panels contenant les TextFields
        PnlNomPizzeria.setLayout(new BoxLayout(PnlNomPizzeria, BoxLayout.X_AXIS));
        PnlIDPizzeria.setLayout(new BoxLayout(PnlIDPizzeria, BoxLayout.X_AXIS));

        // Labels indiquant quelles informations renseigner dans chaque TextField
        LblNomPizzeria.setText("Nom de la pizzeria : ");
        LblIDPizzeria.setText("ID de la pizzeria : ");

        // Initialisation des deux TextFields
        TxfNomPizzeria = new JTextField("", 20);
        TxfIDPizzeria = new JTextField("", 20);

        // Limites de la taille des deux TextFields
        TxfNomPizzeria.setMinimumSize(new Dimension(150, 30));
        TxfNomPizzeria.setMaximumSize(new Dimension(150, 30));
        TxfIDPizzeria.setMinimumSize(new Dimension(150, 30));
        TxfIDPizzeria.setMaximumSize(new Dimension(150, 30));

        // Formation des deux panels
        PnlNomPizzeria.add(LblNomPizzeria);
        PnlNomPizzeria.add(TxfNomPizzeria);
        PnlIDPizzeria.add(LblIDPizzeria);
        PnlIDPizzeria.add(TxfIDPizzeria);

        // Gestion du Bouton et de son panel (Il est dans un panel au cas où un changement dans la structure occurrerait)
        BtnValider.setText("Valider");
        PnlBoutonValider.add(BtnValider);

        // Création de la partie "haute" de la fenêtre
        LblExplication.setText("Bienvenue chez PizzAnanas !\n\nVeuillez vous connecter afin de voir la liste des commandes en attente.");

        // Mise en place dans la fenêtre principale
        PnlConnection.setLayout(new BoxLayout(PnlConnection, BoxLayout.Y_AXIS));
        PnlConnection.add(LblExplication);
        PnlConnection.add(PnlNomPizzeria);
        PnlConnection.add(LblIDPizzeria);
        PnlConnection.add(PnlBoutonValider);
    }

    public ConnexionFrame() {
        // Appeler le constructeur de la classe JFrame
        super("Connection ..."); // Titre de la fenêtre

        // Créatoin du panel
        JPanel panel = createConnexionPanel();

        // Ajout du panel à la frame
        getContentPane().add(panel);

        // Configurer d'autres paramètres de la JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Taille par défaut
        setLocationRelativeTo(null); // Centrer sur l'écran
        setVisible(true);
    }

    public static void main(String[] args) {
        // Créer et afficher la JFrame depuis le thread d'interface utilisateur (EDT)
        SwingUtilities.invokeLater(() -> {
            new ConnexionFrame();
        });
    }

}