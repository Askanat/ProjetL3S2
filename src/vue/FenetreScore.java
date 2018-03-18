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
    private JLabel label;
    private int score;

    public JTextField pseudoScore;

    public JButton retour, ajouter;

    public int x1 = 250;
    public int y1 = 250;

    ScoreFile file = new ScoreFile();


    public FenetreScore() {

        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));
        file.orderScore();

        imageFenetreScore = getToolkit().getImage("images/menuPrincipale.jpg");

        pseudoScore = new JTextField();
        pseudoScore.setColumns(1);

        label = new JLabel("Pseudo");

        ajouter = new Bouton("Ajouter Score");
        ajouter.setActionCommand("Ajouter");
        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        this.add(ajouter);
        this.add(retour);
        this.add(pseudoScore);
        this.add(label);
    }

    public void setControl(ControlFenetreScores controlFenetreScores) {
        retour.addActionListener(controlFenetreScores);
        ajouter.addActionListener(controlFenetreScores);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageFenetreScore, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g1 = (Graphics2D) g;
        g1.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        g1.setColor(Color.white);
        g1.drawString("Scores",275, 200);


        for (int i = 0; i < 10; i++){
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

        label.setBounds(Fenetre.adapterResolutionEnX(100), Fenetre.adapterResolutionEnY(100), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(30));
        label.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        label.setForeground(Color.white);

        pseudoScore.setBounds(Fenetre.adapterResolutionEnX(350), Fenetre.adapterResolutionEnY(100), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(30));

        ajouter.setBounds(Fenetre.adapterResolutionEnX(650), Fenetre.adapterResolutionEnY(100), Fenetre.adapterResolutionEnX(512), Fenetre.adapterResolutionEnY(40));

        retour.setBounds(Fenetre.adapterResolutionEnX(64), Fenetre.adapterResolutionEnY(985), Fenetre.adapterResolutionEnX(256), Fenetre.adapterResolutionEnY(41));
    }

    public void setCoordY(int i){
        this.y1 = y1+30;
    }

    public int getCoordY(){
        return y1;
    }
}