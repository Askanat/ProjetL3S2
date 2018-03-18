package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlClavierExtensionGuitarHero extends Control implements KeyListener {

    public ControlClavierExtensionGuitarHero(Jeu jeu, Fenetre fenetre){
        super(jeu, fenetre);
        fenetre.setControlClavierExtensionGuitarHero(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        /* Lors d'un appuie de la touche la valeur correspondant dans le tableau prend true */
        if (key == KeyEvent.VK_R) {
            fenetre.panelFenetreExtensionGuitarHero.setValidationCouleur(0, true);
        }
        if (key == KeyEvent.VK_B) {
            fenetre.panelFenetreExtensionGuitarHero.setValidationCouleur(1, true);
        }
        if (key == KeyEvent.VK_V) {
            fenetre.panelFenetreExtensionGuitarHero.setValidationCouleur(2, true);
        }
        if (key == KeyEvent.VK_J) {
            fenetre.panelFenetreExtensionGuitarHero.setValidationCouleur(3, true);
        }
        if (key == KeyEvent.VK_ESCAPE) { // Permet de quitter le jeu une fois la partie terminé.
            if (fenetre.panelFenetreExtensionGuitarHero.isArretJeu()) {
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.setFinMusiqueMenu(false);
                fenetre.jouerMusiqueMenu();
                fenetre.redeclareFenetreExtensionGuitarHero();
                changerVue();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
