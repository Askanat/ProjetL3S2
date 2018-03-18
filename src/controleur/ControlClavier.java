package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlClavier extends Control implements KeyListener {

    private ControlTouche controlTouche;

    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);
        controlTouche = new ControlTouche();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_C){ // pour changer entre clavier/souris
            fenetre.panelFenetreJeu.setGraviter(false);
            if(fenetre.isClavier()) { // permet de replacer le bille sur la souris
                fenetre.setClavier(false);
                fenetre.panelFenetreJeu.setPosY(900 + 9 - fenetre.getSouris().getY());
                fenetre.panelFenetreJeu.setPosX(300 + 7 - fenetre.getSouris().getX());
            }
            else{ // permet de replacer le bille en bas au milieu
                fenetre.setClavier(true);
                fenetre.panelFenetreJeu.setPosY(0);
                fenetre.panelFenetreJeu.setPosX(0);
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {// Pour quitter le jeu une fois celui-ci terminé
            if (fenetre.panelFenetreJeu.isArretJeu()) {
                fenetre.setClavier(true);
                fenetre.setContentPane(fenetre.panelFenetreScore);
                fenetre.setFinMusiqueMenu(false);
                fenetre.jouerMusiqueMenu();
                fenetre.redeclareFenetreJeu();
                changerVue();
            }
        }

        if(fenetre.isClavier()) {
            if (key == KeyEvent.VK_SPACE) { // Pour deplacer la bille
                if(!fenetre.panelFenetreJeu.isGraviter()){ // lance la graviter la 1er fois que l'on appuie
                    fenetre.panelFenetreJeu.setGraviter(true);
                }
                fenetre.deplacementClavier();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}