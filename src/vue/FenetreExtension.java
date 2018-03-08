package vue;


import controleur.ControlFenetreExtension;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static vue.Fenetre.X;
import static vue.Fenetre.Y;

public class FenetreExtension extends JPanel{
    private Image imageFenetreExtension;

    private int posX= 0;
    private int posY= 0;
    private boolean motTab[] = new boolean[4];
    public Bouton retour;

    public FenetreExtension() {

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

    public void setControl(ControlFenetreExtension controlFenetreExtension) {
        retour.addActionListener(controlFenetreExtension);
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageFenetreExtension, 0, 0, getWidth(), getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;
        retour.setBounds(Fenetre.adapterResolutionEnX(40), Fenetre.adapterResolutionEnY(980), Fenetre.adapterResolutionEnX(228), Fenetre.adapterResolutionEnX(40));

        try {
            Image imgBonhommeBaton = ImageIO.read(new File("images\\bonhommeBaton.png"));
            g.drawImage(imgBonhommeBaton,this.getWidth()/2-25-posX, this.getHeight()-50-posY, this);

            g2.setFont(new Font("TimesRoman",Font.PLAIN, 50));
            if(motTab[0]){
                g2.setColor(Color.YELLOW);
                g2.drawString("rouge",this.getWidth()/2-50,100);
                repaint();
            }
            if(motTab[1]){
                g2.setColor(Color.GREEN);
                g2.drawString("bleu",this.getWidth()/2-50,100);
                repaint();
            }
            if(motTab[2]){
                g2.setColor(Color.RED);
                g2.drawString("vert",this.getWidth()/2-50,100);
                repaint();
            }
            if(motTab[3]){
                g2.setColor(Color.BLUE);
                g2.drawString("jaune",this.getWidth()/2-50,100);
                repaint();
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


}
