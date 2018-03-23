package jeu.src.capacite;

import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;
/**
 *
 * @author BAGNATO Thomas
 */
public final class Cap_MarqueChasseur extends AttaqueCiblee {

    public Cap_MarqueChasseur() {
        super("Marque du chasseur", "Fais tomber les points de vie d'un serviteur à 1", 0);
    }

    @Override
    public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        super.executerEffetMiseEnJeu(cible);
        
        if (cible instanceof Serviteur) ((Serviteur) cible).setPv(1);
        else throw new HearthstoneException("La cible doit etre un serviteur."); //throw wrong target
    }
    
}
