package model;

import jdk.jfr.StackTrace;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ScoreFile {

    final String chemin = "saveScore/score.txt";
    final File fichier =new File(chemin);

    public String scores[] = new String[65535];
    private int score;

    public ScoreFile(){}

    public void writeScore(String nom, int score){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                    fichier, true));
            try {
                bufferedWriter.newLine();
                bufferedWriter.write(nom + " " + score);

            } finally {
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readScore(){
        int i = 1;
        try {
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
        int j = nbrTour();

        while(j > 0){
            for (int i = 0 ; i < scores.length ; i++){
                if(i <  scores.length && scores[i] != null){
                    parti        = scores[i].split(" ");
                    partsi       = Integer.parseInt(parti[1]);
                    if(i <  scores.length && scores[i+1] != null){
                        parti2   = scores[i+1].split(" ");
                        partsis  = Integer.parseInt(parti2[1]);
                    }
                    if (partsi < partsis){
                        String tampon[] = new String[1];
                        tampon[0] = scores[i];
                        if(scores[i+1] != null) {
                            scores[i] = scores[i + 1];
                            setScores(scores[i], i);
                            scores[i + 1] = tampon[0];
                            setScores(scores[i + 1], i + 1);
                        }
                    }
                }
            }
            j--;
        }
    }

    public void setScores(String line, int i){
        this.scores[i] = line;
        // System.out.println(scores[i]);
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int nbrTour(){
        int nombre = (int)(scores.length/3);
        return nombre;
    }
}
