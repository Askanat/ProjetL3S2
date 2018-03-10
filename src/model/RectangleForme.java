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
        if(b){
            areaA = new Area(shape);
           // g2d.draw(areaA);
        }

        else{
            areaA = new Area(barre);
            g2d.draw(areaA);
        }
    }

    public void nouvellePosition (int posX, int posY, int tailleX, int tailleY){
        barre = new Rectangle2D.Double(posX, posY, tailleX, tailleY);
    }

    public void nouvelleArea(Shape shape){
        this.shape =  shape;
        b = true;
    }
}