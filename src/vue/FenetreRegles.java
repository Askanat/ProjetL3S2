package vue;

import controleur.ControlFenetreRegles;

import javax.swing.*;
import java.awt.*;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreRegles extends JPanel {

    private Image imageFenetreCredits;

    public Bouton retour;

    public FenetreRegles() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(X, Y));

        imageFenetreCredits = getToolkit().getImage("images/menuPrincipale.jpg");

        retour = new Bouton("Retour");
        retour.setActionCommand("Retour");

        this.add(retour);
    }

    public void setControl(ControlFenetreRegles controlFenetreRegles) {
        retour.addActionListener(controlFenetreRegles);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageFenetreCredits, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 25));
        g2.drawString("Color Switch",50,120);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 14));
        g2.drawString("Deplacement à la souris. Appuyez sur echap pour quitter le jeu une fois que vous avez perdu,",5,150);
        g2.drawString("appuyez sur c pour changer clavier/souris",5,200);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 25));
        g2.drawString("Stroop",50,270);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 14));
        g2.drawString("Ecrivez la couleur du mot qui est ecrit. Appuyer sur backspace pour effacer votre mot," ,5,300);
        g2.drawString("appuyer sur entrer pour valider le mot, echap pour quitter une fois que la fin du jeu a lieu." ,5,350);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 25));
        g2.drawString("GuitarHero",50,420);
        g2.setFont(new Font("TimesRoman",Font.PLAIN, 14));
        g2.drawString("Appuyer sur la touche correspondant a la 1er lettre de la couleur de la barre quand elles sont" ,5,450);
        g2.drawString("sur la ligne d'arrivée. " ,5,500);
        retour.setBounds(50,800,125,45);

    }
}
