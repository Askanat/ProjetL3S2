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
        char lettre = e.getKeyChar();

        if (key == KeyEvent.VK_ENTER) {

        }

        if(key == KeyEvent.VK_BACK_SPACE){ // pour effacer

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
