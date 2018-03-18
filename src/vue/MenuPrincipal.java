package vue;

import controleur.ControlMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class MenuPrincipal extends JPanel {

    private Image imageMenuPrincipal;

    public Bouton nouvellePartie, guideJeu, options, regles, quitter, stroop, guitarHero;

    public MenuPrincipal() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageMenuPrincipal = getToolkit().getImage("images/menuPrincipale.jpg");

        nouvellePartie = new Bouton("Play");
        nouvellePartie.setActionCommand("Nouvelle Partie");
        guideJeu = new Bouton("Scores");
        guideJeu.setActionCommand("Scores");
        options = new Bouton("Options");
        options.setActionCommand("Options");
        regles = new Bouton("Regles");
        regles.setActionCommand("Regles");
        quitter = new Bouton("Quitter");
        quitter.setActionCommand("Quitter");
        stroop = new Bouton("Stroop");
        stroop.setActionCommand("Stroop");
        guitarHero = new Bouton ("GuitarHero");
        guitarHero.setActionCommand("GuitarHero");

        this.add(nouvellePartie);
        this.add(guideJeu);
        this.add(options);
        this.add(regles);
        this.add(quitter);
        this.add(stroop);
        this.add(guitarHero);
    }

    public void setControl(ControlMenuPrincipal controlMenuPrincipal) {
        nouvellePartie.addActionListener(controlMenuPrincipal);
        guideJeu.addActionListener(controlMenuPrincipal);
        options.addActionListener(controlMenuPrincipal);
        regles.addActionListener(controlMenuPrincipal);
        quitter.addActionListener(controlMenuPrincipal);
        stroop.addActionListener(controlMenuPrincipal);
        guitarHero.addActionListener(controlMenuPrincipal);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageMenuPrincipal, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("TimesRoman",Font.PLAIN, 50));
        g2.setColor(Color.BLUE);
        g2.drawString("Color",this.getWidth()/2-125,100);
        g2.setColor(Color.GREEN);
        g2.drawString("Switch",this.getWidth()/2,100);

        nouvellePartie.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(420), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        guideJeu.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(496), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        options.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(570), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        regles.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(649), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        quitter.setBounds(Fenetre.adapterResolutionEnX(1248), Fenetre.adapterResolutionEnY(729), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        stroop.setBounds(Fenetre.adapterResolutionEnX(248), Fenetre.adapterResolutionEnY(649), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
        guitarHero.setBounds(Fenetre.adapterResolutionEnX(248), Fenetre.adapterResolutionEnY(729), Fenetre.adapterResolutionEnX(400), Fenetre.adapterResolutionEnY(54));
    }
}