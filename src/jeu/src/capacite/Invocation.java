/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

import jeu.src.carte.Serviteur;

/**
 *
 * @author Thømas
 */
public class Invocation extends Capacite {
    private Serviteur nouveauServiteur = null;
    private int effectif; 
    
    public Invocation(String nom, String description, Serviteur serviteur, int effectif) {
        super(nom, description);
        this.nouveauServiteur = serviteur;
        this.effectif = effectif;
    }

    @Override
    public void executerAction(Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
