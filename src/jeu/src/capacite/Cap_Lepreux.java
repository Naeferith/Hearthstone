package jeu.src.capacite;

import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public class Cap_Lepreux extends AttaqueHeros {
    
    public Cap_Lepreux() {
        super("Attaque du lépreux", "Rale d'agonie : Inflige 2 points de dégat au héros adverse", 2);
    }

    @Override
    public void executerEffetDisparition(Object cible) throws HearthstoneException {
        //La cible est toujours la meme: le heros adversaire DU PROPRIETAIRE de la carte
        super.executerAction(cible);
    }
}
