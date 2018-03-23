package jeu.database;

import java.util.ArrayList;
import jeu.src.ICarte;
import jeu.src.IJoueur;
import jeu.src.capacite.*;
import jeu.src.carte.Serviteur;
import jeu.src.carte.Sort;

/**
 *
 * @author BAGNATO Thomas
 */
public class Deck {
    //On admet, un deck = 10 cartes communes + 5 cartes de classe
    
    //Le deck commun
    public static ArrayList<ICarte> getDeckCommun(IJoueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>(IJoueur.TAILLE_DECK);
        deck.add(new Sort("Charge", 1, joueur, new Charge()));
        deck.add(new Sort("Attaque mentale", 2, joueur, new AttaqueHeros("Attaque mentale", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Serviteur("Garde de baie-du-butin", 5, joueur, new Provocation(), 5, 4));
        deck.add(new Serviteur("Champion de Hurlevent" , 7, joueur, new EffetPermanent("Bonus de Hurlevent", "Vos autres serviteurs ont +1/+1", 1, 1), 6, 6));
        deck.add(new Serviteur("Chef de raid"          , 3, joueur, new EffetPermanent("Bonus du Chef de raid", "Vos autres serviteurs ont +1/+0", 1, 0), 2, 2));
        deck.add(new Serviteur("Missilière téméraire"  , 6, joueur, new Charge(), 5, 2));
        deck.add(new Serviteur("Ogre-Magi"             , 4, joueur, new Provocation(), 4, 4));
        deck.add(new Serviteur("Archimage"             , 6, joueur, new Provocation(), 4, 7));
        deck.add(new Serviteur("Gnome Lépreux"         , 1, joueur, new Cap_Lepreux(), 1, 1));
        //deck.add(new Serviteur("Garde de baie-du-butin", 5, joueur, new Provocation(), 5, 4));
        return deck;
    }
    
    //Le complément de Jaina
    public static ArrayList<ICarte> getDeckJaina(IJoueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>();
        deck.add(new Sort("Choc de flammes"         , 7 , joueur, new AttaqueTotale("Attaque Massive", "Inflige 4 points de dégat aux serviteurs adverses", 4)));
        deck.add(new Sort("Eclair de givre"         , 2 , joueur, new AttaqueCiblee("Attaque du givre", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Sort("Explosion Pyrotechnique" , 10, joueur, new AttaqueCiblee("Explosion pyrotechnique", "Inflige 10 points de dégat à une cible", 10)));
        deck.add(new Sort("Intelligence des arcanes", 2 , joueur, new Pioche(2)));
        deck.add(new Sort("Image miroir"            , 1 , joueur, new Invocation("Image miroir", "Invoque 2 serviteurs 0/2 avec Provocation", new Serviteur("Image Rémanente", 1, joueur, new Provocation(), 0, 2), 2)));
        return deck;
    }
    
    //Le complément de Rexxar
    public static ArrayList<ICarte> getDeckRexxar(IJoueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>();
        deck.add(new Sort("Marque du chasseur" , 1, joueur, new Cap_MarqueChasseur()));
        deck.add(new Sort("Tir des arcanes"    , 1, joueur, new AttaqueCiblee("Attaque du givre", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Sort("Lacher les chiens"  , 3, joueur, new AttaqueCiblee("Explosion pyrotechnique", "Inflige 10 points de dégat à une cible", 10)));
        deck.add(new Sort("Ordre de tuer"      , 3, joueur, new Pioche(2)));
        deck.add(new Serviteur("Busard affamé", 5, joueur, new Pioche(1), 3, 2));
        return deck;
    }
}
