/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.src;

import java.util.ArrayList;
import java.util.Random;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public class Plateau implements IPlateau {
    private static IPlateau plateau = null; //Instance unique de plateau
    private boolean enCours = false;
    private IJoueur joueurCourant = null;
    private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
    
    //Il ne doit y avoir qu'une seule instance de plateau
    public static IPlateau getPlateau() {
        if (plateau == null) plateau = new Plateau();
        return plateau;
    }
    
    @Override
    public final void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
        if (this.joueurs.size() == 2) throw new HearthstoneException("La partie est déja complète.");
        if (this.joueurs.contains(joueur)) throw new HearthstoneException("Le joueur est déja dans la partie");
        this.joueurs.add(joueur);
    }

    @Override
    public final void demarrerPartie() throws HearthstoneException {
        if (this.estDemaree()) throw new HearthstoneException("La partie est déja en cours.");
        if (this.joueurs.size() != 2) throw new HearthstoneException("Il faut 2 joueurs pour commencer une partie");
        
        //Détermination du 1er joueur
        Random rand = new Random();
        int i = rand.nextInt(2);
        this.setJoueurCourant(this.joueurs.get(i));
        this.estDemaree();
        this.getJoueurCourant().prendreTour();              //Le joueur prend la main
    }

    @Override
    public final boolean estDemaree() {
        return this.enCours;
    }

    @Override
    public final void finTour(IJoueur joueur) {
        this.setJoueurCourant(this.getAdversaire(joueur));  //Changement de joueur courant
        this.getJoueurCourant().prendreTour();              //Le nouveau joueur prend la main
    }

    @Override
    public final void gagnePartie(IJoueur joueur) {
        System.out.println(this.getAdversaire(joueur).getPseudo() + " [" + this.getAdversaire(joueur).getHeros().getNom() + "] à gagné.");
        //Fin de partie
        this.enCours = false;
        //Reinitialisation du plateau
        plateau = null;
    }

    @Override
    public final IJoueur getAdversaire(IJoueur joueur) {
        if (!this.estDemaree()) ;//Exception la partie doit etre démarée
        return (this.getJoueurCourant() == this.joueurs.get(0)) ? this.joueurs.get(1) : this.joueurs.get(0);
    }

    @Override
    public final IJoueur getJoueurCourant() {
        return this.joueurCourant;
    }

    @Override
    public final void setJoueurCourant(IJoueur joueur) {
        this.joueurCourant = joueur;
    }
    
}
