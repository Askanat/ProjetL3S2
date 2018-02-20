package vue;
import controleur.ControlMenuEnJeu;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

/**
 * Created by Florian Vaissiere on 06/10/2016.
 */

public class MenuEnJeu extends JPanel {

    private Image imageMenuEnJeu;

    public Button retourJeu, option, retourMenuPrincipal, retourBureau;

    public MenuEnJeu() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X / 2, Y / 2));
        this.setOpaque(false);

        imageMenuEnJeu = getToolkit().getImage("images/menuPause.png");

        retourJeu = new Button("Retour au Jeu");
        retourJeu.setActionCommand("Retour");
        option = new Button("Options");
        option.setActionCommand("Option");
        retourMenuPrincipal = new Button("Mennu Principal");
        retourMenuPrincipal.setActionCommand("Retour au Menu Principal");
        retourBureau = new Button("Retour Bureau");
        retourBureau.setActionCommand("Retour Au Bureau");

        this.add(retourJeu);
        this.add(option);
        this.add(retourMenuPrincipal);
        this.add(retourBureau);
    }

    public void setControl(ControlMenuEnJeu controlMenuEnJeu) {
        retourJeu.addActionListener(controlMenuEnJeu);
        option.addActionListener(controlMenuEnJeu);
        retourMenuPrincipal.addActionListener(controlMenuEnJeu);
        retourBureau.addActionListener(controlMenuEnJeu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageMenuEnJeu, 0, 0, getWidth(), getHeight(), this);

        retourJeu.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(92), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));

        option.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(293), Fenetre.adapterResolutionEnX(379), Fenetre.adapterResolutionEnY(55));

        retourMenuPrincipal.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(358), Fenetre.adapterResolutionEnX(379), Fenetre.adapterResolutionEnY(55));

        retourBureau.setBounds(Fenetre.adapterResolutionEnX(289), Fenetre.adapterResolutionEnY(426), Fenetre.adapterResolutionEnX(378), Fenetre.adapterResolutionEnY(55));

    }
}