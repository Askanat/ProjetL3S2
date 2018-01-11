import controleur.ControlGroup;
import model.Jeu;

public class Appli {

    public static void main(String[] args) {

        Jeu jeu = new Jeu();
        ControlGroup controlGroup = new ControlGroup(jeu);

        //Niveau niveau = new Niveau(50, 3, Direction.GAUCHE);
        //niveau.print();
    }
}
