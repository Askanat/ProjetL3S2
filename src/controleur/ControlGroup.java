package controleur;

import model.Jeu;
import vue.Fenetre;

import java.io.IOException;

public class ControlGroup {

    public Fenetre fenetre;

    public ControlGroup(Jeu jeu) {
        fenetre = new Fenetre(jeu);

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(jeu, fenetre);

        ControlFenetreJeu controlFenetreJeu = new ControlFenetreJeu(jeu, fenetre);
    }
}