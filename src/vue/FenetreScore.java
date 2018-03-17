package vue;

import controleur.ControlFenetreScores;
import model.BDD;
import model.Jeu;
import model.ScoreFile;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.*;

public class FenetreScore extends JPanel {

    private Jeu jeu;

    private Image imageFenetreScore;

    public JButton retour;

    public int x1 = 250;
    public int y1 = 250;

    ScoreFile file = new ScoreFile();


    public FenetreScore() {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreScore = getToolkit().getImage("images/menuPrincipale.jpg");

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(retour);
    }

    public void setControl(ControlFenetreScores controlFenetreScores) {
        retour.addActionListener(controlFenetreScores);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageFenetreScore, 0, 0, getWidth(), getHeight(), this);

        file.orderScore();

        Graphics2D g1 = (Graphics2D) g;
        g1.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        g1.setColor(Color.white);
        g1.drawString("Scores",300, 125);


        for (int i = 0; i < 65535; i++){
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(new Font("TimesRoman",Font.PLAIN, 20));
            g2.setColor(Color.white);
            if (file.scores[i]!=null){
                if(i == 0){
                    g2.drawString(file.scores[i], x1, y1);
                } else {
                    setCoordY(getCoordY());
                    g2.drawString(file.scores[i], x1, getCoordY());
                }
            }
        }

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
    }

    public void setCoordY(int i){
        this.y1 = y1+30;
    }

    public int getCoordY(){
        return y1;
    }

}