package model;

public class Jeu {

    private BDD bdd;
    public Joueur joueur;

    public Jeu(String nomJoueur) {
        bdd = new BDD();
        joueur = new Joueur(nomJoueur);
    }

    public BDD getBdd() {
        return bdd;
    }
}
