package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.carte.Serviteur;

/**
 *
 * @author BAGNATO Thomas
 */
public class Cap_Golemisation extends Invocation {
    
    public Cap_Golemisation(IJoueur joueur) {
        super("Golemisation", "Invoque un Golem endomagé 2/1", new Serviteur("Golem endomagé", 1, joueur, null, 2, 1), 1);
    }
    
    @Override
    public void executerEffetDisparition(Object cible) {
        super.executerAction(cible);
    }
    
    @Override
    public void executerEffetMiseEnJeu(Object cible) {}
    
}
