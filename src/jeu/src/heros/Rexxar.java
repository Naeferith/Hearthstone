package jeu.src.heros;

import java.util.ArrayList;
import jeu.src.carte.ICarte;
import jeu.src.Joueur;
import jeu.src.capacite.AttaqueCiblee;
import jeu.src.capacite.AttaqueHeros;
import jeu.src.capacite.Cap_MarqueChasseur;
import jeu.src.capacite.Pioche;
import jeu.src.carte.Serviteur;
import jeu.src.carte.Sort;

/**Héros Rexxar
 *
 * @author Thømas
 */
public class Rexxar extends Heros {
    
    public Rexxar() {
        super("Rexxar", new AttaqueHeros("Tir Assuré", "Inflige 2 points de dégat au héros adverse.", 2));
    }

    @Override
    public ArrayList<ICarte> carteHeros(Joueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>();
        deck.add(new Sort("Marque du chasseur" , 1, joueur, new Cap_MarqueChasseur()));
        deck.add(new Sort("Tir des arcanes"    , 1, joueur, new AttaqueCiblee("Attaque du givre", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Sort("Lacher les chiens"  , 3, joueur, new AttaqueCiblee("Explosion pyrotechnique", "Inflige 10 points de dégat à une cible", 10)));
        deck.add(new Sort("Ordre de tuer"      , 3, joueur, new Pioche(2)));
        deck.add(new Serviteur("Busard affamé", 5, joueur, new Pioche(1), 3, 2));
        return deck;
    }
    
}
