package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class JoueurForme extends JPanel {

    protected Color couleur;
    protected Color couleurTab[] = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};
    protected int score;

    Ellipse2D ellipse = new Ellipse2D.Double(300-25, 900-50, 30, 30);
    Area areaA ;
    public JoueurForme(){
        score = 0;
        Random rand = new Random();
        int val =rand.nextInt(4);
        couleur = couleurTab[val];

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        areaA = new Area(ellipse);
       //g2d.draw(areaA);
    }
    public void nouvellePosition (int posX, int posY){
        ellipse = new Ellipse2D.Double(posX, posY, 30, 30);
    }

    public boolean testIntersection(Area areaA) {
        areaA.intersect(this.areaA);
        return !areaA.isEmpty();
    }

    public void changementCouleurBille(JoueurForme joueurForme) {
        Random rand = new Random();
        int val =rand.nextInt(4);
        while (joueurForme.couleur == couleurTab[val]) {
            val = rand.nextInt(4);
        }
        joueurForme.couleur= couleurTab[val];
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}