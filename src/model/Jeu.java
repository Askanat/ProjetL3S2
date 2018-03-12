package model;

public class Jeu {

    private Etat etat;
    public BDD bdd;
    public String[] score;

    public Jeu() {

        etat = new Etat();
        bdd = new BDD();
        bdd.readNomJoueur();
        splitScore();
    }

    public BDD getBdd() {
        return bdd;
    }

    public Etat getEtat() {
        return etat;
    }

    public void splitScore(){
      String[] scores = bdd.result.split(" ");
      setScores(scores);
    }

    public void setScores(String[] scores){
        this.score = scores;
    }

}
