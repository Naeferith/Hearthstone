package jeu.src.capacite;

/**Capacité à obliger les serviteurs adverses à attaquer un serviteur avec Provocation avant toute autre cible
 *
 * @author BAGNATO Thomas
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