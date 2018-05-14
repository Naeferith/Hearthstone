package jeu.src.capacite;

import jeu.src.carte.ICarte;
import jeu.src.IJoueur;
import jeu.src.Plateau;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**Capacité à appliquer un effet et/ou infliger des dégats au board adverse
 *
 * @author BAGNATO Thomas
 */
public class AttaqueTotale extends Attaque {

    public AttaqueTotale(String nom, String description, int damage) {
        super(nom, description, damage);
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if (cible instanceof IJoueur) {
            for (ICarte carte : Plateau.getPlateau().getAdversaire((IJoueur) cible).getJeu()) ((Serviteur) carte).setPv(((Serviteur) carte).getPv() - damage);
        }
        else throw new HearthstoneException("Cible incorrecte.");
    }

    @Override
    public void executerEffetDebutTour() {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour() {}

    @Override
    public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        this.executerAction(cible);
    }
}
