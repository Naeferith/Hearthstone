/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

/**
 *
 * @author bagnato2u
 */
public final class Pioche extends Capacite {
    private int quantite;

    public Pioche(int quantite) {
        super("Pioche", "Vous piochez " + quantite + " cartes.");
        this.quantite = quantite;
    }

    @Override
    public final void executerAction(Object cible) {}

    @Override
    public final void executerEffetDebutTour() {}

    @Override
    public final void executerEffetDisparition(Object cible) {}

    @Override
    public final void executerEffetFinTour() {}

    @Override
    public final void executerEffetMiseEnJeu(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
