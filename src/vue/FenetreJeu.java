package vue;

import controleur.ControlFenetreJeu;

import model.ArcForme;
import model.RectangleForme;
import model.JoueurForme;
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
    private boolean arretJeu = false;
    Boolean choixFigure[] = new Boolean[4] ; // nombre de figures différentes
    private int degree = 0;
    public Bouton retour, menu;
    private Image imageFenetreJeu;

    JoueurForme bille = new JoueurForme();
    RectangleForme rectangleFormeRouge = new RectangleForme(Color.RED);
    RectangleForme rectangleFormeBleu = new RectangleForme(Color.BLUE);
    RectangleForme rectangleFormeJaune = new RectangleForme(Color.YELLOW);
    RectangleForme rectangleFormeVert = new RectangleForme(Color.GREEN);
    RectangleForme rectangleFormeRouge2 = new RectangleForme(Color.RED);
    RectangleForme rectangleFormeBleu2 = new RectangleForme(Color.BLUE);
    RectangleForme rectangleFormeJaune2 = new RectangleForme(Color.YELLOW);
    RectangleForme rectangleFormeVert2 = new RectangleForme(Color.GREEN);
    RectangleForme etoileRectangleForme = new RectangleForme(Color.WHITE);
    RectangleForme rondChangementCouleurRectangleForme = new RectangleForme(Color.WHITE);

    ArcForme arcFormeRouge = new ArcForme(Color.RED);
    ArcForme arcFormeBleu = new ArcForme(Color.BLUE);
    ArcForme arcFormeJaune = new ArcForme(Color.YELLOW);
    ArcForme arcFormeVert = new ArcForme(Color.GREEN);

    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;
        imageFenetreJeu = getToolkit().getImage("images\\espace.jpg");
        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        for(int i = 0; i< choixFigure.length; i++){
            choixFigure[i] = false;
        }

        menu = new Bouton("");
        menu.setActionCommand("Menu");

        this.add(menu);
    }

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
       menu.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        // Le rond du joueur
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);
        g.setColor(bille.getCouleur());
        g.fillOval(this.getWidth()/2-25-posX, this.getHeight()-50- posY, 50, 50);
        Graphics2D g2d = (Graphics2D)g;
        bille.paintComponent(g);
        bille.nouvellePosition(this.getWidth()/2-25-posX, this.getHeight()-50- posY);


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
                rondChangementCouleurRectangleForme.nouvellePosition(this.getWidth() / 2 - 20,defilementRondChangementCouleur, 40, 40 );
                rondChangementCouleurRectangleForme.paintComponents(g);
                if(bille.testIntersection(rondChangementCouleurRectangleForme.areaA)){
                    if((bille.testIntersection(rondChangementCouleurRectangleForme.areaA)) && (!rondChangementCouleurUnSeul)){
                        bille.changementCouleurBille(bille);
                        rondChangementCouleurUnSeul = true;
                    }
                }
                else if(!rondChangementCouleurUnSeul){
                    if(defilementRondChangementCouleur > -100) {
                        g.drawImage(imgRondChangementCouleur, this.getWidth() / 2 - 20, defilementRondChangementCouleur, this);
                    }
                }



           if (defilementY > -200 && choixFigure[0]) { /////// barres ///////

               rectangleFormeRouge.nouvellePosition(0-defilementFigureX, defilementY, 200, 20);
               rectangleFormeRouge.paintComponents(g);
               rectangleFormeBleu.nouvellePosition(200-defilementFigureX, defilementY,200, 20);
               rectangleFormeBleu.paintComponents(g);
               rectangleFormeVert.nouvellePosition(400-defilementFigureX, defilementY,200, 20);
               rectangleFormeVert.paintComponents(g);
               rectangleFormeJaune.nouvellePosition(600-defilementFigureX, defilementY,200, 20);
               rectangleFormeJaune.paintComponents(g);
               rectangleFormeRouge2.nouvellePosition(800-defilementFigureX, defilementY,200, 20);
               rectangleFormeRouge2.paintComponents(g);
               rectangleFormeBleu2.nouvellePosition(1000-defilementFigureX, defilementY,200, 20);
               rectangleFormeBleu2.paintComponents(g);
               rectangleFormeVert2.nouvellePosition(1200-defilementFigureX, defilementY,200, 20);
               rectangleFormeVert2.paintComponents(g);
               rectangleFormeJaune2.nouvellePosition(1400-defilementFigureX, defilementY,200, 20);
               rectangleFormeJaune2.paintComponents(g);


               g.drawImage(imgBR, 0 - defilementFigureX , defilementY, this);
               g.drawImage(imgBB, 200 - defilementFigureX , defilementY, this);
               g.drawImage(imgBV, 400 - defilementFigureX, defilementY, this);
               g.drawImage(imgBJ, 600 - defilementFigureX , defilementY, this);
               g.drawImage(imgBR, 800 - defilementFigureX , defilementY, this);
               g.drawImage(imgBB, 1000 - defilementFigureX , defilementY, this);
               g.drawImage(imgBV, 1200 - defilementFigureX , defilementY, this);
               g.drawImage(imgBJ, 1400 - defilementFigureX , defilementY, this);

              if((bille.testIntersection(rectangleFormeRouge.areaA) || bille.testIntersection(rectangleFormeRouge2.areaA))  && (bille.getCouleur() != Color.RED)){
                  arretJeu =true;
              }
               if((bille.testIntersection(rectangleFormeBleu.areaA) || bille.testIntersection(rectangleFormeBleu2.areaA))  && (bille.getCouleur() != Color.BLUE)){
                   arretJeu =true;
               }
               if((bille.testIntersection(rectangleFormeVert.areaA) || bille.testIntersection(rectangleFormeVert2.areaA))  && (bille.getCouleur() != Color.GREEN)){
                   arretJeu =true;
               }
               if((bille.testIntersection(rectangleFormeJaune.areaA) || bille.testIntersection(rectangleFormeJaune2.areaA)) && (bille.getCouleur() != Color.YELLOW)){
                   arretJeu =true;
               }
           }

            AffineTransform old = g2d.getTransform();

           if (defilementY > -200 && choixFigure[1]) {/////// un cercle ///////

               etoileRectangleForme.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
               etoileRectangleForme.paintComponents(g);
               if(bille.testIntersection(etoileRectangleForme.areaA)){//collision pour l'étoile
                   if(!etoileUnSeulPointScore) {
                       bille.setScore(bille.getScore() + 1);
                       etoileUnSeulPointScore = true;
                   }
               }
               else if(!etoileUnSeulPointScore){
                   g2d.drawImage(imgEtoile, this.getWidth() / 2 - 20, defilementY - 19, this);
               }

                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2, defilementY);
                // 4 morceaux d'un cercle qui tourne
               /* g2d.drawImage(imgCJ, this.getWidth() / 2, defilementY, this);//109 = taille de l'image
                g2d.drawImage(imgCV, this.getWidth() / 2 - 109, defilementY, this);
                g2d.drawImage(imgCR, this.getWidth() / 2, defilementY - 109, this);
                g2d.drawImage(imgCB, this.getWidth() / 2 - 109, defilementY - 109, this);*/

               AffineTransform a = new AffineTransform();
               AffineTransform b = new AffineTransform();
               AffineTransform c = new AffineTransform();
               AffineTransform d = new AffineTransform();
               a.rotate(Math.toRadians(0+degree),this.getWidth() / 2 , defilementY);
               b.rotate(Math.toRadians(90+degree),this.getWidth() / 2 , defilementY);
               c.rotate(Math.toRadians(180+degree),this.getWidth() / 2 , defilementY);
               d.rotate(Math.toRadians(270+degree),this.getWidth() / 2 , defilementY);

               arcFormeRouge.nouvellePosition(this.getWidth()/2-150,defilementY-150, 300, 300, 0, 90);
               arcFormeRouge.nouvelleArea(a.createTransformedShape(arcFormeRouge.arc));
               arcFormeRouge.paintComponents(g);
               arcFormeBleu.nouvellePosition(this.getWidth()/2-150, defilementY-150, 300, 300, 90, 90);
               arcFormeBleu.nouvelleArea(a.createTransformedShape(arcFormeBleu.arc));
               arcFormeBleu.paintComponents(g);
               arcFormeVert.nouvellePosition(this.getWidth()/2-150, defilementY-150, 300, 300, 180, 90);
               arcFormeVert.nouvelleArea(a.createTransformedShape(arcFormeVert.arc));
               arcFormeVert.paintComponents(g);
               arcFormeJaune.nouvellePosition(this.getWidth()/2-150, defilementY-150, 300, 300, 270, 90);
               arcFormeJaune.nouvelleArea(a.createTransformedShape(arcFormeJaune.arc));
               arcFormeJaune.paintComponents(g);

               if((bille.testIntersection(arcFormeRouge.areaA)) && (bille.getCouleur() != Color.RED)){
                   arretJeu =true;
               }
               if((bille.testIntersection(arcFormeBleu.areaA)) && (bille.getCouleur() != Color.BLUE)){
                   arretJeu =true;
               }
               if((bille.testIntersection(arcFormeVert.areaA)) && (bille.getCouleur() != Color.GREEN)){
                   arretJeu =true;
               }
               if((bille.testIntersection(arcFormeJaune.areaA)) && (bille.getCouleur() != Color.YELLOW)){
                   arretJeu =true;
               }
            }
            g2d.setTransform(old);


            if (defilementY > -200 && choixFigure[2]){/////// un carré ///////
                etoileRectangleForme.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
                etoileRectangleForme.paintComponents(g);
                if(bille.testIntersection(etoileRectangleForme.areaA)){//collision pour l'étoile
                    if(!etoileUnSeulPointScore) {
                        bille.setScore(bille.getScore() + 1);
                        etoileUnSeulPointScore = true;
                    }
                }
                else if(!etoileUnSeulPointScore){
                    g2d.drawImage(imgEtoile, this.getWidth() / 2- 20, defilementY -19, this);
                }

                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2 , defilementY);

                g2d.drawImage(imgBB, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.drawImage(imgBV, this.getWidth() / 2 - 100, defilementY - 100, this);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2, defilementY);
                g2d.drawImage(imgBR, this.getWidth() / 2 - 100, 80 + defilementY, this);
                g2d.rotate((Math.toRadians(360)), this.getWidth() / 2, defilementY);
                g2d.drawImage(imgBJ, this.getWidth() / 2 - 100,  defilementY - 100, this);
                g2d.setTransform(old);

                AffineTransform a = new AffineTransform();
                AffineTransform b = new AffineTransform();
                AffineTransform c = new AffineTransform();
                AffineTransform d = new AffineTransform();
                a.rotate(Math.toRadians(0+degree),this.getWidth() / 2 , defilementY);
                b.rotate(Math.toRadians(0+degree),this.getWidth() / 2 , defilementY);
                c.rotate(Math.toRadians(90+degree),this.getWidth() / 2 , defilementY);
                d.rotate(Math.toRadians(90+degree),this.getWidth() / 2 , defilementY);

                rectangleFormeBleu.nouvellePosition(this.getWidth() / 2 - 100, 80+defilementY,200 , 20);
                rectangleFormeBleu.nouvelleArea(a.createTransformedShape(rectangleFormeBleu.barre));
                rectangleFormeBleu.paintComponents(g2d);
                rectangleFormeVert.nouvellePosition(this.getWidth() / 2 - 100,  defilementY - 100, 200 , 20);
                rectangleFormeVert.nouvelleArea(b.createTransformedShape(rectangleFormeVert.barre));
                rectangleFormeVert.paintComponents(g2d);
                rectangleFormeRouge.nouvellePosition(this.getWidth() / 2 - 100, 80 + defilementY, 200 , 20);
                rectangleFormeRouge.nouvelleArea(c.createTransformedShape(rectangleFormeRouge.barre));
                rectangleFormeRouge.paintComponents(g2d);
                rectangleFormeJaune.nouvellePosition(this.getWidth() / 2 - 100, defilementY - 100,200 , 20);
                rectangleFormeJaune.nouvelleArea(d.createTransformedShape(rectangleFormeJaune.barre));
                rectangleFormeJaune.paintComponents(g2d);

                if((bille.testIntersection(rectangleFormeRouge.areaA)) && (bille.getCouleur() != Color.RED)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeBleu.areaA)) && (bille.getCouleur() != Color.BLUE)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeVert.areaA)) && (bille.getCouleur() != Color.GREEN)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeJaune.areaA)) && (bille.getCouleur() != Color.YELLOW)){
                    arretJeu =true;
                }
            }


            if (defilementY > -200 && choixFigure[3]) { /////// une croix ///////

                etoileRectangleForme.nouvellePosition(this.getWidth() / 2 - 20, defilementY - 19, 40, 40);
                etoileRectangleForme.paintComponents(g);
                if(bille.testIntersection(etoileRectangleForme.areaA)){//collision pour l'étoile
                    if(!etoileUnSeulPointScore) {
                        bille.setScore(bille.getScore() + 1);
                        etoileUnSeulPointScore = true;
                    }
                }
                else if(!etoileUnSeulPointScore){
                    g2d.drawImage(imgEtoile, this.getWidth() / 2 - 20, defilementY - 19, this);
                }

                g2d.rotate((Math.toRadians(degree)), this.getWidth() / 2 - 100, defilementY);

                g2d.drawImage(imgBR, this.getWidth() / 2 - 100, defilementY, this);
                rectangleFormeRouge.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200, 20);
                rectangleFormeRouge.paintComponents(g2d);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBB, this.getWidth() / 2 - 100, defilementY, this);
                rectangleFormeBleu.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200, 20);
                rectangleFormeBleu.paintComponents(g2d);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBV, this.getWidth() / 2 - 100, defilementY, this);
                rectangleFormeVert.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200, 20);
                rectangleFormeVert.paintComponents(g2d);
                g2d.rotate((Math.toRadians(90)), this.getWidth() / 2 - 100, defilementY);
                g2d.drawImage(imgBJ, this.getWidth() / 2 - 100, defilementY, this);
                rectangleFormeJaune.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200, 20);
                rectangleFormeJaune.paintComponents(g2d);


                AffineTransform a = new AffineTransform();
                AffineTransform b = new AffineTransform();
                AffineTransform c = new AffineTransform();
                AffineTransform d = new AffineTransform();
                a.rotate(Math.toRadians(0+degree),this.getWidth() / 2 - 100, defilementY);
                b.rotate(Math.toRadians(90+degree),this.getWidth() / 2 - 100, defilementY);
                c.rotate(Math.toRadians(180+degree),this.getWidth() / 2 - 100, defilementY);
                d.rotate(Math.toRadians(270+degree),this.getWidth() / 2 - 100, defilementY);

                rectangleFormeRouge.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200 , 20);
                rectangleFormeRouge.nouvelleArea(a.createTransformedShape(rectangleFormeRouge.barre));
                rectangleFormeRouge.paintComponents(g2d);
                rectangleFormeBleu.nouvellePosition(this.getWidth() / 2 - 100, defilementY,200 , 20);
                rectangleFormeBleu.nouvelleArea(b.createTransformedShape(rectangleFormeBleu.barre));
                rectangleFormeBleu.paintComponents(g2d);
                rectangleFormeVert.nouvellePosition(this.getWidth() / 2 - 100, defilementY, 200 , 20);
                rectangleFormeVert.nouvelleArea(c.createTransformedShape(rectangleFormeVert.barre));
                rectangleFormeVert.paintComponents(g2d);
                rectangleFormeJaune.nouvellePosition(this.getWidth() / 2 - 100, defilementY,200 , 20);
                rectangleFormeJaune.nouvelleArea(d.createTransformedShape(rectangleFormeJaune.barre));
                rectangleFormeJaune.paintComponents(g2d);

                if((bille.testIntersection(rectangleFormeRouge.areaA)) && (bille.getCouleur() != Color.RED)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeBleu.areaA)) && (bille.getCouleur() != Color.BLUE)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeVert.areaA)) && (bille.getCouleur() != Color.GREEN)){
                    arretJeu =true;
                }
                if((bille.testIntersection(rectangleFormeJaune.areaA)) && (bille.getCouleur() != Color.YELLOW)){
                    arretJeu =true;
                }
            }
            g2d.setTransform(old);
            if(arretJeu){

                g2d.setFont(new Font("TimesRoman",Font.PLAIN, 50));
                g2d.setColor(Color.WHITE);
                g2d.drawString("Score " + String.valueOf(bille.getScore()) ,50, 50);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters Setters
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

    public void setEtoileUnSeulPointScore(boolean etoileUnSeulPointScore) {
        this.etoileUnSeulPointScore = etoileUnSeulPointScore;
    }

    public void setRondChangementCouleurUnSeul(boolean rondChangementCouleurUnSeul) {
        this.rondChangementCouleurUnSeul = rondChangementCouleurUnSeul;
    }
}