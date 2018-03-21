package jeu.src;

import java.util.ArrayList;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public interface IJoueur {
    static final int MAX_MANA = 10;
    static final int TAILLE_DECK = 15;
    static final int TAILLE_MAIN = 10;
    static final int TAILLE_BOARD = 7;
    
    public abstract void finirTour();
    public abstract ICarte getCarteEnJeu(String nomCarte);
    public abstract ICarte getCarteEnMain(String nomCarte);
    public abstract Heros getHeros();
    public abstract ArrayList<ICarte> getJeu();
    public abstract ArrayList<ICarte> getMain();
    public abstract int getMana();
    public abstract String getPseudo();
    public abstract int getStockMana();
    public abstract void jouerCarte(ICarte carte) throws HearthstoneException;
    public abstract void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
    public abstract void perdreCarte(ICarte carte) throws HearthstoneException;
    public abstract void piocher() throws HearthstoneException;
    public abstract void prendreTour() throws HearthstoneException;
    public abstract void utiliserCarte(ICarte carte, Object cible);
    public abstract void utiliserPouvoir(Object cible) throws HearthstoneException;
}
