package vue;
import controleur.ControlFenetreOptions;
import controleur.ControlTouche;
import model.Jeu;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreOptions extends JPanel {

    Jeu jeu;
    ControlTouche controlTouche;
    public Bouton retour;
    public Bouton soundOff, soundOn;
    //public JButton[] controlButton;

    private Image imageFenetreOption;
    private Font f, fControlTouche;

    public FenetreOptions(Jeu jeu, ControlTouche controlTouche) {
        this.controlTouche = controlTouche;
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreOption = getToolkit().getImage("images/menuPrincipale.jpg");
        f = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        //fControlTouche = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(35));

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        retour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        soundOff = new Bouton("Mute");
        soundOff.setActionCommand("Mute");
        soundOff.setCursor(new Cursor(Cursor.HAND_CURSOR));

        soundOn = new Bouton("Play");
        soundOn.setActionCommand("Play");
        soundOn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*controlButton = new JButton[controlTouche.getNbActions() - 1];
        String[] repAction = new String[]{"Droite", "Gauche", "Sauter"};

        for (int i = 0; i < controlButton.length; i++) {
            controlButton[i] = new JButton(controlTouche.getNomTouche(i + 1));
            controlButton[i].setActionCommand(repAction[i]);
        }
        */
        this.add(retour);
        this.add(soundOff);
        this.add(soundOn);

        /*for (JButton b : controlButton)
            this.add(b);*/
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);
        soundOff.addActionListener(controlFenetreOptions);
        soundOn.addActionListener(controlFenetreOptions);

        /*for (JButton b : controlButton) {
            b.addActionListener(controlFenetreOptions);
            b.addKeyListener(controlFenetreOptions);
        }*/
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreOption, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(50,800,125,45);
        soundOff.setBounds(50,500,125,45);
        soundOn.setBounds(200,500,125,45);

       /* int x1 = 750, y1 = 390;

        for (int i = 0; i < controlButton.length; i++) {
            if (i <= 4) {
                controlButton[i].setBounds(Fenetre.adapterResolutionEnX(x1), Fenetre.adapterResolutionEnY(y1), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(55));
                controlButton[i].setBackground(new Color(0, 0, 0, 0));
                controlButton[i].setForeground(Color.WHITE);
                controlButton[i].setFont(fControlTouche);
                controlButton[i].setBorder(null);
                y1 += 75;
            }
        }*/
    }
}