package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFenetreExtensionGuitarHero extends Control implements ActionListener {

    public ControlFenetreExtensionGuitarHero(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreExtensionGuitarHero(this);
    }


    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                fenetre.panelFenetreExtensionGuitarHero = null;
                fenetre.redeclareFenetreExtensionStroop();
                changerVue();
                break;
        }
    }
}
