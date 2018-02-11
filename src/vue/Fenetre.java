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

    public static BufferedImage[] tableauTuile;
    public static final int DECOUPE_TUILE_EN_X = 7, DECOUPE_TUILE_EN_Y = 12;

    public static int numeroPorte; // permet de selectionner la porte avec les flammes

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

        numeroPorte = -1;
    }

    public static BufferedImage[] decoupage(BufferedImage origin, int divisionHorizontale, int divisionVerticale) {

        BufferedImage tab[] = new BufferedImage[divisionHorizontale * divisionVerticale];
        int tailleBaseHeight = origin.getHeight() / divisionVerticale;
        int tailleBaseWidth = origin.getWidth() / divisionHorizontale;
        int k = 0;
        for (int i = 0; i < divisionVerticale; i++) {
            for (int j = 0; j < divisionHorizontale; j++) {
                tab[k] = origin.getSubimage(j * tailleBaseWidth, i * tailleBaseHeight, tailleBaseWidth, tailleBaseHeight);
                k++;
            }
        }
        return tab;
    }

    public void init() {
        /*try {
            tableauTuile = decoupage(ImageIO.read(new File("tuile/tuile.png")), DECOUPE_TUILE_EN_X, DECOUPE_TUILE_EN_Y);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        controlTouche = new ControlTouche();  // @Maxime je ne pense pas que cela doit etre initialisé ici
        panelMenuPrincipal = new MenuPrincipal();
        panelFenetreJeu = new FenetreJeu(jeu);
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
        panelFenetreRegles = new FenetreRegles();
        panelFenetreCredits = new FenetreCredits();

        vueJeu();
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

    public void initFenetreOptions(ControlTouche controlTouche) {
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
    }

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
