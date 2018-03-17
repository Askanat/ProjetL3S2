package model;

public class Jeu {

    private Etat etat;
    public BDD bdd;
    public String[] score;
    public ScoreFile scoreFile;
    public JoueurForme joueurForme;

    public Jeu() {

        etat = new Etat();
        bdd = new BDD();
        bdd.readNomJoueur();
        scoreFile = new ScoreFile();
        joueurForme = new JoueurForme();

    }

    public BDD getBdd() {
        return bdd;
    }

    public Etat getEtat() {
        return etat;
    }
    public void setScores(String[] scores){
        this.score = scores;
    }

}
