package jeu.src;
/**
 *
 * @author bagnato2u
 */
public interface ICarte extends Cloneable {
    public abstract boolean disparait();
    public abstract void executerAction(Object cible);
    public abstract void executerEffetDebutMiseEnJeu(Object cible);
    public abstract void executerEffetDebutTour(Object cible);
    public abstract void executerEffetDisparition(Object cible);
    public abstract void executerEffetFinTour(Object cible);
    public abstract ICapacite getCapacite();
    public abstract int getCout();
    public abstract String getNom();
    public abstract IJoueur getProprietaire();
}
