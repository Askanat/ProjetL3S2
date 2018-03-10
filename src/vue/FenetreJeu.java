package vue;

import controleur.ControlFenetreJeu;

import model.Rectangle;
import model.Bille;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import static vue.Fenetre.*;

public class FenetreJeu extends JPanel {

    private Jeu jeu;



    private int posX = 0;
    private int posY = 0;
    private int defilementY = -200;
    private int defilementX = 0;
    private int defilementRondChangementCouleur = -1100;
    private int defilementFigureX =0;
    private boolean etoileUnSeulPointScore = false;
    private boolean rondChangementCouleurUnSeul = false;
    private volatile boolean arretJeu = false;
    Boolean choixFigure[] = new Boolean[4] ; // nombre de figures différentes
    private int degree = 0;
    public Bouton retour, menu;
    private Image imageFenetreJeu;
    //private Entite boule;

    Bille billeJoueur = new Bille();
    Rectangle rectangleRouge = new Rectangle(Color.RED);
    Rectangle rectangleBleu = new Rectangle(Color.BLUE);
    Rectangle rectangleJaune = new Rectangle(Color.YELLOW);
    Rectangle rectangleVert = new Rectangle(Color.GREEN);
    Rectangle rectangleRouge2 = new Rectangle(Color.RED);
    Rectangle rectangleBleu2 = new Rectangle(Color.BLUE);
    Rectangle rectangleJaune2 = new Rectangle(Color.YELLOW);
    Rectangle rectangleVert2 = new Rectangle(Color.GREEN);
    Rectangle etoileRectangle = new Rectangle(Color.WHITE);
    Rectangle rondChangementCouleurRectangle = new Rectangle(Color.WHITE);


    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        for(int i = 0; i< choixFigure.length; i++){
            choixFigure[i] = false;
        }


        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");

        menu = new Bouton("");
        menu.setActionCommand("Menu");

        this.add(retour);
        this.add(menu);
    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
       retour.addActionListener(controlFenetreJeu);
       menu.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        // Le rond du joueur
        // Entite boule = new Entite(Color.WHITE);

        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);
        g.setColor(billeJoueur.getCouleur());
        g.fillOval(this.getWidth()/2-25-posX, this.getHeight()-50- posY, 50, 50);

        billeJoueur.paintComponent(g);
        billeJoueur.nouvellePosition(this.getWidth()/2-25-posX, this.getHeight()-50- posY);


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


            // rond Changement Couleur
                rondChangementCouleurRectangle.nouvellePosition(this.getWidth() / 2 - 20,defilementRondChangementCouleur, 40, 40 );
                rondChangementCouleurRectangle.paintComponents(g);
                if(billeJoueur.testIntersection(rondChangementCouleurRectangle.areaA)){
                    if((billeJoueur.testIntersection(rondChangementCouleurRectangle.areaA)) && (!rondChangementCouleurUnSeul)){
                        billeJoueur.changementCouleurBille(billeJoueur);
                        rondChangementCouleurUnSeul = true;
                    }
                }
                else if(!rondChangementCouleurUnSeul){
                    if(defilementRondChangementCouleur > -100) {
                        g.drawImage(imgRondChangementCouleur, this.getWidth() / 2 - 20, defilementRondChangementCouleur, this);
                    }
                }



           if (defilementY > -200 && choixFigure[0]) { // barres horizontales

               rectangleRouge.nouvellePosition(0-defilementFigureX, defilementY, 200, 20);
               rectangleRouge.paintComponents(g);
               rectangleBleu.nouvellePosition(200-defilementFigureX, defilementY,200, 20);
               rectangleBleu.paintComponents(g);
               rectangleVert.nouvellePosition(400-defilementFigureX, defilementY,200, 20);
               rectangleVert.paintComponents(g);
               rectangleJaune.nouvellePosition(600-defilementFigureX, defilementY,200, 20);
               rectangleJaune.paintComponents(g);
               rectangleRouge2.nouvellePosition(800-defilementFigureX, defilementY,200, 20);
               rectangleRouge2.paintComponents(g);
               rectangleBleu2.nouvellePosition(1000-defilementFigureX, defilementY,200, 20);
               rectangleBleu2.paintComponents(g);
               rectangleVert2.nouvellePosition(1200-defilementFigureX, defilementY,200, 20);
               rectangleVert2.paintComponents(g);
               rectangleJaune2.nouvellePosition(1400-defilementFigureX, defilementY,200, 20);
               rectangleJaune2.paintComponents(g);
               // Les barres horizontales

               g.drawImage(imgBR, 0 - defilementFigureX , defilementY, this);//comptepas
               g.drawImage(imgBB, 200 - defilementFigureX , defilementY, this);
               g.drawImage(imgBV, 400 - defilementFigureX, defilementY, this);
               g.drawImage(imgBJ, 600 - defilementFigureX , defilementY, this);
               g.drawImage(imgBR, 800 - defilementFigureX , defilementY, this);
               g.drawImage(imgBB, 1000 - defilementFigureX , defilementY, this);
               g.drawImage(imgBV, 1200 - defilementFigureX , defilementY, this);
               g.drawImage(imgBJ, 1400 - defilementFigureX , defilementY, this);

              if((billeJoueur.testIntersection(rectangleRouge.areaA) || billeJoueur.testIntersection(rectangleRouge2.areaA))  && (billeJoueur.getCouleur() == Color.RED)){ // attention mixte Entité et Bille
                  retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                  arretJeu =true;
                  g.drawString("Score " + String.valueOf(billeJoueur.getScore()) ,50, 50);
              }
               if((billeJoueur.testIntersection(rectangleBleu.areaA) || billeJoueur.testIntersection(rectangleBleu2.areaA))  && (billeJoueur.getCouleur() == Color.BLUE)){ // attention mixte Entité et Bille
                   retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                   arretJeu =true;
                   g.drawString("Score " + String.valueOf(billeJoueur.getScore()) ,50, 50);
               }
               if((billeJoueur.testIntersection(rectangleVert.areaA) || billeJoueur.testIntersection(rectangleVert2.areaA))  && (billeJoueur.getCouleur() == Color.GREEN)){ // attention mixte Entité et Bille
                   retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                   arretJeu =true;
                   g.drawString("Score " + String.valueOf(billeJoueur.getScore()) ,50, 50);
               }
               if((billeJoueur.testIntersection(rectangleJaune.areaA) || billeJoueur.testIntersection(rectangleJaune2.areaA)) && (billeJoueur.getCouleur() == Color.YELLOW)){ // attention mixte Entité et Bille
                   retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                   arretJeu =true;
                   g.drawString("Score " + String.valueOf(billeJoueur.getScore()) ,50, 50);
               }
           }


            Graphics2D g2d = (Graphics2D)g;
            AffineTransform old = g2d.getTransform();
           if (defilementY > -200 && choixFigure[1]) {

               etoileRectangle.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
               etoileRectangle.paintComponents(g);
               if(billeJoueur.testIntersection(etoileRectangle.areaA)){//collision pour l'étoile

                   if(!etoileUnSeulPointScore) {
                       billeJoueur.setScore(billeJoueur.getScore() + 1);
                       etoileUnSeulPointScore = true;
                   }
               }
               else if(!etoileUnSeulPointScore){
                   g2d.drawImage(imgEtoile, this.getWidth() / 2 - 20, defilementY - 19, this);
               }


                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2, defilementY);
                // 4 morceaux d'un cercle qui tourne
                g2d.drawImage(imgCJ, this.getWidth() / 2, defilementY, this);//109 = taille de l'image
                g2d.drawImage(imgCV, this.getWidth() / 2 - 109, defilementY, this);
                g2d.drawImage(imgCR, this.getWidth() / 2, defilementY - 109, this);
                g2d.drawImage(imgCB, this.getWidth() / 2 - 109, defilementY - 109, this);
                if((posY + 57 + defilementY + 109 >= 900 && posY + 57 + defilementY + 89 <= 900)){
                    if((degree >=0 && degree<=90)&& billeJoueur.getCouleur()== Color.YELLOW){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=90 && degree<=180)&& billeJoueur.getCouleur()== Color.RED){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=180 && degree<=270)&& billeJoueur.getCouleur()== Color.BLUE){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=270 && degree<=360)&& billeJoueur.getCouleur()== Color.GREEN){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                }
                if((posY + 57 + defilementY - 89 >= 900 && posY + 57 + defilementY - 109 <= 900)){
                    if((degree >=0 && degree<=90)&& billeJoueur.getCouleur()== Color.BLUE){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=90 && degree<=180)&& billeJoueur.getCouleur()== Color.GREEN){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=180 && degree<=270)&& billeJoueur.getCouleur()== Color.YELLOW){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                    if((degree >=270 && degree<=360)&& billeJoueur.getCouleur()== Color.RED){
                        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
                        arretJeu =true;
                    }
                }

            }

            AffineTransform old2 = g2d.getTransform();
            if (defilementY > -200 && choixFigure[2]){
                //un carré

                etoileRectangle.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
                etoileRectangle.paintComponents(g);
                if(billeJoueur.testIntersection(etoileRectangle.areaA)){//collision pour l'étoile
                    if(!etoileUnSeulPointScore) {
                        billeJoueur.setScore(billeJoueur.getScore() + 1);
                        etoileUnSeulPointScore = true;
                    }
                }
                else if(!etoileUnSeulPointScore){
                    g2d.drawImage(imgEtoile, this.getWidth() / 2- 20, defilementY -19, this);
                }

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

                etoileRectangle.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
                etoileRectangle.paintComponents(g);
                if(billeJoueur.testIntersection(etoileRectangle.areaA)){//collision pour l'étoile

                    if(!etoileUnSeulPointScore) {
                        billeJoueur.setScore(billeJoueur.getScore() + 1);
                        etoileUnSeulPointScore = true;
                    }
                }
                else if(!etoileUnSeulPointScore){
                    g2d.drawImage(imgEtoile, this.getWidth() / 2 - 20, defilementY - 19, this);
                }

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
    public int getDefilementFigureX() {
        return defilementFigureX;
    }

    public void setDefilementFigureX(int defilementFigureX) {
        this.defilementFigureX = defilementFigureX;
    }

    public boolean isArretJeu() {
        return arretJeu;
    }

    public void setArretJeu(boolean arretJeu) {
        this.arretJeu = arretJeu;
    }
    public boolean isEtoileUnSeulPointScore() {
        return etoileUnSeulPointScore;
    }

    public void setEtoileUnSeulPointScore(boolean etoileUnSeulPointScore) {
        this.etoileUnSeulPointScore = etoileUnSeulPointScore;
    }
    public boolean isRondChangementCouleurUnSeul() {
        return rondChangementCouleurUnSeul;
    }

    public void setRondChangementCouleurUnSeul(boolean rondChangementCouleurUnSeul) {
        this.rondChangementCouleurUnSeul = rondChangementCouleurUnSeul;
    }
}