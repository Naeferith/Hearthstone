package jeu.src;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public interface ICarte extends Cloneable {

    public abstract boolean disparait();
    public abstract void executerAction(Object cible) throws HearthstoneException;
    public abstract void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException;
    public abstract void executerEffetDebutTour();
    public abstract void executerEffetDisparition(Object cible) throws HearthstoneException;
    public abstract void executerEffetFinTour();
    public abstract ICapacite getCapacite();
    public abstract int getCout();
    public abstract String getNom();
    public abstract IJoueur getProprietaire();
}
