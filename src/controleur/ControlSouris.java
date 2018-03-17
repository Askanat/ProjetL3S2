package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class ControlSouris extends Control implements MouseMotionListener {

    private int x, y ;

    public ControlSouris(Jeu jeu, Fenetre fenetre){
        super(jeu, fenetre);
        fenetre.setControlSouris(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!fenetre.isClavier()) {
            x = e.getX();
            y = e.getY();
            fenetre.deplacementSouris();
        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
