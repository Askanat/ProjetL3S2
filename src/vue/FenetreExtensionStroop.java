package vue;


import controleur.ControlFenetreExtensionStroop;
import model.JoueurForme;
import model.RectangleForme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreExtensionStroop extends JPanel{
    private Image imageFenetreExtension;
    RectangleForme bouleDeFeuForme1= new RectangleForme(Color.RED);
    RectangleForme bouleDeFeuForme2= new RectangleForme(Color.RED);
    RectangleForme bouleDeFeuForme3= new RectangleForme(Color.RED);
    RectangleForme bouleDeFeuForme4= new RectangleForme(Color.RED);
    JoueurForme bonhommeBaton = new JoueurForme();

    private int posX= 0;
    private int posY= 0;
    private boolean motTab[] = new boolean[4];
    public Bouton retour;
    private int score = 0;
    private String seconds = "-1";
    boolean arretJeu = false;

    public FenetreExtensionStroop() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));
        imageFenetreExtension = getToolkit().getImage("images/menuPrincipale.jpg");
        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);

        for(int i = 0 ; i<motTab.length ; i++){

            motTab[i] = false;
        }
        /* pour le 1er mot */
        Random rand = new Random();
        int val = rand.nextInt(4);
        motTab[val] = true;
    }

    public void setControl(ControlFenetreExtensionStroop controlFenetreExtensionStroop) {
        retour.addActionListener(controlFenetreExtensionStroop);
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreExtension, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("TimesRoman",Font.PLAIN, 40));
        g2.setColor(Color.WHITE);
        g2.drawString(seconds ,30 ,880);
        g2.drawString("Seconds", 80, 880);

        try {
            Image imgBonhommeBaton = ImageIO.read(new File("images\\bonhommeBaton.png"));
            Image imgBouleDeFeu = ImageIO.read(new File("images\\bouleDeFeu.png"));
            g.drawImage(imgBonhommeBaton,this.getWidth()/2-25, this.getHeight()-50-posY, this);
            bonhommeBaton.nouvellePosition(this.getWidth()/2-25, this.getHeight()-50- posY);
            bonhommeBaton.paintComponent(g);

            if(motTab[0]){
                g2.setColor(Color.YELLOW);
                g2.setFont(new Font("TimesRoman",Font.PLAIN, 100));
                g2.drawString("rouge",this.getWidth()/2-120,200);
                repaint();
            }
            if(motTab[1]){
                g2.setColor(Color.GREEN);
                g2.setFont(new Font("TimesRoman",Font.PLAIN, 100));
                g2.drawString("bleu",this.getWidth()/2-120,200);
                repaint();
            }
            if(motTab[2]){
                g2.setColor(Color.RED);
                g2.setFont(new Font("TimesRoman",Font.PLAIN, 100));
                g2.drawString("vert",this.getWidth()/2-120,200);
                repaint();
            }
            if(motTab[3]){
                g2.setColor(Color.BLUE);
                g2.setFont(new Font("TimesRoman",Font.PLAIN, 100));
                g2.drawString("jaune",this.getWidth()/2-120,200);
                repaint();
            }

            g.drawImage(imgBouleDeFeu, -230 + ((posX + 1) *100), 150, this);
            g.drawImage(imgBouleDeFeu, 770 - ((posX + 1) *100), 350, this);
            g.drawImage(imgBouleDeFeu, 670 - ((posX + 2) *100), 550, this);
            g.drawImage(imgBouleDeFeu, -130 + (posX *100), 750, this);

            bouleDeFeuForme1.nouvellePosition( -230 + ((posX+1) *100), 150, 50,50);
            bouleDeFeuForme1.paintComponents(g);
            bouleDeFeuForme2.nouvellePosition( 770 - ((posX+1) *100), 350, 50,50);
            bouleDeFeuForme2.paintComponents(g);
            bouleDeFeuForme3.nouvellePosition( 670 - ((posX+2) *100), 550, 50,50);
            bouleDeFeuForme3.paintComponents(g);
            bouleDeFeuForme4.nouvellePosition( -130 + (posX *100), 750, 50,50);
            bouleDeFeuForme4.paintComponents(g);

            if(bonhommeBaton.testIntersection(bouleDeFeuForme1.areaA) || bonhommeBaton.testIntersection(bouleDeFeuForme2.areaA) ||
                    bonhommeBaton.testIntersection(bouleDeFeuForme3.areaA) || bonhommeBaton.testIntersection(bouleDeFeuForme4.areaA)){
                arretJeu =true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public boolean[] getMotTab() {
        return motTab;
    }

    public void setMotTab(boolean[] motTab) {
        this.motTab = motTab;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public boolean isArretJeu() {
        return arretJeu;
    }

    public void setArretJeu(boolean arretJeu) {
        this.arretJeu = arretJeu;
    }



}
