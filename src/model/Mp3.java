package model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Mp3 {
    private FileInputStream fileInputStream;

    private Player player;

    public Mp3(String cheminAcces){

        try {
            fileInputStream = new FileInputStream(cheminAcces);
            player = new Player(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        return player;
    }

}
