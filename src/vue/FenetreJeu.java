package vue;

import controleur.ControlFenetreJeu;
import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FenetreJeu extends JPanel {

    private Jeu jeu;

    public static int tailleMapX, tailleMapY;
    public static int tuileInt[][];
    public static Dimension ZONE;

    private Image imageFenetreJeu;
    public JButton menu;


    public FenetreJeu(Jeu jeu) {

        this.jeu = jeu;

        this.setLayout(null);
        imageFenetreJeu = getToolkit().getImage("images/menuPrincipale.jpg");
        this.setPreferredSize(ZONE);

        menu = new JButton("");
        menu.setActionCommand("Menu");
        Image img = getToolkit().getImage("images/iconeMenu.png").getScaledInstance(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40), java.awt.Image.SCALE_SMOOTH);
        menu.setIcon(new ImageIcon(img));
        this.add(menu);
    }

    /*public void updateEntite() {

        // création du héro graphiquement
        if (jeu.getHero() != null && hero == null) {
            hero = new EntiteVue(jeu);
            hero.creationEntite(jeu.getHero());
        }

        // scroll
        int x = (int) scrollPane.getViewport().getViewPosition().getX();
        int y = (int) scrollPane.getViewport().getViewPosition().getY();
        if (jeu.getHero().getPositionX() < scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(200)) {
            x = (int) (scrollPane.getViewport().getViewPosition().getX() - (X - Fenetre.adapterResolutionEnX(400)));
            x = x < 0 ? 0 : x;
        } else if (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1720) < jeu.getHero().getPositionX() && x <= ZONE.width - X)
            x = (int) (scrollPane.getViewport().getViewPosition().getX() + (X - Fenetre.adapterResolutionEnX(400)));

        if (jeu.getHero().getPositionY() < scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(100)) {
            y = (int) (scrollPane.getViewport().getViewPosition().getY() - (Y - Fenetre.adapterResolutionEnY(200)));
            y = y < 0 ? 0 : y;
        } else if (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(980) < jeu.getHero().getPositionY() && y <= ZONE.height - Y)
            y = (int) (scrollPane.getViewport().getViewPosition().getY() + (Y - Fenetre.adapterResolutionEnY(200)));

        scrollPane.getViewport().setViewPosition(new Point(x, y));
    }*/

    /*public void changerMap(String chemin) {

        readMap(chemin);
        tuileImage = new BufferedImage[tailleMapY][tailleMapX];
        chargerMap();

        if (hero != null) {
            if (!jeu.getEtat().getZoneSafe() && jeu.getNiveauDonjonActuelle() > 0) {
                if (jeu.getHero().getPositionY() < ZONE.height / 2.0)
                    jeu.getHero().setPositionY(-Fenetre.adapterResolutionEnY(200) + TAILLE_TUILE * tailleMapY - jeu.getHero().getHauteurBas());
                else
                    jeu.getHero().setPositionY(Fenetre.adapterResolutionEnY(550) - jeu.getHero().getHauteurBas());

                if (jeu.getHero().getPositionX() < ZONE.width / 2.0) {
                    jeu.getHero().setDirectionOrientation(Direction.GAUCHE);
                    jeu.getHero().setPositionX(-Fenetre.adapterResolutionEnX(150) + TAILLE_TUILE * tailleMapX);
                } else {
                    jeu.getHero().setDirectionOrientation(Direction.DROITE);
                    jeu.getHero().setPositionX(Fenetre.adapterResolutionEnX(150));
                }
            }
        }

        ZONE = new Dimension(TAILLE_TUILE * tailleMapX, TAILLE_TUILE * tailleMapY);
        this.setPreferredSize(ZONE);

        if (hero != null) {
            if (jeu.getNiveauDonjonActuelle() == 0) {
                jeu.getHero().setPositionX(Fenetre.adapterResolutionEnX(150));
                jeu.getHero().setPositionY((int) (-Fenetre.adapterResolutionEnY(200) + ZONE.getHeight() - jeu.getHero().getHauteurBas()));
            }

            if (jeu.getEtat().getZoneSafe())
                jeu.getHero().setPositionX(ZONE.width - 2);
        }

    }*/

    public void setControl(ControlFenetreJeu controlFenetreJeu) {
        menu.addActionListener(controlFenetreJeu);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // fond du jeu
        g.drawImage(imageFenetreJeu, 0, 0, getWidth(), getHeight(), this);

        // dessine les entites
        /*for (EntiteVue e : monstre)
            e.paintComponent(g);

        hero.paintComponent(g);
        */

        /*menu.setBounds((int) (scrollPane.getViewport().getViewPosition().getX() + Fenetre.adapterResolutionEnX(1860)), (int) (scrollPane.getViewport().getViewPosition().getY() + Fenetre.adapterResolutionEnY(10)), Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(40));
        menu.setBackground(new Color(0, 0, 0, 0));
        menu.setFocusable(false);
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.setBorder(null);
        */


    }
}
