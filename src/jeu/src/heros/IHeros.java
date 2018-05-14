package jeu.src.heros;

import java.util.ArrayList;
import jeu.src.carte.ICarte;
import jeu.src.Joueur;

/**Interface pour les héros
 *
 * @author Thømas
 */
public interface IHeros {
    //Ajoute le complément au deck selon la classe du héros
    public abstract ArrayList<ICarte> carteHeros(Joueur joueur);
}
