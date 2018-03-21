package jeu.application.console.ouput;

import jeu.src.ICarte;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author Thømas
 */
public final class Output {
    private static final IPlateau PLATEAU = Plateau.getPlateau();
    
    public static final void printMenuAction() {
        System.out.println("1. Afficher Main");
        System.out.println("2. Afficher Jeu");
        System.out.println("3. Jouer Carte");
        System.out.println("4. Attaquer");
        System.out.println("5. Utiliser pouvoir Héroique");
        System.out.println("0. Finir le tour");
        System.out.println("Choix :");
    }
    
    public static final void printOpponentStat() throws HearthstoneException {
        System.out.println(PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getNom() + " : " + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getPv() + "pv");
    }
    
    public static final void printPlayerStat() {
        System.out.println(PLATEAU.getJoueurCourant().getHeros().getNom() + " : " + PLATEAU.getJoueurCourant().getHeros().getPv() +"pv / " 
                + PLATEAU.getJoueurCourant().getStockMana() + " mana restant");
    }
    
    public static final void printHand() {
        System.out.println("Nombre de cartes " + PLATEAU.getJoueurCourant().getMain().size());
        for (ICarte carte : PLATEAU.getJoueurCourant().getMain()) System.out.println(carte.toString());
    }
    
    public static final void printNewGameSummary() throws HearthstoneException {
        System.out.println("Nouvelle partie : " + PLATEAU.getJoueurCourant().getHeros().getNom() 
                + " (" + PLATEAU.getJoueurCourant().getPseudo() + ") contre " 
                + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getNom() 
                + " (" + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getPseudo() + ")");
    }
    
    public static final void printBoard() throws HearthstoneException {
        System.out.println("-----------------------------------------------");
        System.out.println("Adversaire : " + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getJeu().size() + " serviteurs");
        for (ICarte carte : PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getJeu()) System.out.println(">" + carte.toString());
        System.out.println("-----------------------------------------------");
        System.out.println("Votre terrain :" + PLATEAU.getJoueurCourant().getJeu().size());
        for (ICarte carte : PLATEAU.getJoueurCourant().getJeu()) System.out.println(">" + carte.toString());
    }
}
