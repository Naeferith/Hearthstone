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
public final class Provocation extends Capacite {

    public Provocation() {
        super("Provocation", "Empèche les attaques adverses sur votre héros");
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
    public final void executerEffetMiseEnJeu(Object cible) {}
    
}
