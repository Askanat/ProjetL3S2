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
        ControlFenetreRegles controlFenetreRegles = new ControlFenetreRegles(jeu, fenetre);
        ControlFenetreCredits controlFenetreCredits = new ControlFenetreCredits(jeu, fenetre);
        ControlFenetreExtension  controlFenetreExtension = new ControlFenetreExtension(jeu, fenetre);

        ControlSouris controlSouris = new ControlSouris(jeu, fenetre);
        ControlClavierExtension controlClavierExtension = new ControlClavierExtension(jeu, fenetre);
        ControlClavier controlClavier = new ControlClavier(jeu, fenetre);
        ControlMenuEnJeu controlMenuEnJeu = new ControlMenuEnJeu(jeu, fenetre);

        ControlFenetreOptions controlFenetreOptions = new ControlFenetreOptions(jeu, fenetre, controlClavier);
    }
}