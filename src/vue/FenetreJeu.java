package vue;

import controleur.ControlFenetreJeu;
import controleur.ControlFenetreRegles;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;

public class FenetreJeu extends JPanel {

    public static final int NOMBRE_DE_SLOT_FENETRE_CHARGER = 3;

    private Jeu jeu;
    private Font taillePolice;
    private int posX = 0;
    private int posY = 0;
    public JButton tabSlot[];
    public Bouton retour;
    private Image imageFenetreJeu;
    public FenetreJeu() {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        taillePolice = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);
    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
        retour.addActionListener(controlFenetreJeu);

    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);
       
        g.setColor(Color.white);
        g.fillOval(this.getWidth()/2-25, this.getHeight()/2-25, 50, 50);
    }
}