package vue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bouton extends JButton implements MouseListener{
    private String nom;
    public Bouton(String nom){
        super(nom);
        this.nom = nom;
    }
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.green, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.white);
        g2d.drawString(this.nom, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        this.setBorder(null);
        this.setFocusable(false);
    }

    //Méthode appelée lors du clic de souris
    public void mouseClicked(MouseEvent event) {
    }
    //Méthode appelée lors du survol de la souris
    public void mouseEntered(MouseEvent event) {

    }
    //Méthode appelée lorsque la souris sort de la zone du bouton
    public void mouseExited(MouseEvent event) { }
    //Méthode appelée lorsque l'on presse le bouton gauche de la souris
    public void mousePressed(MouseEvent event) { }
    //Méthode appelée lorsque l'on relâche le clic de souris
    public void mouseReleased(MouseEvent event) {
        // clique relacher dans le bouton
        if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
        }

        else{
        }
    }
}