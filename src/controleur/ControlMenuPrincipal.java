package controleur;

//import javazoom.jl.decoder.JavaLayerException;
import model.Jeu;
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
                fenetre.setFinMusiqueMenu(true);
                fenetre.formeDefilement();
                fenetre.incrementeDegree();
                fenetre.jouerMusiqueJeu();
                changerVue();
                break;
            case "Scores":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelFenetreScore);
                changerVue();
                break;
            case "Options":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelFenetreOptions);
                changerVue();
                break;
            case "Regles":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelFenetreRegles);
                changerVue();
                break;
            case "Stroop":
                fenetre.jouerMusiqueJeuExtensionStroop();
                fenetre.setFinMusiqueMenu(true);
                fenetre.setContentPane(fenetre.panelFenetreExtensionStroop);
                fenetre.tempsExtensionStroop();
                changerVue();
                break;
            case "GuitarHero":
                fenetre.jouerMusiqueJeuExtensionGuitarHero();
                fenetre.setFinMusiqueMenu(true);
                fenetre.setContentPane(fenetre.panelFenetreExtensionGuitarHero);
                fenetre.formeDefilementExtensionGuitarHero();

                changerVue();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}