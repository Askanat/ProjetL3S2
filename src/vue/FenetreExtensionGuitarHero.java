package vue;

import controleur.ControlFenetreExtensionGuitarHero;

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

    private int posX= 0;
    private int posY= 0;
    public Bouton retour;

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
        Graphics2D g2 = (Graphics2D) g;
        //retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 50));
        g2.setColor(Color.WHITE);
        g2.drawString("GUITARRRR", 170, 100);

        try {
            Image imgBonhommeBaton = ImageIO.read(new File("images\\bonhommeBaton.png"));
            g.drawImage(imgBonhommeBaton,this.getWidth()/2-25-posX, this.getHeight()-50-posY, this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
