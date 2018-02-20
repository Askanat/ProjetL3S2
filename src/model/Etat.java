package model;

import controleur.Control;

public class Etat {

    private int temps;
    private boolean pause;

    public Etat() {

        temps = 0;
        pause = false;

    }

    public void incrementeTemps() {
        temps++;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getTemps() {
        return temps;
    }

    public void inversePause() {
        if (Control.enPartie) setPause(!getPause());
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public final boolean getPause() {
        return pause;
    }
}