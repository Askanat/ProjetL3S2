package vue;

import controleur.ControlFenetreCredits;
import controleur.ControlFenetreOptions;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreOptions extends JPanel {

    private Image imageFenetreOptions;

    public Bouton retour;

    public FenetreOptions() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreOptions = getToolkit().getImage("images/menuPrincipale.jpg");

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");

        this.add(retour);
    }

    public void setControl(ControlFenetreOptions controlFenetreOptions) {
        retour.addActionListener(controlFenetreOptions);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageFenetreOptions, 0, 0, getWidth(), getHeight(), this);

        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));

    }
}
