package controleur;

import model.Jeu;
import vue.Fenetre;

public class Control {

    public static boolean enPartie;
    Jeu jeu;
    Fenetre fenetre;

    protected Control(Jeu jeu, Fenetre fenetre) {
        this.jeu = jeu;
        this.fenetre = fenetre;

        enPartie = false;
    }

    protected void changerVue() {
        fenetre.repaint();
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.requestFocus();
    }
}