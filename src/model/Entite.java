package model;

import vue.Fenetre;

import java.awt.*;

import static java.lang.Math.abs;
import static vue.FenetreJeu.tuileInt;

public class Entite {

    protected String nom, texture, couleur;

    protected int positionX, positionY;
    protected int vecteurDeplacementEnX, vecteurDeplacementEnY, vitesseDeDeplacementEnX, vitesseDeDeplacementEnY, vitesseDeSaut;
    protected int largeurDevant, largeurDerriere, hauteurHaut, hauteurBas;
    protected Direction directionOrientation;

    protected boolean collision, deplacement;

    public Entite(String nom, String texture, String couleur) {

        this.nom = nom;
        this.texture = texture;
        this.couleur = couleur;

        vitesseDeDeplacementEnY = 0;
        vecteurDeplacementEnX = 0;
        vecteurDeplacementEnY = 0;
        directionOrientation = new Direction(Direction.DROITE);

        collision = false;
        deplacement = false;
    }

    public boolean collisionEntite(String nom, String texture, String couleur, String nomB, String textureB, String couleurB){
        Entite enti1 = new Entite(nom,texture,couleur);
        Entite enti2 = new Entite(nom,texture,couleur);

        if(enti1.positionY == enti2.positionY){
            enti1.collision = true;
            enti2.collision = true;
            return true;
        } else {
            return false;
        }
    }

    

}
