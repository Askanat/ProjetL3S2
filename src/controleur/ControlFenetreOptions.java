package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlFenetreOptions extends Control implements ActionListener, KeyListener {
    private ControlClavier controlClavier;
    private boolean[] toucheSelectionne;


    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre, ControlClavier controlClavier) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);

        this.controlClavier = controlClavier;

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                if (!jeu.getEtat().getPause()) {
                    fenetre.jouerMusiqueBouton();
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                } else {
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                    fenetre.vueMenuEnJeu();
                }
                break;
            case "Mute":
                fenetre.mute = true;
                break;

            case "Play":
                fenetre.mute = false;
                fenetre.jouerMusiqueMenu();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}