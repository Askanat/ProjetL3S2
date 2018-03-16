package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlFenetreExtensionStroop extends Control implements ActionListener {

    public ControlFenetreExtensionStroop(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreExtension(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.panelFenetreExtensionStroop = null;
                fenetre.redeclareFenetreExtension();
                changerVue();
                break;
        }
    }
}