package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.IPlateau;
import jeu.src.Plateau;

/**Capacité à attaquer un héros rn ignorant tout serviteur avec provocation
 *
 * @author bagnato2u
 */
public class AttaqueHeros extends Attaque {

    public AttaqueHeros(String nom, String description, int damage) {
        super(nom, description, damage);
    }

    @Override
    public final void executerAction(Object cible) {
        if (this.isUse()) {
            System.out.println("deja utilise");
        }
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
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour() {}

    @Override
    public void executerEffetMiseEnJeu(Object cible) {}
    
}
