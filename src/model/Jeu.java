package model;

public class Jeu {

    private BDD bdd;
    public Joueur joueur;

    public Jeu() {
        bdd = new BDD();
    }

    public BDD getBdd() {
        return bdd;
    }
}
