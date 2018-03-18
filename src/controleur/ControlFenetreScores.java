package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFenetreScores extends Control implements ActionListener {

    public ControlFenetreScores(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlFenetreRegles(this);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                fenetre.jouerMusiqueBouton();
                fenetre.setContentPane(fenetre.panelMenuPrincipal);
                changerVue();
                break;

            case "Ajouter":
                String pseudo = fenetre.panelFenetreScore.pseudoScore.getText();
                int score = jeu.scoreFile.getScore();
                System.out.println(score);
                jeu.scoreFile.writeScore(pseudo, score);
                jeu.scoreFile.orderScore();
                fenetre.panelFenetreScore.updateUI();
                break;
        }
    }
}