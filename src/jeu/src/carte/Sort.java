package jeu.src.carte;

import jeu.src.capacite.Capacite;
import jeu.src.IJoueur;

/**
 *
 * @author bagnato2u
 */
public final class Sort extends Carte {

    public Sort(String nom, int mana, IJoueur joueur, Capacite capacite) {
        super(nom, mana, joueur, capacite);
    }

    @Override
    public boolean disparait() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executerAction(Object cible) {}

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executerEffetDebutTour(Object cible) {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour(Object cible) {}
}
