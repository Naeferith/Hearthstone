package jeu.src;

import jeu.src.carte.ICarte;
import jeu.src.heros.Heros;
import java.util.ArrayList;
import jeu.src.exception.HearthstoneException;

/**Interface pour la classe joueur
 *
 * @author BAGNATO Thomas
 */
public interface IJoueur {
    //Quantité maximale de mana
    static final int MAX_MANA = 10;
    //Taille d'un deck
    static final int TAILLE_DECK = 15;
    //Nombre maximal de carte qu'un joueur peut tenir en main
    static final int TAILLE_MAIN = 10;
    //Nombre maximal de serviteur présent sur le terrain
    static final int TAILLE_BOARD = 7;
    
    public abstract void finirTour();
    public abstract ICarte getCarteEnJeu(String nomCarte);
    public abstract ICarte getCarteEnMain(String nomCarte);
    public abstract Heros getHeros();
    public abstract ArrayList<ICarte> getJeu();
    public abstract ArrayList<ICarte> getMain();
    public abstract String getPseudo();
    public abstract void jouerCarte(ICarte carte) throws HearthstoneException;
    public abstract void jouerCarte(ICarte carte, Object cible) throws HearthstoneException;
    public abstract void perdreCarte(ICarte carte) throws HearthstoneException;
    public abstract void piocher() throws HearthstoneException;
    public abstract void prendreTour() throws HearthstoneException;
    public abstract void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException;
    public abstract void utiliserPouvoir(Object cible) throws HearthstoneException;
    public abstract void setDeck();
}