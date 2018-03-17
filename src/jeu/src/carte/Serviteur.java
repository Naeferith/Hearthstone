package jeu.src.carte;

import jeu.src.ICapacite;
import jeu.src.IJoueur;

/**
 *
 * @author bagnato2u
 */
public final class Serviteur extends Carte {
    private int atk;
    private int pv;

    public Serviteur(String nom, int mana, IJoueur joueur, ICapacite capacite, int atk, int pv) {
        super(nom, mana, joueur, capacite);
        this.atk = atk;
        this.pv = pv;
    }
    
    public Serviteur(Serviteur s) {
        super(s.getNom(), s.getCout(), s.getProprietaire(), s.getCapacite());
        this.atk = s.getAtk();
        this.pv  = s.getPv();
    }
    
    @Override
    public boolean disparait() {
        //TODO : Reel calcul du resultat
        return true;
    }

    @Override
    public void executerAction(Object cible) {}

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) {}

    @Override
    public void executerEffetDebutTour() {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour() {}    
    
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return atk;
    }

    public int getPv() {
        return pv;
    }
}