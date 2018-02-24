package vue;

import controleur.ControlClavier;
import controleur.ControlFenetreJeu;
import controleur.ControlFenetreRegles;
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
    private int degree = 0;
    public Bouton retour;
    private Image imageFenetreJeu;
    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
       //retour.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.white);
        g.fillOval(this.getWidth()/2-25-posX, this.getHeight()-50-posY, 50, 50);


        try { //taille de chaque image est de 200 sur 20
            Image imgR = ImageIO.read(new File("images\\rectangleRouge.png"));
            Image imgB = ImageIO.read(new File("images\\rectangleBleu.png"));
            Image imgV = ImageIO.read(new File("images\\rectangleVert.png"));
            Image imgJ = ImageIO.read(new File("images\\rectangleJaune.png"));
            Image imgCR = ImageIO.read(new File("images\\cercleRouge.png"));
            Image imgCB = ImageIO.read(new File("images\\cercleBleu.png"));
            Image imgCJ = ImageIO.read(new File("images\\cercleJaune.png"));
            Image imgCV = ImageIO.read(new File("images\\cercleVert.png"));
           // barre horizontale
            g.drawImage(imgR, 0-posY*2, 50, this);
            g.drawImage(imgB, 200-posY*2, 50, this);
            g.drawImage(imgV, 400-posY*2, 50, this);
            g.drawImage(imgJ, 600-posY*2, 50, this);
            g.drawImage(imgB, 800-posY*2, 50, this);
            g.drawImage(imgR, 1000-posY*2, 50, this);
            g.drawImage(imgV, 1200-posY*2, 50, this);
            g.drawImage(imgJ, 1400-posY*2, 50, this);
            g.drawImage(imgR, 1600-posY*2, 50, this);
            g.drawImage(imgV, 1800-posY*2, 50, this);


            // un cercle
            /*g.drawImage(imgCR, 600-posY*2, 50, this);
            g.drawImage(imgCB, 491-posY*2, 50, this);
            g.drawImage(imgCJ, 600-posY*2, 159, this);
            g.drawImage(imgCV, 491-posY*2, 159, this);*/
            Graphics2D g2d = (Graphics2D)g;
            AffineTransform old = g2d.getTransform();
            g2d.rotate((Math.toRadians(degree)),this.getWidth()/2+11, this.getHeight()/2-2);
            // 4 morceaux d'un cercle qui tourne
            g2d.drawImage(imgCJ, 491, 268, this);
            g2d.drawImage(imgCV, 382, 268, this);
            g2d.drawImage(imgCR, 491, 159, this);
            g2d.drawImage(imgCB, 382, 159, this);

            AffineTransform old2 = g2d.getTransform();
            // 4 barres pour le carré
            g2d.rotate((Math.toRadians(90)),200, 200);
            g2d.drawImage(imgR, this.getWidth()/2-300, this.getHeight()/2-450, this);
            g2d.setTransform(old2);
            g2d.drawImage(imgB, this.getWidth()/2-100, this.getHeight()/2-90, this);
            g2d.rotate((Math.toRadians(90)),200, 200);
            g2d.drawImage(imgV,this.getWidth()/2-300, this.getHeight()/2-270, this);
            g2d.setTransform(old2);
            g2d.drawImage(imgJ, this.getWidth()/2-100, this.getHeight()/2+90, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}