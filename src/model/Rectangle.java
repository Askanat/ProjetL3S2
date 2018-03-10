package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Rectangle extends JPanel {
    protected Color couleur;
    Rectangle2D barre = new Rectangle2D.Double(0,0,0,0);
    public Area areaA;

    public Rectangle(Color couleur){
        this.couleur = couleur;
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D)g;
        areaA = new Area(barre);
       // g2d.draw(areaA);

    }
    public void nouvellePosition (int posX, int posY, int tailleX, int tailleY){
        barre = new Rectangle2D.Double(posX, posY, tailleX, tailleY);

    }
}