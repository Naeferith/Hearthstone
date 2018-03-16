package jeu.src.capacite;

/**Permet au serviteur d'attaquer au moment de sa pose
 *
 * @author bagnato2u
 */
public class Charge extends Capacite {

    public Charge() {
        super("Charge", "Permet à votre serviteur d'attaquer tout de suite.");
    }

    @Override
    public void executerAction(Object cible) {}

    @Override
    public void executerEffetDebutTour() {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour() {}

    @Override
    public void executerEffetMiseEnJeu(Object cible) {
        //Un serviteur posé avec charge peut ne pas attaquer.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
