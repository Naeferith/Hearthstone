package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.exception.HearthstoneException;

/**Capacité à piocher un nombre défini de cartes
 *
 * @author BAGNATO Thomas
 */
public final class Pioche extends Capacite {
    private int quantite;

    public Pioche(int quantite) {
        super("Pioche", "Vous piochez " + quantite + " cartes.");
        this.quantite = quantite;
    }

    @Override
    public final void executerAction(Object cible) throws HearthstoneException {
        for (int i = 0; i < this.quantite; i++) ((IJoueur) cible).piocher();
    }

    @Override
    public final void executerEffetDebutTour() {}

    @Override
    public final void executerEffetDisparition(Object cible) {}

    @Override
    public final void executerEffetFinTour() {}

    @Override
    public final void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        this.executerAction(cible);
    }
    
    
}
