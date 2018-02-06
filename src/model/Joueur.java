package model;

public class Joueur {

    private int score;
    private String nomJoueur;

    public Joueur(String nomJoueur) {
        this.score = 0;
        this.nomJoueur = nomJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    }

    public int getScore() {
        return score;
    }
}
