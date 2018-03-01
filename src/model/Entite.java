package model;

import vue.Fenetre;

import java.awt.*;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Entite {



    protected Color couleur;

    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected Direction directionOrientation;

    protected boolean collision, deplacement;
    protected Color couleurTab[] = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};

    public Entite(Color couleur) {

        this.couleur = couleur;

        vitesseDeDeplacementEnY = 0;
        vitesseDeDeplacementEnX = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
        directionOrientation = new Direction(Direction.DROITE);
        vitesseDeSaut = 0;

        collision = false;
        deplacement = false;
    }

    public boolean collisionEntite(Entite enti1, Entite enti2, boolean etoile){
        if (etoile == false) {
            if ((enti1.positionY == enti2.positionY || enti1.positionX == enti2.positionX) && enti1.couleur != enti2.couleur) {
                enti1.collision = true;
                enti2.collision = true;
                return true;
            } else {
                return false;
            }
        } else {
            if (enti1.positionY == enti2.positionY && enti1.positionX == enti2.positionX) {
                enti1.collision = true;
                enti2.collision = true;
                return true;
            } else {
                return false;
            }
        }
    }

    public void changementCouleurBille(Entite bille) {
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
}

