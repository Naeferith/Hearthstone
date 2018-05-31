package jeu.src.capacite;

import jeu.src.IJoueur;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**Capacité de la carte Gnome Lépreux
 *
 * @author BAGNATO Thomas
 */
public final class Cap_Lepreux extends AttaqueHeros {
    
    public Cap_Lepreux() {
        super("Attaque du lépreux", "Rale d'agonie : Inflige 2 points de dégat au héros adverse", 2);
    }

    @Override
    public final void executerEffetDisparition(Object cible) throws HearthstoneException {
        //La cible est toujours la meme: le heros adversaire DU PROPRIETAIRE de la carte
        super.executerAction(Plateau.getPlateau().getAdversaire((IJoueur) cible).getHeros());
    }
    
    @Override
    public final void executerEffetMiseEnJeu (Object cible) throws HearthstoneException {}
}