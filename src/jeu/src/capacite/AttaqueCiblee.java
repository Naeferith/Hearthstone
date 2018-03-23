package jeu.src.capacite;

import jeu.src.Heros;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**Capacité à appliquer un effet (serviteur seulement) et/ou infliger des dégats une cible quelconque
 *
 * @author BAGNATO Thomas
 */
public class AttaqueCiblee extends Attaque {

    public AttaqueCiblee(String nom, String description, int damage) {
        super(nom, description, damage);
    }

    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if (cible == null) throw new HearthstoneException("Cible non trouvée.");
        if (cible instanceof Heros) ((Heros) cible).setPv(((Heros) cible).getPv() - damage);
        else ((Serviteur) cible).setPv(((Serviteur) cible).getPv() - damage);
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
