package vue;

import controleur.ControlClavier;
import controleur.ControlFenetreJeu;
import controleur.ControlFenetreRegles;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;

public class FenetreJeu extends JPanel {

    public static final int NOMBRE_DE_SLOT_FENETRE_CHARGER = 3;


    private Jeu jeu;
    private Font taillePolice;
    private int posX = 0;
    private int posY = 0;
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
}