/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.IPlateau;
import jeu.src.Plateau;

/**
 *
 * @author bagnato2u
 */
public class AttaqueHeros extends Attaque {

    public AttaqueHeros(String nom, String description, int damage) {
        super(nom, description, damage);
    }

    @Override
    public final void executerAction(Object cible) {
        if (this.isUse()) {
            System.out.println("deja utilise");
        }
        else {
            this.setUse(true);
            IPlateau plateau = Plateau.getPlateau();
            IJoueur adv = plateau.getAdversaire(plateau.getJoueurCourant());
            adv.getHeros().setPv(adv.getHeros().getPv() - this.damage);
        }
    }

    @Override
    public void executerEffetDebutTour() {}

    @Override
    public void executerEffetDisparition(Object cible) {}

    @Override
    public void executerEffetFinTour() {}

    @Override
    public void executerEffetMiseEnJeu(Object cible) {}
    
}
