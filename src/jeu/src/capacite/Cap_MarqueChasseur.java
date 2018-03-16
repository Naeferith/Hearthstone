package jeu.src.capacite;

import jeu.src.carte.Serviteur;
/**
 *
 * @author bagnato2u
 */
public final class Cap_MarqueChasseur extends AttaqueCiblee {

    public Cap_MarqueChasseur() {
        super("Marque du chasseur", "Fais tomber les points de vie d'un serviteur à 1", 0);
    }

    @Override
    public void executerEffetMiseEnJeu(Object cible) {
        super.executerEffetMiseEnJeu(cible);
        
        if (cible instanceof Serviteur) {
            ((Serviteur) cible).setPv(1);
        }
        else ; //throw wrong target
    }
    
}
