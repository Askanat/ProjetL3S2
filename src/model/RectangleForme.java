package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class RectangleForme extends JPanel {
    protected Color couleur;
    public Rectangle2D barre = new Rectangle2D.Double(0,0 ,200,20);
    public Area areaA;
    public Shape shape;
    boolean b = false;

    public RectangleForme(Color couleur){
        this.couleur = couleur;
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D)g;
        areaA = new Area(barre);
        if(b){
            areaA = new Area(shape);
        }
    }

    public void nouvellePosition (int posX, int posY, int tailleX, int tailleY){
        b = false;
        barre = new Rectangle2D.Double(posX, posY, tailleX, tailleY);
    }
    /* Permet de creer area a partir d'une shape, utile lorsque le rectangle rotate */
    public void nouvelleArea(Shape shape){
        b = true;
        this.shape =  shape;
    }
}