package model;

public class Jeu {

    private Etat etat;
    private BDD bdd;

    public Jeu() {

        etat = new Etat();

        bdd = new BDD();
    }

    public BDD getBdd() {
        return bdd;
    }

    public Etat getEtat() {
        return etat;
    }
}
