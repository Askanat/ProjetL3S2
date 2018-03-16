package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlClavierExtensionStroop extends Control implements KeyListener{
    private ControlTouche controlTouche;
    String conteneurUneLettre = "";
    String resultat = "";

    public ControlClavierExtensionStroop(Jeu jeu, Fenetre fenetre){
        super(jeu, fenetre);
        fenetre.setControlClavierExtensionStroop(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        char lettre = e.getKeyChar();

        conteneurUneLettre = conteneurUneLettre + lettre;

        if(conteneurUneLettre.matches("[a-z]")){
            resultat = resultat + conteneurUneLettre;
        }

        if (key == KeyEvent.VK_ENTER) {
            switch (resultat) {
                case "jaune":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[0]) {
                        fenetre.deplacementClavierExtensionStroop(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtensionStroop();
                    }
                    else{
                        fenetre.deplacementClavierExtensionStroop(false);
                        fenetre.changerMotExtensionStroop();
                    }
                    resultat = "";
                    break;
                case "vert":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[1]) {
                        fenetre.deplacementClavierExtensionStroop(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtensionStroop();
                    }
                    else{
                        fenetre.deplacementClavierExtensionStroop(false);
                        fenetre.changerMotExtensionStroop();
                    }
                    resultat = "";
                    break;
                case "rouge":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[2]) {
                        fenetre.deplacementClavierExtensionStroop(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtensionStroop();
                    }
                    else{
                        fenetre.deplacementClavierExtensionStroop(false);
                        fenetre.changerMotExtensionStroop();
                    }
                    resultat = "";
                    break;
                case "bleu":
                    if (fenetre.panelFenetreExtensionStroop.getMotTab()[3]) {
                        fenetre.deplacementClavierExtensionStroop(true);
                        fenetre.panelFenetreExtensionStroop.setScore(fenetre.panelFenetreExtensionStroop.getScore()+1);
                        fenetre.changerMotExtensionStroop();
                    }
                    else{
                        fenetre.deplacementClavierExtensionStroop(false);
                        fenetre.changerMotExtensionStroop();
                    }

                    resultat = "";
                    break;

                    default:
                        fenetre.deplacementClavierExtensionStroop(false);
                        fenetre.changerMotExtensionStroop();
                        resultat = "";
            }
        }
        if(key == KeyEvent.VK_BACK_SPACE){ // pour effacer
            resultat = "";
        }
        conteneurUneLettre = "";
        if (key == KeyEvent.VK_ESCAPE){
            if(fenetre.panelFenetreExtensionStroop.isArretJeu()){
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.setFinMusiqueMenu(false);
                fenetre.jouerMusiqueMenu();
                fenetre.redeclareFenetreExtensionStroop();
                changerVue();
            }


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
