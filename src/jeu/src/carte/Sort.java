package jeu.src.carte;

import jeu.src.capacite.Capacite;
import jeu.src.IJoueur;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public final class Sort extends Carte {

    public Sort(String nom, int mana, IJoueur joueur, Capacite capacite) {
        super(nom, mana, joueur, capacite);
    }

    
    @Override
    public final boolean disparait() {
        //un sort disparait toujours après utilisation
        return true;
    }

    @Override
    public final void executerAction(Object cible) {}

    @Override
    public final void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
        if (this.getCout() > Plateau.getPlateau().getJoueurCourant().getStockMana()) throw new HearthstoneException("Mana Insuffisant.");
        
        this.getCapacite().executerEffetMiseEnJeu(cible);
        
        //Après execution de la capacité, on détruit la carte
        Plateau.getPlateau().getJoueurCourant().getMain().remove(this);
    }

    @Override
    public final void executerEffetDebutTour() {}

    @Override
    public final void executerEffetDisparition(Object cible) {}

    @Override
    public final void executerEffetFinTour() {}
}
