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
               fenetre.jouerMusiqueFin();
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
            case "Crédits":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelFenetreCredits);
                changerVue();
                break;
            case "Stroop":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelFenetreExtensionStroop);
                fenetre.tempsExtension();
                changerVue();
                break;
            case "Quitter":
                System.exit(0);
                break;
        }
    }
}