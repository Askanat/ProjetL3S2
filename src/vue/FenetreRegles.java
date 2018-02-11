package vue;

import controleur.ControlFenetreRegles;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;

public class FenetreRegles extends JPanel {

    public static final int NOMBRE_DE_SLOT_FENETRE_CHARGER = 3;

    private Jeu jeu;

    private Image imageFenetreRegles;
    private Font taillePolice;

    public JButton tabSlot[];
    public Bouton retour;

    public FenetreRegles() {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreRegles = getToolkit().getImage("images/menuPrincipale.jpg");
        taillePolice = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);
    }

    public void setControl(ControlFenetreRegles controlFenetreRegles) {
        retour.addActionListener(controlFenetreRegles);
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreRegles, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        retour.setBorder(null);

    }
}