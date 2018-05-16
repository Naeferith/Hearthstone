package jeu.application.console.ouput;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class InterfaceDisplayBoard extends DialogInterface {

    public InterfaceDisplayBoard(DialogInterface di) {
        super(di);
    }

    @Override
    public void executeRequest() throws HearthstoneException {
        Output.printBoard();
    }

    @Override
    public String getDescription() {
        return "Afficher le terrain de jeu";
    }
    
}
