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
    public Bouton retour;
    private Image imageFenetreJeu;
    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
       retour.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);

        g.setColor(Color.white);
        g.fillOval(this.getWidth()/2-25-posX, this.getHeight()-50-posY, 50, 50);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}