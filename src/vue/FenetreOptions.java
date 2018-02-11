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
    public Bouton retour, hitBox;
    public Bouton[] controlButton;

    private Image imageFenetreOption;
    private Font f, fControlTouche;

    public FenetreOptions(Jeu jeu, ControlTouche controlTouche) {
        this.controlTouche = controlTouche;
        this.jeu = jeu;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreOption = getToolkit().getImage("images/menuOptionsTest.png");
        f = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(20));
        fControlTouche = new Font("Arial", Font.BOLD, Fenetre.adapterResolutionEnX(35));

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");
        hitBox = new Bouton("Hitbox");
        hitBox.setActionCommand("Hitbox");

        controlButton = new Bouton[controlTouche.getNbActions() - 1];
        String[] repAction = new String[]{"Avancer", "Reculer", "Sauter", "Descendre", "Attaquer", "Sort1", "Sort2", "Sort3", "Sort4", "Sort5", "Sort6", "Sort7", "Sort8"};

        for (int i = 0; i < controlButton.length; i++) {
            controlButton[i] = new Bouton(controlTouche.getNomTouche(i + 1));
            controlButton[i].setActionCommand(repAction[i]);
        }

        this.add(retour);
        this.add(hitBox);

        for (Bouton b : controlButton)
            this.add(b);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);

        for (Bouton b : controlButton) {
            b.addActionListener(controlFenetreOptions);
            b.addKeyListener(controlFenetreOptions);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreOption, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        retour.setBackground(new Color(0, 0, 0, 0));
        retour.setFocusable(false);
        retour.setBorder(null);

        int x1 = 600, y1 = 390;
        int x2 = 1300, y2 = 323;

        for (int i = 0; i < controlButton.length; i++) {
            if (i <= 4) {
                controlButton[i].setBounds(Fenetre.adapterResolutionEnX(x1), Fenetre.adapterResolutionEnY(y1), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(55));
                controlButton[i].setBackground(new Color(0, 0, 0, 0));
                controlButton[i].setFont(fControlTouche);
                controlButton[i].setBorder(null);
                y1 += 75;
            }
            if (i >= 5) {
                controlButton[i].setBounds(Fenetre.adapterResolutionEnX(x2), Fenetre.adapterResolutionEnY(y2), Fenetre.adapterResolutionEnX(270), Fenetre.adapterResolutionEnY(50));
                controlButton[i].setBackground(new Color(0, 0, 0, 0));
                controlButton[i].setFont(fControlTouche);
                controlButton[i].setBorder(null);
                y2 += 58;
            }
        }
    }
}