package jeu.src.capacite;

/**
 *
 * @author Thømas
 */
public class Cap_Lepreux extends AttaqueHeros {
    
    public Cap_Lepreux() {
        super("Attaque du lépreux", "Rale d'agonie : Inflige 2 points de dégat au héros adverse", 2);
    }

    @Override
    public void executerEffetDisparition(Object cible) {
        super.executerAction(cible);
    }
}
