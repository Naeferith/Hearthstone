package jeu.src;

import java.util.ArrayList;
import java.util.Random;
import jeu.src.capacite.Provocation;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public class Plateau implements IPlateau {
    private static IPlateau plateau = null; //Instance unique de plateau
    private boolean enCours = false;
    private IJoueur joueurCourant = null;
    private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
    
    //Il ne doit y avoir qu'une seule instance de plateau, on l'initialise a chaque début de partie
    public static IPlateau getPlateau() {
        if (plateau == null) plateau = new Plateau();
        return plateau;
    }
    
    @Override
    public final void ajouterJoueur(IJoueur joueur) throws HearthstoneException{
        if (this.joueurs.size() == 2) throw new HearthstoneException("La partie est complète.");
        if (this.joueurs.contains(joueur)) throw new HearthstoneException("Le joueur est déja en partie.");
        this.joueurs.add(joueur);
    }

    @Override
    public final void demarrerPartie() throws HearthstoneException {
        if (this.estDemaree()) throw new HearthstoneException("La partie est déja en cours.");
        if (this.joueurs.size() != 2) throw new HearthstoneException("2 joueurs sont requis pour commencer une partie.");
        this.enCours = true;
        
        //Détermination du 1er joueur
        Random rand = new Random();
        int i = rand.nextInt(2);
        this.setJoueurCourant(this.joueurs.get(i));
        
        //Mise en place des decks
        plateau.getJoueurCourant().setDeck();
        plateau.getAdversaire(plateau.getJoueurCourant()).setDeck();
        
        //Mise en place de la main de départ (pas de redraw pour le moment)
        for(int j = 0; j < 3; j++) {
            plateau.getJoueurCourant().piocher();
            plateau.getAdversaire(plateau.getJoueurCourant()).piocher();
        }
        
        this.getJoueurCourant().prendreTour(); //Le joueur prend la main
    }

    @Override
    public final boolean estDemaree() {
        return this.enCours;
    }

    @Override
    public final void finTour(IJoueur joueur) throws HearthstoneException {
        this.getJoueurCourant().finirTour();                //Fin de tour du joueur
        this.setJoueurCourant(this.getAdversaire(joueur));  //Changement de joueur courant
        this.getJoueurCourant().prendreTour();              //Le nouveau joueur prend la main
    }

    @Override
    public final void gagnePartie(IJoueur joueur) throws HearthstoneException {
        System.out.println(this.getAdversaire(joueur).getPseudo() + " [" + this.getAdversaire(joueur).getHeros().getNom() + "] à gagné.");
        
        //Fin de partie
        this.enCours = false;
        
        //Reinitialisation du plateau
        plateau = null;
    }

    @Override
    public final IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
        if (!this.estDemaree()) throw new HearthstoneException("La partie n'est pas encore commencée.");
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
    
    //Renvoie true si le plateau du joueur contient un serviteur avec provocation
    public boolean isProvocation(IJoueur joueur) {
        for (ICarte carte : joueur.getJeu()) {
            if (carte.getCapacite() instanceof Provocation) return true;
        }
        return false;
    }
    
}
