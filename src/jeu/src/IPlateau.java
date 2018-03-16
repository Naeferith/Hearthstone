package jeu.src;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public interface IPlateau {
    public abstract void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
    public abstract void demarrerPartie() throws HearthstoneException;
    public abstract boolean estDemaree();
    public abstract void finTour(IJoueur joueur);
    public abstract void gagnePartie(IJoueur joueur);
    public abstract IJoueur getAdversaire(IJoueur joueur);
    public abstract IJoueur getJoueurCourant();
    public abstract void setJoueurCourant(IJoueur joueur);
}
