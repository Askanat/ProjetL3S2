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
    private int defilementY = -1;
    private int defilementX = 0;
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
            Image imgR = ImageIO.read(new File("images\\rectangleRouge.png"));
            Image imgB = ImageIO.read(new File("images\\rectangleBleu.png"));
            Image imgV = ImageIO.read(new File("images\\rectangleVert.png"));
            Image imgJ = ImageIO.read(new File("images\\rectangleJaune.png"));
            Image imgCR = ImageIO.read(new File("images\\cercleRouge.png"));
            Image imgCB = ImageIO.read(new File("images\\cercleBleu.png"));
            Image imgCJ = ImageIO.read(new File("images\\cercleJaune.png"));
            Image imgCV = ImageIO.read(new File("images\\cercleVert.png"));

           if (defilementY > -200 && choixFigure[0]) {
               // Les barres horizontales
               g.drawImage(imgR, 0 - defilementY * 2, defilementY, this);
               g.drawImage(imgB, 200 - defilementY * 2, defilementY, this);
               g.drawImage(imgV, 400 - defilementY * 2, defilementY, this);
               g.drawImage(imgJ, 600 - defilementY * 2, defilementY, this);
               g.drawImage(imgB, 800 - defilementY * 2, defilementY, this);
               g.drawImage(imgR, 1000 - defilementY * 2, defilementY, this);
               g.drawImage(imgV, 1200 - defilementY * 2, defilementY, this);
               g.drawImage(imgJ, 1400 - defilementY * 2, defilementY, this);
               g.drawImage(imgR, 1600 - defilementY * 2, defilementY, this);
               g.drawImage(imgV, 1800 - defilementY * 2, defilementY, this);
               g.drawImage(imgB, 2000 - defilementY * 2, defilementY, this);
               g.drawImage(imgJ, 2200 - defilementY * 2, defilementY, this);
           }

            Graphics2D g2d = (Graphics2D)g;
            AffineTransform old = g2d.getTransform();
            if (defilementY > -200 && choixFigure[1]) {
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
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2, defilementY);
                g2d.drawImage(imgR, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.setTransform(old2);
                g2d.drawImage(imgB, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2, + defilementY);
                g2d.drawImage(imgV, this.getWidth() / 2 - 100,  defilementY - 100, this);
                g2d.setTransform(old2);
                g2d.drawImage(imgJ, this.getWidth() / 2 - 100, defilementY - 100, this);
            }

            g2d.setTransform(old);

            if (defilementY > -200 && choixFigure[3]) {
                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2 - 100, defilementY);
                // une croix
                g2d.drawImage(imgR, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgB, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgV, this.getWidth() / 2 - 100, defilementY, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgJ, this.getWidth() / 2 - 100, defilementY, this);
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
}