package vue;

import controleur.ControlFenetreJeu;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;

public class FenetreJeu extends JPanel {

    public static final int NOMBRE_DE_SLOT_FENETRE_CHARGER = 3;


    private Jeu jeu;
    private Font taillePolice;
    private int posX = 0;
    private int posY = 0;
    private int defilementY = -200;
    private int defilementX = 0;
    private int defilementRondChangementCouleur = -1100;

    Boolean choixFigure[] = new Boolean[4] ; // nombre de figures différentes

    private int degree = 0;
    public Bouton retour;
    private Image imageFenetreJeu;
    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));
        for(int i = 0; i< choixFigure.length; i++){
            choixFigure[i] = false;
        }

    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
       //retour.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        // Le rond du joueur
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.white);
        g.fillOval(this.getWidth()/2-25-posX, this.getHeight()-50- posY, 50, 50);

        try {
            Image imgBR = ImageIO.read(new File("images\\rectangleRouge.png"));
            Image imgBB = ImageIO.read(new File("images\\rectangleBleu.png"));
            Image imgBV = ImageIO.read(new File("images\\rectangleVert.png"));
            Image imgBJ = ImageIO.read(new File("images\\rectangleJaune.png"));
            Image imgCR = ImageIO.read(new File("images\\cercleRouge.png"));
            Image imgCB = ImageIO.read(new File("images\\cercleBleu.png"));
            Image imgCJ = ImageIO.read(new File("images\\cercleJaune.png"));
            Image imgCV = ImageIO.read(new File("images\\cercleVert.png"));
            Image imgEtoile = ImageIO.read(new File("images\\etoile.png"));
            Image imgRondChangementCouleur = ImageIO.read(new File("images\\rondChangementCouleur.png"));

            if(defilementRondChangementCouleur > -100){
                g.drawImage(imgRondChangementCouleur, this.getWidth() / 2 - 20, defilementRondChangementCouleur , this);
            }

           if (defilementY > -200 && choixFigure[0]) {
               // Les barres horizontales
               g.drawImage(imgBR, 0 - defilementY * 2, defilementY, this);
               g.drawImage(imgBB, 200 - defilementY * 2, defilementY, this);
               g.drawImage(imgBV, 400 - defilementY * 2, defilementY, this);
               g.drawImage(imgBJ, 600 - defilementY * 2, defilementY, this);
               g.drawImage(imgBB, 800 - defilementY * 2, defilementY, this);
               g.drawImage(imgBR, 1000 - defilementY * 2, defilementY, this);
               g.drawImage(imgBV, 1200 - defilementY * 2, defilementY, this);
               g.drawImage(imgBJ, 1400 - defilementY * 2, defilementY, this);
               g.drawImage(imgBR, 1600 - defilementY * 2, defilementY, this);
               g.drawImage(imgBV, 1800 - defilementY * 2, defilementY, this);
               g.drawImage(imgBB, 2000 - defilementY * 2, defilementY, this);
               g.drawImage(imgBJ, 2200 - defilementY * 2, defilementY, this);
           }

            Graphics2D g2d = (Graphics2D)g;
            AffineTransform old = g2d.getTransform();
            if (defilementY > -200 && choixFigure[1]) {
                g2d.drawImage(imgEtoile, this.getWidth() / 2- 20, defilementY -19, this);
                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2, defilementY);
                // 4 morceaux d'un cercle qui tourne
                g2d.drawImage(imgCJ, this.getWidth() / 2, defilementY, this);//109 = taille de l'image
                g2d.drawImage(imgCV, this.getWidth() / 2 - 109, defilementY, this);
                g2d.drawImage(imgCR, this.getWidth() / 2, defilementY - 109, this);
                g2d.drawImage(imgCB, this.getWidth() / 2 - 109, defilementY - 109, this);

            }
            AffineTransform old2 = g2d.getTransform();

            if (defilementY > -200 && choixFigure[2]){
                //un carré
                g2d.drawImage(imgEtoile, this.getWidth() / 2- 20, defilementY -19, this);
                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2 , defilementY);
                g2d.drawImage(imgBB, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.drawImage(imgBJ, this.getWidth() / 2 - 100, defilementY - 100, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2, defilementY);
                g2d.drawImage(imgBR, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.rotate((Math.toRadians(360)), this.getWidth() / 2, + defilementY);
                g2d.drawImage(imgBV, this.getWidth() / 2 - 100,  defilementY - 100, this);
                g2d.setTransform(old2);

            }

            g2d.setTransform(old);

            if (defilementY > -200 && choixFigure[3]) {
                g2d.drawImage(imgEtoile, this.getWidth() / 2- 20, defilementY -19, this);
                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2 - 100, defilementY);
                // une croix
                g2d.drawImage(imgBR, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBB, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBV, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBJ, this.getWidth() / 2 - 100, defilementY, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters Setters
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getDefilementY() {
        return defilementY;
    }

    public void setDefilementY(int defilementY) {
        this.defilementY = defilementY;
    }
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    public int getDefilementX() {
        return defilementX;
    }

    public void setDefilementX(int defilementX) {
        this.defilementX = defilementX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getDefilementRondChangementCouleur() {
        return defilementRondChangementCouleur;
    }

    public void setDefilementRondChangementCouleur(int defilementRondChangementCouleur) {
        this.defilementRondChangementCouleur = defilementRondChangementCouleur;
    }
}