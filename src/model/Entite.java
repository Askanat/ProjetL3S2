package model;

import vue.Fenetre;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Entite {


    protected int positionX, positionY;


    protected Color couleur;
    protected Color couleurTab[] = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};
    protected int score;

    public Entite(Color couleur) {
        this.couleur = couleur;
        score = 0;
    }

    public void changementCouleurBille(Entite bille) {
        Random rand = new Random();
        int val =rand.nextInt(4);
        while (bille.couleur == couleurTab[val]) {
             val = rand.nextInt(4);
        }
        bille.couleur= couleurTab[val];
    }

    /* getters setters */
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

