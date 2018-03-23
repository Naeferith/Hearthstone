package jeu.src.capacite;

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
    public void executerAction(Object cible) {
        //if (cible == null) 
    }

    @Override
    public void executerEffetDebutTour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executerEffetDisparition(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executerEffetFinTour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
