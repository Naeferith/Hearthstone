package jeu.src.heros;

import java.util.ArrayList;
import jeu.src.carte.ICarte;
import jeu.src.Joueur;
import jeu.src.capacite.AttaqueCiblee;
import jeu.src.capacite.AttaqueTotale;
import jeu.src.capacite.Cap_ImageMiroir;
import jeu.src.capacite.Pioche;
import jeu.src.carte.Sort;

/**Héros Jaina
 *
 * @author Thømas
 */
public class Jaina extends Heros {
    
    public Jaina() {
        super("Jaina", new AttaqueCiblee("Boule de feu", "Inflige 1 point de dégat à une cible.", 1));
    }
    
    @Override
    public ArrayList<ICarte> carteHeros(Joueur joueur) {
        ArrayList<ICarte> deck = new ArrayList<>();
        deck.add(new Sort("Choc de flammes"         , 7 , joueur, new AttaqueTotale("Attaque Massive", "Inflige 4 points de dégat aux serviteurs adverses", 4)));
        deck.add(new Sort("Eclair de givre"         , 2 , joueur, new AttaqueCiblee("Attaque du givre", "Inflige 5 points de dégats au héros adverse", 5)));
        deck.add(new Sort("Explosion Pyrotechnique" , 10, joueur, new AttaqueCiblee("Explosion pyrotechnique", "Inflige 10 points de dégat à une cible", 10)));
        deck.add(new Sort("Intelligence des arcanes", 2 , joueur, new Pioche(2)));
        deck.add(new Sort("Image miroir"            , 1 , joueur, new Cap_ImageMiroir()));
        return deck;
    }
}
