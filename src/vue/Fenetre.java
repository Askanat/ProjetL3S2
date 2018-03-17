package vue;

import controleur.*;
import javazoom.jl.decoder.JavaLayerException;
import model.Jeu;
import model.Mp3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class Fenetre extends JFrame {

    private static Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    public static final double DEFAUT_X = 1920;
    public static final double DEFAUT_Y = 1080;
    public static final int X = 600; // (int) tailleEcran.getWidth();
    public static final int Y = 900; // (int) tailleEcran.getHeight();


    private boolean finMusiqueMenu = false;


    private ControlSouris souris;
    private Jeu jeu;

    public MenuPrincipal    panelMenuPrincipal;
    public FenetreJeu       panelFenetreJeu;
    public FenetreScore     panelFenetreScore;
    public FenetreRegles panelFenetreRegles;
    public FenetreOptions   panelFenetreOptions;
    public FenetreExtensionStroop panelFenetreExtensionStroop;
    public FenetreExtensionGuitarHero panelFenetreExtensionGuitarHero;

    public MenuEnJeu        panelMenuEnJeu;

    public ControlTouche    controlTouche;

    public static JScrollPane   scrollPane;
    public JPanel               panelScrollFenetreJeu;
    public JLayeredPane         layeredPane;

    public boolean mute = false;


    public boolean clavier = true;

    public Fenetre(Jeu jeu) {
        souris = new ControlSouris(jeu, this);
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
        jouerMusiqueMenu();
        boulesQuiAvancentMenu();
        bouleColor();
    }

    public void init() {
        controlTouche       = new ControlTouche();
        panelMenuPrincipal  = new MenuPrincipal();
        panelFenetreJeu     = new FenetreJeu(jeu);
        panelFenetreOptions = new FenetreOptions(jeu, controlTouche);
        panelFenetreScore = new FenetreScore();
        panelFenetreRegles = new FenetreRegles();
        panelMenuEnJeu      = new MenuEnJeu();
        panelFenetreExtensionStroop = new FenetreExtensionStroop();
        panelFenetreExtensionGuitarHero = new FenetreExtensionGuitarHero();

        vueJeu();
    }
    public void redeclareFenetreJeu() {
        panelFenetreJeu= new FenetreJeu(jeu);
    }
    public void redeclareFenetreExtensionStroop(){
        panelFenetreExtensionStroop= new FenetreExtensionStroop();
    }
    public void redeclareFenetreExtensionGuitarHero(){
        panelFenetreExtensionGuitarHero = new FenetreExtensionGuitarHero();
    }

    public void changerMotExtensionStroop(){
        Random rand = new Random();
        int buffer = -1;
        int val = -1;
        boolean[] actualiserTab = new boolean[4];
        for(int i = 0 ; i<actualiserTab.length ; i++){
            actualiserTab[i] = false;
        }
        for(int i = 0 ; i<actualiserTab.length ; i++){
            if(panelFenetreExtensionStroop.getMotTab()[i]){
                buffer = i;
            }
        }
        val = rand.nextInt(4);
        while(val == buffer ){
            val = rand.nextInt(4);
        }
        actualiserTab[val] = true;
        panelFenetreExtensionStroop.setMotTab(actualiserTab);
        panelFenetreExtensionStroop.repaint();
    }
    public void changerCouleurBarreExtensionGuitarHero (){
        Random rand = new Random();
        int buffer = -1;
        int val = -1;
        boolean[] actualiserTab = new boolean[4];
        for(int i = 0 ; i<actualiserTab.length ; i++){
            actualiserTab[i] = false;
        }
        for(int i = 0 ; i<actualiserTab.length ; i++){
            if(panelFenetreExtensionGuitarHero.getCouleurBarre()[i]){
                buffer = i;
            }
        }
        val = rand.nextInt(4);
        while(val == buffer ){
            val = rand.nextInt(4);
        }
        actualiserTab[val] = true;
        panelFenetreExtensionGuitarHero.setCouleurBarre(actualiserTab);
        panelFenetreExtensionGuitarHero.repaint();
    }

    public void deplacementSouris(){
        panelFenetreJeu.setPosX(300+7-this.souris.getX());
        panelFenetreJeu.setPosY(900+9-this.souris.getY());
    }

    public void deplacementClavier() {
        new Thread(new Runnable(){
            int positionY;

            @Override
            public void run() {
                for(int i = 0; i<250; i++){
                    panelFenetreJeu.setPosY(panelFenetreJeu.getPosY()+1);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void deplacementClavierExtensionStroop(boolean bonneReponse) {
        new Thread(new Runnable(){
            int positionY;
            boolean arretJeu = panelFenetreExtensionStroop.isArretJeu();
            @Override
            public void run() {

                for(int i = 0; i<100; i++) {
                    if (panelFenetreExtensionStroop.getPosY() < 900) {
                        //fin du jeu
                        if (i <= 100) {
                            if (bonneReponse)
                                panelFenetreExtensionStroop.setPosY(panelFenetreExtensionStroop.getPosY() + 1);
                            else
                                panelFenetreExtensionStroop.setPosY(panelFenetreExtensionStroop.getPosY() - 1);
                        }
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
    public void tempsExtensionStroop() {
        new Thread(new Runnable(){
            int secondsInt;
            String secondsString;
            boolean arretJeu = panelFenetreExtensionStroop.isArretJeu();
            int posX = panelFenetreExtensionStroop.getPosX();
            @Override
            public void run() {

                while(!arretJeu){
                    arretJeu = panelFenetreExtensionStroop.isArretJeu();
                    if(arretJeu){
                        break;
                    }
                    secondsString = panelFenetreExtensionStroop.getSeconds();
                    secondsInt = Integer.parseInt(secondsString);
                    secondsInt++;
                    secondsString = String.valueOf(secondsInt);
                    panelFenetreExtensionStroop.setSeconds(secondsString);
                    posX++;
                    panelFenetreExtensionStroop.setPosX(posX);

                    if(posX == 7){
                        posX = 0;
                        panelFenetreExtensionStroop.setPosX(posX);
                    }
                    if (panelFenetreExtensionStroop.getPosY() == 900){
                        arretJeu = true;
                        panelFenetreExtensionStroop.setArretJeu(arretJeu);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void jouerMusiqueJeu(){ new Thread(new Runnable(){
        boolean arretJeu = panelFenetreJeu.isArretJeu();
        Mp3 musiqueJeu = new Mp3("musiques\\musiqueJeu.mp3");
        @Override
        public void run() {
            try {
                while (musiqueJeu.getPlayer().play(1)) {
                    arretJeu = panelFenetreJeu.isArretJeu();
                    if(arretJeu || mute == true){
                        musiqueJeu.getPlayer().close();
                    }
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
    }).start();
    }
    public void jouerMusiqueJeuExtensionGuitarHero(){ new Thread(new Runnable(){
        boolean arretJeu = panelFenetreExtensionGuitarHero.isArretJeu();
        Mp3 musiqueExtensionGuitarHero = new Mp3("musiques\\musiqueExtensionGuitarHero.mp3");
        @Override
        public void run() {
            try {
                while (musiqueExtensionGuitarHero.getPlayer().play(1)) {
                    arretJeu = panelFenetreExtensionGuitarHero.isArretJeu();
                    if(arretJeu || mute == true){
                        musiqueExtensionGuitarHero.getPlayer().close();
                    }
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
    }).start();
    }
    public void jouerMusiqueJeuExtensionStroop(){ new Thread(new Runnable(){
        boolean arretJeu = panelFenetreExtensionStroop.isArretJeu();
        Mp3 musiqueExtensionStroop = new Mp3("musiques\\musiqueExtensionStroop.mp3");
        @Override
        public void run() {
            try {
                while (musiqueExtensionStroop.getPlayer().play(1)) {
                    arretJeu = panelFenetreExtensionStroop.isArretJeu();
                    if(arretJeu || mute == true){
                        musiqueExtensionStroop.getPlayer().close();
                    }
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
    }).start();
    }

    public void jouerMusiqueMenu(){ new Thread(new Runnable(){
        Mp3 musiqueMenu = new Mp3("musiques\\musiqueMenu.mp3");
        @Override
        public void run() {
            try {
                while (musiqueMenu.getPlayer().play(1)){
                    if(finMusiqueMenu || mute == true){
                        musiqueMenu.getPlayer().close();
                    }
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
    }).start();
    }

    public void jouerMusiqueFin(){ new Thread(new Runnable(){
        boolean arretJeu = panelFenetreJeu.isArretJeu();
        Mp3 musiqueFin = new Mp3("musiques\\finDePartie.mp3");
        boolean buffer = true;
        @Override
        public void run() {
            try {
                while (buffer) {
                    arretJeu = panelFenetreJeu.isArretJeu();
                    if(arretJeu || mute == true){
                        musiqueFin.getPlayer().play();
                    }
                    if(arretJeu){
                        buffer = false;
                    }
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
            }
        }
    }).start();
    }

    public void jouerMusiqueBouton(){ new Thread(new Runnable(){
        Mp3 musiqueFinBouton = new Mp3("musiques\\caisseEnregistreuse.mp3");

        @Override
        public void run() {
            try {
                while (musiqueFinBouton.getPlayer().play(1)) {
                        musiqueFinBouton.getPlayer().play();
                }
            } catch(JavaLayerException e){
                e.printStackTrace();
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
            int posX = panelFenetreJeu.getPosX();
            int degree = panelFenetreJeu.getDegree();
            int defilementFigureX = panelFenetreJeu.getDefilementFigureX();
            int i = (int) (Math.random() * 4 );
            @Override
            public void run() {
                panelFenetreJeu.choixFigure[i] =true; // pour 1ere figure
                while(!arretJeu) {

                    if(!isClavier()){
                        if(panelFenetreJeu.getPosY()>-50){ //tier ecran
                            defilementY++;
                            defilementRondChangementCouleur++;
                        }
                    }
                    if(isClavier()){
                        if(panelFenetreJeu.getPosY()>300){ //tier ecran
                            defilementY++;
                            defilementRondChangementCouleur++;
                        }
                    }

                    defilementFigureX++;

                    panelFenetreJeu.repaint();
                    panelFenetreJeu.setDefilementY(defilementY);
                    panelFenetreJeu.setDefilementRondChangementCouleur(defilementRondChangementCouleur);
                    panelFenetreJeu.setDefilementFigureX(defilementFigureX);



                    if(defilementFigureX == 800){
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
                        panelFenetreJeu.setRondChangementCouleurUnSeul(false);

                    }
                    if(panelFenetreJeu.isGraviter()){
                        panelFenetreJeu.setPosY(panelFenetreJeu.getPosY() - 1 );
                    }
                    arretJeu = panelFenetreJeu.isArretJeu();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!arretJeu){
                    jouerMusiqueFin();
                }
            }
        }).start();
    }
    public void formeDefilementExtensionGuitarHero(){
        new Thread(new Runnable(){
            boolean arretJeu = panelFenetreExtensionGuitarHero.isArretJeu();
            int defilementY = panelFenetreExtensionGuitarHero.getDefilementY();
            int buffer = 0;
            int vitesse = 0;

            @Override
            public void run() {
                while(!arretJeu) {
                    defilementY++;
                    panelFenetreExtensionGuitarHero.setDefilementY(defilementY);
                    if(defilementY == 900){
                        panelFenetreExtensionGuitarHero.setDefilementY(0);
                        defilementY = panelFenetreExtensionGuitarHero.getDefilementY();
                    }
                    if (defilementY == 0){
                        changerCouleurBarreExtensionGuitarHero();
                    }
                    if (panelFenetreExtensionGuitarHero.getScore() == 10){
                        arretJeu = true;
                        panelFenetreExtensionGuitarHero.setArretJeu(arretJeu);
                    }
                    if(panelFenetreExtensionGuitarHero.getScore() == buffer+3){ //si le score a augmenté
                        buffer = panelFenetreExtensionGuitarHero.getScore();
                        vitesse++;
                    }

                    try {
                        Thread.sleep(4-vitesse);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void boulesQuiAvancentMenu(){
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

    public void incrementeDegree(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                int degree = panelFenetreJeu.getDegree();

                for (;;) {
                        degree++;
                        panelFenetreJeu.setDegree(degree);
                        if(degree == 360){
                            panelFenetreJeu.setDegree(0);
                            degree=panelFenetreJeu.getDegree();
                        }
                    try {
                        Thread.sleep(15);
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

    public void setControlFenetreCredits(ControlFenetreRegles controlFenetreRegles) {
        panelFenetreRegles.setControl(controlFenetreRegles);
    }

    public void setControlFenetreRegles(ControlFenetreScores controlFenetreScores) {
        panelFenetreScore.setControl(controlFenetreScores);
    }

    public void setControlFenetreJeu(ControlFenetreJeu controlFenetreJeu) {
        panelFenetreJeu.setControl(controlFenetreJeu);
    }
    public void setControlFenetreExtensionStroop(ControlFenetreExtensionStroop controlFenetreExtensionStroop) {
        panelFenetreExtensionStroop.setControl(controlFenetreExtensionStroop);
    }
    public void setControlFenetreExtensionGuitarHero(ControlFenetreExtensionGuitarHero controlFenetreExtensionGuitarHero) {
        panelFenetreExtensionGuitarHero.setControl(controlFenetreExtensionGuitarHero);
    }

    public void setControlMenuEnJeu(ControlMenuEnJeu controlMenuEnJeu) {
        panelMenuEnJeu.setControl(controlMenuEnJeu);
    }

    public void setControlClavier(ControlClavier controlClavier) {
        addKeyListener(controlClavier);
    }
    public void setControlClavierExtensionStroop(ControlClavierExtensionStroop controlClavierExtensionStroop) {
        addKeyListener(controlClavierExtensionStroop);
    }

    public void setControlClavierExtensionGuitarHero(ControlClavierExtensionGuitarHero controlClavierExtensionGuitarHero) {
        addKeyListener(controlClavierExtensionGuitarHero);
    }

    public void setControlSouris (ControlSouris controlSouris){
        addMouseMotionListener(controlSouris);
    }

    public void setFinMusiqueMenu(boolean finMusiqueMenu) {
        this.finMusiqueMenu = finMusiqueMenu;
    }
    public boolean isClavier() {
        return clavier;
    }

    public void setClavier(boolean clavier) {
        this.clavier = clavier;
    }

    public void setSourisPosition(int posX, int posY) {
        this.souris.setX(posX);
        this.souris.setY(posY);
    }
    public ControlSouris getSouris() {
        return souris;
    }
}
