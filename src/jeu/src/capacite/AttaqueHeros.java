package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**Capacité à attaquer un héros en ignorant tout serviteur avec provocation
 *
 * @author bagnato2u
 */
public class AttaqueHeros extends Attaque {

    public AttaqueHeros(String nom, String description, int damage) {
        super(nom, description, damage);
    }

    @Override
    public final void executerAction(Object cible) throws HearthstoneException {
        if (this.isUse()) throw new HearthstoneException("Pouvoir héroique déja utilisé ce tour.");
        else {
            this.setUse(true);
            IPlateau plateau = Plateau.getPlateau();
            IJoueur adv = plateau.getAdversaire(plateau.getJoueurCourant());
            adv.getHeros().setPv(adv.getHeros().getPv() - this.damage);
        }
    }

    @Override
    public void executerEffetDebutTour() {}

    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {}

    @Override
    public void executerEffetFinTour() {}

    @Override
    public void executerEffetMiseEnJeu(Object cible) {}
    
}
