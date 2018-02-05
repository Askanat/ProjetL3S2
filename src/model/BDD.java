package model;

import java.sql.*;
import java.util.ArrayList;

import static vue.Fenetre.DEFAUT_X;
import static vue.Fenetre.DEFAUT_Y;
import static vue.FenetreJeu.ZONE;

public class BDD {

    private Connection connexion;
    private Statement instruction;
    private boolean bddIsOk = false;

    public BDD() {

        String pilote = "com.mysql.jdbc.Driver";

        try {
            Class.forName(pilote);
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/projet", "DUTinfo", "0000");
            instruction = connexion.createStatement();
            bddIsOk = true;
        } catch (Exception e) {
            System.out.println("Echec pilote : " + e);
        }
    }
}