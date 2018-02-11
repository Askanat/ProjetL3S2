import controleur.ControlGroup;
import model.Jeu;

public class Appli {

    public static void main(String[] args) {

        Jeu jeu = new Jeu("ale boom");
        ControlGroup controlGroup = new ControlGroup(jeu);
        
    }
}
