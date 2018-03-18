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

    public void mouseClicked(MouseEvent event) {
    }
    public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
    }
}