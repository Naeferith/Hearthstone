/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src.capacite;

import java.util.ArrayList;
import jeu.src.ICarte;
import jeu.src.IJoueur;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.carte.Serviteur;

/**Capacité à invoquer un ou plusieurs serviteurs identiques
 * 
 * @author Thømas
 */
public class Invocation extends Capacite {
    private ICarte nouveauServiteur;
    private final int effectif; 
    
    public Invocation(String nom, String description, ICarte serviteur, int effectif) {
        super(nom, description);
        this.nouveauServiteur = serviteur;
        this.effectif = effectif;
    }

    @Override
    public void executerAction(Object cible) {
        //Invoquer n serviteurs ne requiert pas de cible, il faut juste les mettre sur le board
        ArrayList<ICarte> nouveauxServiteurs = new ArrayList<>();
        IPlateau plateau = Plateau.getPlateau();
        IJoueur cur = plateau.getJoueurCourant();
        
        //Nombre réel de serviteurs à invoquer
        int n = (cur.getJeu().size() + effectif <= IJoueur.TAILLE_BOARD) ? cur.getJeu().size() + effectif : IJoueur.TAILLE_BOARD - cur.getJeu().size() ;
        
        //Création des nouveaux serviteurs
        for (int i = 0; i < n; i++) nouveauxServiteurs.add(new Serviteur((Serviteur) this.nouveauServiteur));
        
        //Les nouveaux serviteurs joignent le board
        cur.getJeu().addAll(nouveauxServiteurs);
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