package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class MenuPrincipal extends JPanel {

    private Image imageMenuPrincipal;
    private int posX = 0;
    private int posY = 0;
    private int x2 = 200 ;
    private int y2 = 20;

    public Bouton nouvellePartie, guideJeu, options, credits, quitter;

    public MenuPrincipal() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageMenuPrincipal = getToolkit().getImage("images/menuPrincipale.jpg");

        nouvellePartie = new Bouton("Nouvelle Partie");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        guideJeu = new Bouton("Règles");
        guideJeu.setActionCommand("Règles");
        options = new Bouton("Options");
        options.setActionCommand("Options");
        credits = new Bouton("Crédits");
        credits.setActionCommand("Crédits");
        quitter = new Bouton("Quitter");
        quitter.setActionCommand("Quitter");

        this.add(nouvellePartie);
        this.add(guideJeu);
        this.add(options);
        this.add(credits);
        this.add(quitter);
    }

    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        nouvellePartie.addActionListener(controlMenuPrincipal);
        guideJeu.addActionListener(controlMenuPrincipal);
        options.addActionListener(controlMenuPrincipal);
        credits.addActionListener(controlMenuPrincipal);
        quitter.addActionListener(controlMenuPrincipal);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageMenuPrincipal, 0, 0, getWidth(), getHeight(), this);

        g.setColor(Color.white);
        g.fillOval(posX, posY, 50, 50);
        g.setColor(Color.pink);
        g.fillOval(x2, y2, 200 ,200);

        nouvellePartie.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(420), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        nouvellePartie.setBackground(new Color(0, 0, 0, 0));
        nouvellePartie.setForeground(Color.WHITE);
        nouvellePartie.setFocusable(false);
        nouvellePartie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nouvellePartie.setBorder(null);

        guideJeu.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(496), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        guideJeu.setBackground(new Color(0, 0, 0, 0));
        guideJeu.setForeground(Color.WHITE);
        guideJeu.setFocusable(false);
        guideJeu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        guideJeu.setBorder(null);

        options.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(570), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        options.setBackground(new Color(0, 0, 0, 0));
        options.setForeground(Color.WHITE);
        options.setFocusable(false);
        options.setCursor(new Cursor(Cursor.HAND_CURSOR));
        options.setBorder(null);

        credits.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(649), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        credits.setBackground(new Color(0, 0, 0, 0));
        credits.setForeground(Color.WHITE);
        credits.setFocusable(false);
        credits.setCursor(new Cursor(Cursor.HAND_CURSOR));
        credits.setBorder(null);

        quitter.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(729), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        quitter.setBackground(new Color(0, 0, 0, 0));
        quitter.setForeground(Color.WHITE);
        quitter.setFocusable(false);
        quitter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitter.setBorder(null);
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
    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }


}
