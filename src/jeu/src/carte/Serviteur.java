package jeu.src.carte;

import jeu.src.capacite.Capacite;
import jeu.src.IJoueur;

/**
 *
 * @author bagnato2u
 */
public final class Serviteur extends Carte {
    private int atk;
    private int pv;

    public Serviteur(String nom, int mana, IJoueur joueur, Capacite capacite, int atk, int pv) {
        super(nom, mana, joueur, capacite);
        this.atk = atk;
        this.pv = pv;
    }
    
    @Override
    public boolean disparait() {
        return true;
    }

    @Override
    public void executerAction(Object cible) {}

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) {}

    @Override
    public void executerEffetDebutTour(Object cible) {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour(Object cible) {}    
    
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