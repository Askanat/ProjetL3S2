package vue;

import controleur.*;
import model.Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class Fenetre extends JFrame {

    private static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final double DEFAUT_X = 1920;
    public static final double DEFAUT_Y = 1080;
    public static final int X = 960; // (int) tailleEcran.getWidth();
    public static final int Y = 540; // (int) tailleEcran.getHeight();

    private Jeu jeu;

    public MenuPrincipal    panelMenuPrincipal;
    public FenetreJeu       panelFenetreJeu;
    public FenetreRegles    panelFenetreRegles;
    public FenetreCredits   panelFenetreCredits;
    public FenetreOptions   panelFenetreOptions;

    public ControlTouche    controlTouche;

    public static JScrollPane   scrollPane;
    public JPanel               panelScrollFenetreJeu;
    public JLayeredPane         layeredPane;

    public Fenetre(Jeu jeu) {

        this.jeu = jeu;
        init();

        //setUndecorated(true);
        this.setContentPane(panelMenuPrincipal);
        this.pack();
        this.setTitle("Jeu");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        bouleQuiAvance();
    }

    public void init() {
        controlTouche = new ControlTouche();
        panelMenuPrincipal = new MenuPrincipal();
        panelFenetreJeu = new FenetreJeu();
        panelFenetreOptions = new FenetreOptions();
        panelFenetreRegles = new FenetreRegles();
        panelFenetreCredits = new FenetreCredits();



        vueJeu();
    }
    private void bouleQuiAvance(){
        for(int i = -50; i < panelMenuPrincipal.getWidth(); i++){
            int x = panelMenuPrincipal.getPosX(), y = panelMenuPrincipal.getPosY();
            int x2 = panelMenuPrincipal.getX2(), y2 = panelMenuPrincipal.getY2();
            x++;
            y++;
            x2++;
            y2++;

            panelMenuPrincipal.setPosX(x);
            panelMenuPrincipal.setPosY(y);
            panelMenuPrincipal.setX2(x2);
            panelMenuPrincipal.setY2(y2);

            panelMenuPrincipal.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /*public void vueMenuEnJeu() {
        layeredPane = getLayeredPane();
        JPanel top = panelMenuEnJeu;
        top.setBounds((int) (X / 4.0), (int) (Y / 4.0), (int) (X / 2.0), (int) (Y / 2.0));
        layeredPane.add(top, new Integer(1));
    }*/

    public void vueJeu() {
        scrollPane = new JScrollPane(panelFenetreJeu, VERTICAL_SCROLLBAR_NEVER, HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, X, Y);
        panelScrollFenetreJeu = new JPanel(null);
        panelScrollFenetreJeu.setPreferredSize(new Dimension(X, Y));
        panelScrollFenetreJeu.add(scrollPane);
    }

    public static int adapterResolutionEnX(int valeur) {
        return (int) (valeur / DEFAUT_X * X);
    }

    public static int adapterResolutionEnY(int valeur) {
        return (int) (valeur / DEFAUT_Y * Y);
    }

    /*public void initFenetreOptions(ControlTouche controlTouche) {
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
    }*/

    public void setControlMenuPrincipal(ControlMenuPrincipal controlMenuPrincipal) {
        panelMenuPrincipal.setControl(controlMenuPrincipal);
    }

    public void setControlFenetreOptions(ControlFenetreOptions controlFenetreOptions) {
        panelFenetreOptions.setControl(controlFenetreOptions);
    }

    public void setControlFenetreCredits(ControlFenetreCredits controlFenetreCredits) {
        panelFenetreCredits.setControl(controlFenetreCredits);
    }

    public void setControlFenetreRegles(ControlFenetreRegles controlFenetreRegles) {
        panelFenetreRegles.setControl(controlFenetreRegles);
    }

    public void setControlFenetreJeu(ControlFenetreJeu controlFenetreJeu) {
        panelFenetreJeu.setControl(controlFenetreJeu);
    }

    /*public void setControlMenuEnJeu(ControlMenuEnJeu controlMenuEnJeu) {
        panelMenuEnJeu.setControl(controlMenuEnJeu);
    }*/

    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }

}
