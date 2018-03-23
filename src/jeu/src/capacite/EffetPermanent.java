package jeu.src.capacite;

import jeu.src.ICarte;
import jeu.src.IJoueur;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**Capacité à altérer les stats des autres serviteurs alliés sur le terrain
 *
 * @author BAGNATO Thomas
 */
public final class EffetPermanent extends Capacite {
    private int bonusAtk;
    private int bonusPv;

    public EffetPermanent(String nom, String description, int atk, int pv) {
        super(nom, description);
        this.bonusAtk = atk;
        this.bonusPv  = pv;
    }

    public int getBonusAtk() {
        return bonusAtk;
    }

    public int getBonusPv() {
        return bonusPv;
    }

    @Override
    public final void executerAction(Object cible) {}

    @Override
    public final void executerEffetDebutTour() {}

    @Override
    public final void executerEffetDisparition(Object cible) throws HearthstoneException {
        for(ICarte carte : ((IJoueur) cible).getJeu()) {
            ((Serviteur) carte).setAtk(((Serviteur) carte).getAtk() - bonusAtk);
            if (((Serviteur) carte).getPv() - bonusPv >= ((Serviteur) carte).getBaseHp()) ((Serviteur) carte).setPv(((Serviteur) carte).getPv() - bonusPv);
            else {
                if (((Serviteur) carte).getPv() > ((Serviteur) carte).getBaseHp()) ((Serviteur) carte).setPv(((Serviteur) carte).getBaseHp());
            }
        }
    }

    @Override
    public final void executerEffetFinTour() {}

    @Override
    public final void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        for(ICarte carte : ((IJoueur) cible).getJeu()) {
            ((Serviteur) carte).setAtk(((Serviteur) carte).getAtk() + bonusAtk);
            ((Serviteur) carte).setPv(((Serviteur) carte).getPv() + bonusPv);
        }
    }
    
}
