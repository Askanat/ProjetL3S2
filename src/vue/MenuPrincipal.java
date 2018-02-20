package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class MenuPrincipal extends JPanel {

    private Image imageMenuPrincipal;
    private int posX = -50;
    private int posY = -50;
    private int posX2 = 100 ;
    private int posY2 = 100;

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
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 50));
        g2.setColor(Color.blue);
        g2.drawString("Color",350,100);
        g2.setColor(Color.green);
        g2.drawString("Switch",475,100);

        g.setColor(Color.blue);
        g.fillOval(posX, posY, 50, 50);
        g.setColor(Color.green);
        g.fillOval(posX2, posY2, 100 ,100);

        nouvellePartie.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(420), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        guideJeu.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(496), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        options.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(570), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        credits.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(649), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        quitter.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(729), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
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
    public int getPosX2() {
        return posX2;
    }

    public void setPosX2(int x2) {
        this.posX2 = x2;
    }

    public int getPosY2() {
        return posY2;
    }

    public void setPosY2(int y2) {
        this.posY2 = y2;
    }
}