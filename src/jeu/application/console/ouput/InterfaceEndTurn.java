package jeu.application.console.ouput;

import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfaceEndTurn extends DialogInterface {

    public InterfaceEndTurn(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() throws HearthstoneException {
        Plateau.getPlateau().finTour(Plateau.getPlateau().getJoueurCourant());
    }

    @Override
    public String getDescription() {
        return "Fin du tour";
    }
    
}
