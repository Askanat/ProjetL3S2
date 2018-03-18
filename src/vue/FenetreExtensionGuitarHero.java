package vue;

import controleur.ControlFenetreExtensionGuitarHero;
import model.RectangleForme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreExtensionGuitarHero extends JPanel{
    private Image imageFenetreExtension;
    private int defilementY= 0;
    private boolean arretJeu;

    public Bouton retour;
    RectangleForme rectangleFormeRouge = new RectangleForme(Color.RED);
    RectangleForme rectangleFormeBleu = new RectangleForme(Color.BLUE);
    RectangleForme rectangleFormeJaune = new RectangleForme(Color.YELLOW);
    RectangleForme rectangleFormeVert = new RectangleForme(Color.GREEN);
    RectangleForme zoneDeValidation = new RectangleForme(Color.WHITE);
    private boolean couleurBarre[] = new boolean[4];
    private boolean validationCouleur[] = new boolean[4];
    private int score = 0;
    private boolean scoreBoolean = false;

    public FenetreExtensionGuitarHero() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));
        imageFenetreExtension = getToolkit().getImage("images/menuPrincipale.jpg");
        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);
    }

    public void setControl(ControlFenetreExtensionGuitarHero controlFenetreExtensionGuitarHero) {
        retour.addActionListener(controlFenetreExtensionGuitarHero);
    }
    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreExtension, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2d = (Graphics2D) g;

        //retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        g2d.setFont(new Font("TimesRoman",Font.PLAIN, 50));
        g2d.setColor(Color.WHITE);
        g2d.drawString("SCORE", 170, 100);
        g2d.drawString(String.valueOf(score),100,100);
        try {
            Image imgBR = ImageIO.read(new File("images\\rectangleRouge.png"));
            Image imgBB = ImageIO.read(new File("images\\rectangleBleu.png"));
            Image imgBV = ImageIO.read(new File("images\\rectangleVert.png"));
            Image imgBJ = ImageIO.read(new File("images\\rectangleJaune.png"));
            Image imgCoeur = ImageIO.read(new File("images\\coeur.png"));
            Image damier = ImageIO.read(new File("images\\damier.png"));

            g.drawImage(damier,20,850, this);
            g.drawImage(imgCoeur,430,50, this);
            zoneDeValidation.nouvellePosition(20, 850, 560, 20);
            zoneDeValidation.paintComponents(g2d);

            if(couleurBarre[0]){
                rectangleFormeRouge.nouvellePosition(50,-20 + defilementY,200,20);
                g.drawImage(imgBR, 50 , -20+defilementY, this);
                rectangleFormeRouge.paintComponents(g2d);
                repaint();

                zoneDeValidation.areaA.intersect(rectangleFormeRouge.areaA);
                if((!zoneDeValidation.areaA.isEmpty()) && validationCouleur[0] ){
                    if(!scoreBoolean){
                        score++;
                        scoreBoolean = true;
                    }

                }
                else{
                    validationCouleur[0] = false;
                    scoreBoolean = false;
                }
            }
            if(couleurBarre[1]){
                rectangleFormeBleu.nouvellePosition(150,-20 + defilementY,200,20);
                g.drawImage(imgBB, 150 , -20+defilementY, this);
                rectangleFormeBleu.paintComponents(g2d);
                repaint();

                zoneDeValidation.areaA.intersect(rectangleFormeBleu.areaA);
                if((!zoneDeValidation.areaA.isEmpty()) && validationCouleur[1] ){
                    if(!scoreBoolean){
                        score++;
                        scoreBoolean = true;
                    }
                }
                else{
                    validationCouleur[1] = false;
                    scoreBoolean = false;
                }
            }
            if(couleurBarre[2]){
                rectangleFormeVert.nouvellePosition(250,-20 + defilementY,200,20);
                g.drawImage(imgBV, 250 , -20+defilementY, this);
                rectangleFormeVert.paintComponents(g2d);
                repaint();

                zoneDeValidation.areaA.intersect(rectangleFormeVert.areaA);
                if((!zoneDeValidation.areaA.isEmpty()) && validationCouleur[2] ){
                    if(!scoreBoolean){
                        score++;
                        scoreBoolean = true;
                    }
                }
                else{
                    validationCouleur[2] = false;
                    scoreBoolean = false;
                }
            }
            if(couleurBarre[3]){
                rectangleFormeJaune.nouvellePosition(350,-20 + defilementY,200,20);
                g.drawImage(imgBJ, 350 , -20+defilementY, this);
                rectangleFormeJaune.paintComponents(g2d);
                repaint();

                zoneDeValidation.areaA.intersect(rectangleFormeJaune.areaA);
                if((!zoneDeValidation.areaA.isEmpty()) && validationCouleur[3] ){
                    if(!scoreBoolean){
                        score++;
                        scoreBoolean = true;
                    }
                }
                else{
                    validationCouleur[3] = false;
                    scoreBoolean = false;
                }
            }
            if(score%3 == 0 && score!=0){
                //g2d.setColor(Color.WHITE);
                //g2d.drawString("SCORE", 170, 100);
                g2d.drawString("PLUS VITE",200,200);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDefilementY() {
        return defilementY;
    }

    public void setDefilementY(int defilementY) {
        this.defilementY = defilementY;
    }
    public boolean isArretJeu() {
        return arretJeu;
    }

    public void setArretJeu(boolean arretJeu) {
        this.arretJeu = arretJeu;
    }

    public boolean[] getCouleurBarre() {
        return couleurBarre;
    }

    public void setCouleurBarre(boolean[] couleurBarre) {
        this.couleurBarre = couleurBarre;
    }

    public boolean[] getValidationCouleur() {
        return validationCouleur;
    }

    public void setValidationCouleur(int i, boolean b) {
        this.validationCouleur[i] = b;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
