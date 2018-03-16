package jeu.src.capacite;

/**Capacité à altérer les stats des autres serviteurs alliés sur le terrain
 *
 * @author Thømas
 */
public class EffetPermanent extends Capacite {
    private int bonusAtk;
    private int bonusPv;

    public EffetPermanent(String nom, String description, int atk, int pv) {
        super(nom, description);
        this.bonusAtk = atk;
        this.bonusPv  = pv;
    }
    

    @Override
    public void executerAction(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void executerEffetMiseEnJeu(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
