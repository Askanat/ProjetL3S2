package controleur;

import model.Jeu;
import vue.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlMenuEnJeu extends Control implements ActionListener {

    protected ControlMenuEnJeu(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuEnJeu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Retour":
                jeu.getEtat().setPause(false);
                fenetre.layeredPane.removeAll();
                fenetre.setContentPane(fenetre.panelScrollFenetreJeu);
                changerVue();
                break;
            case "Option":
                Control.enPartie = false;
                fenetre.layeredPane.removeAll();
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Retour au Menu Principal":
                jeu.getEtat().setTemps(0);
                fenetre.layeredPane.removeAll();

                Control.enPartie = false;
                jeu.getEtat().setPause(false);
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
            case "Retour Au Bureau":
                System.exit(0);
                break;
        }
    }
}