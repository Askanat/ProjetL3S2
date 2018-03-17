package model;

import jdk.jfr.StackTrace;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ScoreFile {

    final String chemin = "saveScore/score.txt";
    final File fichier =new File(chemin);

    public String scores[] = new String[65535];
    public int taille;

    public ScoreFile(){
        try {
            fichier.createNewFile();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeScore(String nom, int score){
        try {
            fichier .createNewFile();
            FileWriter writer = new FileWriter(fichier);
            try {
                writer.write(nom + ":" + score + "\n");
            } finally {
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readScore(){
        int i = 0;
        try {
            fichier.createNewFile();
            FileReader score = new FileReader(fichier);
            BufferedReader bfr = new BufferedReader(score);
            try{
                String line = bfr.readLine();
                setScores(line, 0);

                while(line != null){
                    line = bfr.readLine();
                    setScores(line, i);
                    i++;
                }
                bfr.close();
                score.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void orderScore(){
        String parti[];
        String parti2[];
        int partsi  = 0;
        int partsis = 0 ;
        readScore();
        for (int i = 0 ; i < 65535 ; i++){
            if(i < 65535 && scores[i] != null){
                parti        = scores[i].split(":");
                partsi      = Integer.parseInt(parti[1]);

                if(scores[i+1] != null){
                    parti2        = scores[i+1].split(":");
                    partsis     = Integer.parseInt(parti2[1]);
                }

                if (partsi < partsis){
                    String tampon;
                    tampon = scores[i];
                    scores[i] = scores[i+1];
                    setScores(scores[i], i);
                    scores[i+1] = tampon;
                    setScores(scores[i+1], i+1);
                    System.out.println(scores[i]);
                }
            }
        }
    }

    public void setScores(String line, int i){
        this.scores[i] = line;
        //System.out.println(scores[i]);
    }

}
