package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlFenetreOptions extends Control implements ActionListener, KeyListener {
    private ControlClavier controlClavier;
    private boolean[] toucheSelectionne;


    public ControlFenetreOptions(Jeu jeu, Fenetre fenetre, ControlClavier controlClavier) {
        super(jeu, fenetre);
        fenetre.setControlFenetreOptions(this);

        this.controlClavier = controlClavier;
        this.toucheSelectionne = new boolean[controlClavier.getControlTouche().getNbActions() - 1];

        setTouchesSelectionneesToFalse();
    }

    private void setTouchesSelectionneesToFalse() {
        for(int i = 0; i < toucheSelectionne.length; i++)
            toucheSelectionne[i] = false;
    }

    private int getNumToucheSelectionneTrue()  {
        for(int i = 0; i < toucheSelectionne.length; i++) {
            if(toucheSelectionne[i])
                return i;
        }

        System.out.println();
        return -1;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Retour":
                if (!jeu.getEtat().getPause()) {
                    fenetre.jouerMusiqueBouton();
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                } else {
                    Control.enPartie = true;
                    fenetre.setContentPane(fenetre.panelMenuPrincipal);
                    changerVue();
                    fenetre.vueMenuEnJeu();
                }
                break;
            case "Sauter":
                setTouchesSelectionneesToFalse();
                toucheSelectionne[ControlTouche.ACTION_SAUT - 1] = true;
                break;

            case "Mute":
                fenetre.mute = true;
                break;

            case "Play":
                fenetre.mute = false;
                fenetre.jouerMusiqueMenu();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key;
        if((key = keyEvent.getKeyCode()) != keyEvent.VK_ESCAPE) {
            int index = getNumToucheSelectionneTrue() - 1, actionConcernee;

            actionConcernee = index + 1;

            toucheSelectionne[index] = false;
            controlClavier.getControlTouche().setActionTouche(actionConcernee, key);

            System.out.println(controlClavier.getControlTouche().getNomTouche(actionConcernee));

            /*fenetre.panelFenetreOptions.controlButton[index].
                    setText(controlClavier.getControlTouche().getNomTouche(actionConcernee));*/
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}