package jeu.src.capacite;

/**Une Attaque représente toute capacité infligeant des dégats à une ou plusieures cibles.
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