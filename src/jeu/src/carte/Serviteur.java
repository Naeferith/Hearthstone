package jeu.src.carte;

import jeu.src.Heros;
import jeu.src.ICapacite;
import jeu.src.IJoueur;
import jeu.src.Joueur;
import jeu.src.Plateau;
import jeu.src.capacite.Charge;
import jeu.src.capacite.Provocation;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public final class Serviteur extends Carte {
    private int atk;
    private int pv;
    private final int baseHp;   //Les pv originaux du serviteur
    private int nbCoup;         //Le nombre d'attaque du serviteur (e.g. furie des vents = 2)
    private int nbCoupStock;    //Le nombre d'attaque restant pour ce tour

    public Serviteur(String nom, int mana, IJoueur joueur, ICapacite capacite, int atk, int pv) {
        super(nom, mana, joueur, capacite);
        this.atk = atk;
        this.pv = this.baseHp = pv;
    }
    
    public Serviteur(Serviteur s) {
        super(s.getNom(), s.getCout(), s.getProprietaire(), s.getCapacite());
        this.atk = s.getAtk();
        this.pv  = s.getPv();
        this.baseHp = s.baseHp;
    }
    
    @Override
    public final boolean disparait() {
        return this.pv <= 0;
    }

    @Override
    public final void executerAction(Object cible) throws HearthstoneException {
        //Quand un serviteur attaque
        if (cible == null) throw new HearthstoneException("La cible ne peut pas etre nulle.");
        
        Plateau plateau = (Plateau) Plateau.getPlateau();
        IJoueur adv = plateau.getAdversaire(plateau.getJoueurCourant());
        
        //Si la cible est un heros, il ne doit pas y avoir de serviteurs sur le terrain
        if (cible instanceof Heros) {
            if (((Joueur) adv).isProvocation()) throw new HearthstoneException("Il faut d'abbord éliminer les serviteurs avec provocation.");
            else ((Heros) cible).setPv( ((Heros) cible).getPv() - this.atk);
        }
        //Si la cible est un serviteur, il doit avoir Provocation en priorité
        else {
            if (!(((Serviteur) cible).getCapacite() instanceof Provocation)) ((Serviteur) cible).setPv( ((Serviteur) cible).getPv() - this.atk);
            else throw new HearthstoneException("Il faut d'abbord éliminer les serviteurs avec provocation.");
        }
    }

    @Override
    public final void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
        //On initialise les coups
        //Comme furie des vents n'est pas implémenté, on supose qu'un serviteur n'attaque qu'une fois par tour
        this.nbCoup = 1;
        this.nbCoupStock = (this.getCapacite() instanceof Charge) ? 1 : 0;
        this.getCapacite().executerEffetMiseEnJeu(cible);
    }

    @Override
    public final void executerEffetDebutTour() {
        //On reinitialise les coups
        this.nbCoupStock = this.nbCoup;
        this.getCapacite().executerEffetDebutTour();
    }

    @Override
    public final void executerEffetDisparition(Object cible) throws HearthstoneException {
        this.getCapacite().executerEffetDisparition(cible);
    }

    @Override
    public final void executerEffetFinTour() {
        this.getCapacite().executerEffetFinTour();
    }
    
    public boolean canAttack() {
        return this.nbCoupStock > 0;
    }
    
    public int getAtk() {
        return atk;
    }

    public int getPv() {
        return pv;
    }
    
    public int getBaseHp() {
        return baseHp;
    }
    
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setPv(int pv) throws HearthstoneException {
        this.pv = pv;
        if (this.disparait()) this.getProprietaire().perdreCarte(this);
    }
    
    @Override
    public String toString() {
        return "[Serviteur] " + super.toString() + " | " + atk +  " atk / " + pv + " pv";
    }
}