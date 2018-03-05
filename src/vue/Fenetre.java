package vue;

import controleur.*;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class Fenetre extends JFrame {

    private static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final double DEFAUT_X = 1920;
    public static final double DEFAUT_Y = 1080;
    public static final int X = 600; // (int) tailleEcran.getWidth();
    public static final int Y = 900; // (int) tailleEcran.getHeight();


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
    public void redeclareFenetreJeu(){
        panelFenetreJeu = new FenetreJeu(jeu);
    }

    public void deplacementClavier() {
        new Thread(new Runnable(){
            int positionY;

            @Override
            public void run() {
                for(int i = 0; i<500; i++){
                    if(i<=250) {
                        panelFenetreJeu.setPosY(panelFenetreJeu.getPosY()+1);
                    }
                    if(i>=250){
                        panelFenetreJeu.setPosY(panelFenetreJeu.getPosY()-1);
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();
    }

    public void bouleQuiAvanceJeu(){
        new Thread(new Runnable(){
            /* variables pour pas get a chaque tour de boucle */
            int positionY = panelFenetreJeu.getY();
            boolean arretJeu = panelFenetreJeu.isArretJeu();
            boolean backY = false;
            @Override
            public void run() {
                while(!arretJeu) {

                    if(positionY < 0)
                        backY = false;
                    if(positionY > panelFenetreJeu.getHeight()-50)
                        backY = true;

                    if(!backY)
                        panelFenetreJeu.setPosY(++positionY);
                    else
                        panelFenetreJeu.setPosY(--positionY);

                    panelFenetreJeu.repaint();
                    arretJeu =panelFenetreJeu.isArretJeu();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void formeDefilement(){
        new Thread(new Runnable(){
            /* variables pour pas get a chaque tour de boucle */
            boolean arretJeu = panelFenetreJeu.isArretJeu();

            int defilementRondChangementCouleur = panelFenetreJeu.getDefilementRondChangementCouleur();
            int defilementY = panelFenetreJeu.getDefilementY();
            int degree = panelFenetreJeu.getDegree();
            int defilementFigureX = panelFenetreJeu.getDefilementFigureX();

            int i = (int) (Math.random() * 4 );
            @Override
            public void run() {
                panelFenetreJeu.choixFigure[i] =true; // pour 1ere figure
                while(!arretJeu) {

                    defilementY++;
                    defilementRondChangementCouleur++;
                    defilementFigureX++;

                    panelFenetreJeu.repaint();
                    panelFenetreJeu.setDefilementY(defilementY);
                    panelFenetreJeu.setDefilementRondChangementCouleur(defilementRondChangementCouleur);
                    panelFenetreJeu.setDefilementFigureX(defilementFigureX);

                    if (panelFenetreJeu.choixFigure[1]){
                        degree++;
                        panelFenetreJeu.setDegree(degree);
                        if(degree == 360){
                            panelFenetreJeu.setDegree(0);
                            degree=panelFenetreJeu.getDegree();
                        }
                    }

                    if(defilementFigureX == 1600){
                        panelFenetreJeu.setDefilementFigureX(0);
                        defilementFigureX = panelFenetreJeu.getDefilementFigureX();
                    }

                    if(defilementY == 1100){
                        panelFenetreJeu.setDefilementY(-200);
                        defilementY=panelFenetreJeu.getDefilementY();
                        panelFenetreJeu.choixFigure[i] = false;
                        i = (int) (Math.random() * 4 );
                        panelFenetreJeu.choixFigure[i] = true;
                        panelFenetreJeu.setDegree(0);
                        degree=panelFenetreJeu.getDegree();
                        panelFenetreJeu.setEtoileUnSeulPointScore(false);
                    }

                    if(defilementY == 450){
                        panelFenetreJeu.setDefilementRondChangementCouleur(-100);
                        defilementRondChangementCouleur=panelFenetreJeu.getDefilementRondChangementCouleur();
                    }

                    arretJeu =panelFenetreJeu.isArretJeu();
                    try {
                        Thread.sleep(2);
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
