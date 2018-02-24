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
    public MenuEnJeu        panelMenuEnJeu;

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

        bouleColor();
    }

    public void init() {
        controlTouche       = new ControlTouche();
        panelMenuPrincipal  = new MenuPrincipal();
        panelFenetreJeu     = new FenetreJeu(jeu);
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
        panelFenetreRegles  = new FenetreRegles();
        panelFenetreCredits = new FenetreCredits();
        panelMenuEnJeu      = new MenuEnJeu();

        vueJeu();
    }
    public void bouleQuiAvanceJeu(){
        new Thread(new Runnable(){
            /* variables pour pas get a chaque tour de boucle */
            int positionY = panelFenetreJeu.getPosY();

            boolean backY = false;
            @Override
            public void run() {
                for (;;) {
                    if(positionY < 0)
                        backY = false;
                    if(positionY > panelFenetreJeu.getHeight()-50)
                        backY = true;

                    if(!backY)
                        panelFenetreJeu.setPosY(++positionY);
                    else
                        panelFenetreJeu.setPosY(--positionY);

                    panelFenetreJeu.repaint();
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void bouleQuiAvance(){
        new Thread(new Runnable(){
            /* variables pour pas get a chaque tour de boucle */
            int positionX = panelMenuPrincipal.getPosX();
            int positionY = panelMenuPrincipal.getPosY();
            int positionX2 = panelMenuPrincipal.getPosX2();
            int positionY2 = panelMenuPrincipal.getPosY2();

            boolean backX = false;
            boolean backY = false;
            boolean backX2 = false;
            boolean backY2 = false;

            @Override
            public void run() {
                for (;;) {
                    /*1er rond*/
                    if(positionX < 1) //on avance
                        backX = false;
                    if(positionX > panelMenuPrincipal.getWidth()-50) //on recule
                        backX = true;

                    if(positionY < 1)
                        backY = false;
                    if(positionY > panelMenuPrincipal.getHeight()-50)
                        backY = true;


                    if(!backX)// si on avance on incremente
                        panelMenuPrincipal.setPosX(++positionX);
                    else// si on recule on decremente
                        panelMenuPrincipal.setPosX(--positionX);

                    if(!backY)
                        panelMenuPrincipal.setPosY(++positionY);
                    else
                        panelMenuPrincipal.setPosY(--positionY);

                    /*2eme rond */
                    if(positionX2 < 1) //on avance
                        backX2 = false;
                    if(positionX2 > panelMenuPrincipal.getWidth()-100) //on recule
                        backX2 = true;

                    if(positionY2 < 1)
                        backY2 = false;
                    if(positionY2 > panelMenuPrincipal.getHeight()-100)
                        backY2 = true;


                    if(!backX2)// si on avance on incremente
                        panelMenuPrincipal.setPosX2(++positionX2);
                    else// si on recule on decremente
                        panelMenuPrincipal.setPosX2(--positionX2);

                    if(!backY2)
                        panelMenuPrincipal.setPosY2(++positionY2);
                    else
                        panelMenuPrincipal.setPosY2(--positionY2);


                    panelMenuPrincipal.repaint();
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void bouleColor(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (;;) {
                    panelMenuPrincipal.updateColor();

                    panelMenuPrincipal.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void vueMenuEnJeu() {
        layeredPane = getLayeredPane();
        JPanel top = panelMenuEnJeu;
        top.setBounds((int) (X / 4.0), (int) (Y / 4.0), (int) (X / 2.0), (int) (Y / 2.0));
        layeredPane.add(top, new Integer(1));
    }

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

    public void setControlMenuEnJeu(ControlMenuEnJeu controlMenuEnJeu) {
        panelMenuEnJeu.setControl(controlMenuEnJeu);
    }

    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }
}
