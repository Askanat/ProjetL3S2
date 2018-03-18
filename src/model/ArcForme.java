package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class ArcForme extends JPanel{
    protected Color couleur;
    public Arc2D arc = new Arc2D.Double(300, 300, 50, 50, 90, 180, Arc2D.OPEN);
    public Area areaA;
    public Shape shape;
    boolean b = false;
    public boolean b2 = false;

    public ArcForme(Color couleur){
        this.couleur = couleur;
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(couleur);
        ((Graphics2D) g).fill(arc);
        areaA = new Area(arc);
        g2d.draw(areaA);

        if(b){
            areaA = new Area(shape);
            // g2d.draw(areaA);
        }
    }

    public void nouvellePosition (int posX, int posY, int tailleX, int tailleY, int start, int angle){
        b = false;
        arc = new Arc2D.Double(posX, posY, tailleX, tailleY, start, angle, Arc2D.OPEN);

    }
    /* Permet de creer area a partir d'une shape, utile lorsque l'arc rotate */
    public void nouvelleArea(Shape shape){
        b = true;
        this.shape =  shape;
    }
}
