package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlFenetreExtension extends Control implements ActionListener {

    public ControlFenetreExtension(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreExtension(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}