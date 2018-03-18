package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlFenetreExtensionStroop extends Control implements ActionListener {

    public ControlFenetreExtensionStroop(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreExtensionStroop(this);
    }

    public void actionPerformed(ActionEvent e) {

    }
}