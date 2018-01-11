package controleur;

import model.Jeu;
import vue.Fenetre;

import java.io.IOException;

/**
 * Created by bastien on 28/09/16.
 */

public class ControlGroup {

    public Fenetre fenetre;

    public ControlGroup(Jeu jeu) {
        fenetre = new Fenetre(jeu);

        ControlMenuPrincipal controlMenuPrincipal = new ControlMenuPrincipal(jeu, fenetre);

        ControlFenetreJeu controlFenetreJeu = new ControlFenetreJeu(jeu, fenetre);
    }
}