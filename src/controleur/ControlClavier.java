package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlClavier extends Control implements KeyListener {

    private ControlTouche controlTouche;
    public static boolean toucheEnfoncer[];
    public static boolean toucheRelacher[];


    public ControlClavier(Jeu jeu, Fenetre fenetre) {
        super(jeu, fenetre);
        fenetre.setControlClavier(this);

        controlTouche = new ControlTouche();
        toucheEnfoncer = new boolean[controlTouche.getNbActions()];
        toucheRelacher = new boolean[controlTouche.getNbActions()];

        for (int i = 0; i < toucheEnfoncer.length; i++)
            toucheEnfoncer[i] = false;

        for (int i = 0; i < toucheRelacher.length; i++)
            toucheRelacher[i] = false;
    }

    public ControlTouche getControlTouche() {
        return  controlTouche;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_C){
            fenetre.panelFenetreJeu.setGraviter(false);
           // fenetre.setSourisPosition(0,0);

            if(fenetre.isClavier()) {
                fenetre.setClavier(false);
                fenetre.panelFenetreJeu.setPosY(900 + 9 - fenetre.getSouris().getY());
                fenetre.panelFenetreJeu.setPosX(300 + 7 - fenetre.getSouris().getX());
            }
            else{
                fenetre.setClavier(true);
                fenetre.panelFenetreJeu.setPosY(0);
                fenetre.panelFenetreJeu.setPosX(0);
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (fenetre.panelFenetreJeu.isArretJeu()) {
                fenetre.setClavier(true);
                fenetre.setContentPane(fenetre.panelFenetreScore);
                fenetre.setFinMusiqueMenu(false);
                fenetre.jouerMusiqueMenu();
                // fenetre.panelFenetreJeu = null;
                fenetre.redeclareFenetreJeu();
                changerVue();
            }
        }
        if(fenetre.isClavier()) {
            if (key == KeyEvent.VK_SPACE) {
                if(!fenetre.panelFenetreJeu.isGraviter()){
                    fenetre.panelFenetreJeu.setGraviter(true);
                }
                fenetre.deplacementClavier();
            }
        }
        /*int i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = true;
            i++;
        }

        System.out.println("Touche pressée : " + e.getKeyCode() + " (" + e.getKeyChar() + ")"); // savoir la touche appuyer */
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheEnfoncer[i] = false;
            i++;
        }

        i = 0;
        for (int key : controlTouche.getTouches()) {
            if (e.getKeyCode() == key)
                toucheRelacher[i] = true;
            i++;
        }
    }
}