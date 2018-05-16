package jeu.application.console.ouput;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public abstract class DialogInterface {
    private DialogInterface next = null;
    
    public DialogInterface(DialogInterface di) {
        this.next = di;
    }
    
    public DialogInterface getNext() {
        return next;
    }
    
    public abstract void executeRequest() throws HearthstoneException;
    public abstract String getDescription();
    
    public boolean canInterpret(String choix) {
        return this.getDescription().equals(choix);
    }
    
    public void interact(String choix) throws HearthstoneException {
        if (this.canInterpret(choix)) this.executeRequest();
        else if (this.next != null) this.next.interact(choix);
        else throw new HearthstoneException("Choix [ " + choix +" ] inconnu.");
    }
}
