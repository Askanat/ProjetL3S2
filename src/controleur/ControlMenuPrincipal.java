package controleur;

import javazoom.jl.decoder.JavaLayerException;
import model.Jeu;
import model.Mp3;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenuPrincipal extends Control implements ActionListener {

    public ControlMenuPrincipal(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlMenuPrincipal(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nouvelle Partie":
                fenetre.setContentPane(fenetre.panelFenetreJeu);

                fenetre.formeDefilement();
               fenetre.jouerMusique();
                changerVue();
                break;
            case "Règles":
                fenetre.setContentPane(fenetre.panelFenetreRegles);
                changerVue();
                break;
            case "Options":
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Crédits":
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                changerVue();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}