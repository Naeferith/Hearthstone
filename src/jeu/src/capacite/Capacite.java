package jeu.src.capacite;

import jeu.src.ICapacite;

/**
 *
 * @author BAGNATO Thomas
 */
public abstract class Capacite implements ICapacite {
    private String nom;
    private String description;
    private boolean use = false; //Si la capacite est utilisee (pouvoir heroique)

    public Capacite(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    @Override
    public final void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public final boolean isUse() {
        return use;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        return "Capacite " +  nom + " : " + description + '.';
    }
}
