package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFenetreOptions extends Control implements ActionListener {

    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;
        }
    }
}