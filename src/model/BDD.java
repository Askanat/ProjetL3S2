package model;

import java.sql.*;

public class BDD {

    private Connection connexion;
    private Statement instruction;
    private boolean bddIsOk = false;

    public BDD() {

        String pilote = "com.mysql.jdbc.Driver";

        try {
            Class.forName(pilote);
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/projetl3", "l3info", "0000");
            instruction = connexion.createStatement();
            bddIsOk = true;
        } catch (Exception e) {
            System.out.println("Echec pilote : " + e);
        }
    }

    public boolean isBDD() {
        return bddIsOk;
    }

    //AFFICHAGE SCORE DES JOUEURS
    public String readNomJoueur() {
        ResultSet joueurs = null;
        String result = "";
        try {
            joueurs = instruction.executeQuery("Select nomJoueur,score FROM classement ORDER BY DESC score;");
            while (joueurs.next()) {
                result = joueurs.getString("nomJoueur") + " : " + joueurs.getString("score" ) + "Points";
            }
        } catch (Exception e) {
            System.out.println("Donnees nomJoueur/Score problem " + e);
        }
        return result;
    }

    //AJOUT DONNEES SCORE JOUEURS
    public void insertNomJoueur(String nom, int score){
        try {
            instruction.executeUpdate("INSERT INTO classement SET nomJoueur='" + nom + "', score='" + score + "';");
        } catch (Exception e) {
            System.out.println("Probleme insertion nouveau joueur : " + e);
        }
    }

}