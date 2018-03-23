package jeu.src.capacite;

/**
 *
 * @author BAGNATO Thomas
 */
public abstract class Attaque extends Capacite {
    protected int damage;

    public Attaque(String nom, String description, int damage) {
        super(nom, description);
        this.damage = damage;
    } 
    
}
