package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class MenuPrincipal extends JPanel {

    private Image imageMenuPrincipal;

    public JButton nouvellePartie, guideJeu, options, credits, quitter;
    protected Color couleur[] = {Color.WHITE, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
    public Color color;

    public MenuPrincipal() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageMenuPrincipal = getToolkit().getImage("images/menuPrincipale.jpg");

        nouvellePartie = new JButton("Nouvelle Partie");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        guideJeu = new JButton("Règles");
        guideJeu.setActionCommand("Règles");
        options = new JButton("Options");
        options.setActionCommand("Options");
        credits = new JButton("Crédits");
        credits.setActionCommand("Crédits");
        quitter = new JButton("Quitter");
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

    public void setColor(Color colori){
        this.color = colori;
    }

    public Color getColor(){
        return color;
    }

    public void updateColor(){
        Random rand = new Random();
        int val = rand.nextInt(5);
        setColor(couleur[val]);
    }
}
