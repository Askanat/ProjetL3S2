package model;
import vue.FenetreJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Bille extends JPanel {

    protected Color couleur;
    protected Color couleurTab[] = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};
    protected int score;

    Ellipse2D ellipse = new Ellipse2D.Double(300-25, 900-50, 60, 60);
    Area areaA ;
    public Bille(){
        score = 0;
        couleur = Color.WHITE;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        areaA = new Area(ellipse);
       // g2d.draw(areaA);
    }
    public void nouvellePosition (int posX, int posY){
        ellipse = new Ellipse2D.Double(posX, posY, 50, 50);
    }

    public boolean testIntersection(Area areaA) {
        areaA.intersect(this.areaA);
        return !areaA.isEmpty();
    }

    public void changementCouleurBille(Bille bille) {
        Random rand = new Random();
        int val =rand.nextInt(4);
        while (bille.couleur == couleurTab[val]) {
            val = rand.nextInt(4);
        }
        bille.couleur= couleurTab[val];
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