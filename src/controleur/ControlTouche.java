package controleur;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

public class ControlTouche {
    // Liste des actions possibles en cours de jeu

    public static final int
            ACTION_MENU = 0,
            ACTION_GAUCHE = 1,
            ACTION_DROITE = 2,
            ACTION_SAUT = 3;
    private int[] touches;
    private int nbActions;

    public ControlTouche() {
        Field[] fields = ControlTouche.class.getDeclaredFields();

        nbActions = fields.length - 2;
        touches = new int[nbActions];

        // Touches par défaut

        touches[ACTION_MENU] = KeyEvent.VK_ESCAPE;
        touches[ACTION_GAUCHE] = KeyEvent.VK_LEFT;
        touches[ACTION_DROITE] = KeyEvent.VK_RIGHT;
        touches[ACTION_SAUT] = KeyEvent.VK_SPACE;
    }

    public int getNbActions() {
        return nbActions;
    }

    public int[] getTouches() {
        return touches;
    }

    public String getNomTouche(int codeAction) {
        return KeyEvent.getKeyText(touches[codeAction]);
    }

    /*
     * setActionTouche : Change la touche associée à une action
     *
     * @codeAction : une des constantes définie dans ControlTouche
     * @touche : une touche définie dans la classe KeyEvent
     */

    public void setActionTouche(int codeAction, int touche) {
        touches[codeAction] = touche;
    }
}