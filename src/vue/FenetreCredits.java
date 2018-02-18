package vue;

import controleur.ControlFenetreCredits;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreCredits extends JPanel {

    private Image imageFenetreCredits;

    public Bouton retour;

    public FenetreCredits() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreCredits = getToolkit().getImage("images/menuPrincipale.jpg");

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");

        this.add(retour);
    }

    public void setControl(ControlFenetreCredits controlFenetreCredits) {
        retour.addActionListener(controlFenetreCredits);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreCredits, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));

    }
}
