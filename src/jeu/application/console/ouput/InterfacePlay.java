package jeu.application.console.ouput;

import jeu.application.Main;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfacePlay extends DialogInterface {

    public InterfacePlay(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() {
        IPlateau plateau = Plateau.getPlateau();
        try {
            plateau.demarrerPartie();
            Main.StartGame();
        }
        catch (HearthstoneException e){
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Jouer";
    }
}