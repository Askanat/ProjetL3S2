package controleur;

import model.Jeu;
import vue.Fenetre;
import vue.FenetreJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFenetreJeu extends Control implements ActionListener {

    public ControlFenetreJeu(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreJeu(this);
    }

    public void actionPerformed(ActionEvent e) {


        switch (e.getActionCommand()) {
            case "Menu":
                jeu.getEtat().inversePause();

                if (jeu.getEtat().getPause()) {
                    fenetre.vueMenuEnJeu();
                } else {
                    fenetre.layeredPane.removeAll();
                    fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                    changerVue();
                }
                break;

            case "Retour":
                fenetre.setFinMusiqueMenu(false);
                fenetre.jouerMusiqueMenu();
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.panelFenetreJeu = null;
                fenetre.redeclareFenetreJeu();
                changerVue();
                break;

        }
    }
}
