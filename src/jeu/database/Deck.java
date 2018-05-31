package jeu.database;

import java.util.ArrayList;
import jeu.src.carte.ICarte;
import jeu.src.IJoueur;
import jeu.src.capacite.*;
import jeu.src.carte.Serviteur;
import jeu.src.carte.Sort;

/**Classe comportant le deck commun à tout les héros
 *
 * @author BAGNATO Thomas
 */
public class Deck {
    //On admet, un deck = 10 cartes communes + 5 cartes de classe
    
    //Le deck commun
    public static ArrayList<ICarte> getDeckCommun(IJoueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>(IJoueur.TAILLE_DECK);
        //deck.add(new Sort("Charge"                     , 1, joueur, new Cap_Charge()));
        deck.add(new Sort("Attaque mentale"            , 2, joueur, new AttaqueHeros("Attaque mentale", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Serviteur("Garde de baie-du-butin", 5, joueur, new Provocation(), 5, 4));
        deck.add(new Serviteur("Champion de Hurlevent" , 7, joueur, new EffetPermanent("Bonus de Hurlevent", "Vos autres serviteurs ont +1/+1", 1, 1), 6, 6));
        deck.add(new Serviteur("Chef de raid"          , 3, joueur, new EffetPermanent("Bonus du Chef de raid", "Vos autres serviteurs ont +1/+0", 1, 0), 2, 2));
        deck.add(new Serviteur("Missilière téméraire"  , 6, joueur, new Charge(), 5, 2));
        deck.add(new Serviteur("Ogre-Magi"             , 4, joueur, new Provocation(), 4, 4));
        deck.add(new Serviteur("Archimage"             , 6, joueur, new Provocation(), 4, 7));
        deck.add(new Serviteur("Gnome Lépreux"         , 1, joueur, new Cap_Lepreux(), 1, 1));
        deck.add(new Serviteur("Golem des moissons"    , 3, joueur, new Cap_Golemisation(joueur), 2, 3));
        return deck;
    }
}