package jeu.src.capacite;

import jeu.src.ICapacite;

/**
 *
 * @author bagnato2u
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
    
    //usable ?
    public enum Effect {
        Charge,                     //Charge
        Provocation,                //Taunt
        Attaque_du_heros,           //Ignore Taunt mobs
        Attaque_ciblee,             //Basic atk movement (may be always)
        Attaque_totale,             //Full board atk
        Effet_permanent,            //Permanent buff [deltaATK:deltaPV]
        Pioche,                     //Draw x cards [x]
        Invocation_de_serviteurs,   //Summon x mobs [x:nom:ATK:PV]
        Invocation_de_chiens,       //Spell [Lacher les chiens]
        Image_Miroir,               //Spell [Image mirroir]
        Marque_du_chasseur          //Spell [Marque du chasseur]
    }
}
