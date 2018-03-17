package jeu.src;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public interface ICarte extends Cloneable {

    /**Renvoie true si la cate est encore présente sur le terrain le tour suivant
     *
     * @return true - la carte est toujours sur le terrain
     */
    public abstract boolean disparait();
    public abstract void executerAction(Object cible);
    public abstract void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException;
    public abstract void executerEffetDebutTour();
    public abstract void executerEffetDisparition(Object cible);
    public abstract void executerEffetFinTour();
    public abstract ICapacite getCapacite();
    public abstract int getCout();
    public abstract String getNom();
    public abstract IJoueur getProprietaire();
}
