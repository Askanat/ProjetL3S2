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

    private Jeu jeu;

    private Image imageFenetreRegles;

    public JButton retour;


    public FenetreRegles() {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreRegles = getToolkit().getImage("images/menuPrincipale.jpg");

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
    }
}