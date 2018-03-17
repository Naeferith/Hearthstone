package jeu.src;

import java.util.ArrayList;
import jeu.src.capacite.*;
import jeu.src.exception.HearthstoneException;


/**
 *
 * @author bagnato2u
 */
public class Heros {
    private static final int BASE_HP = 15; //Valeur initiale des points de vie au début d'un match'
    
    //Les héros sont définis et donc ne peuvent pas etre créée par l'utilisateur
    private static final ArrayList<Heros> HEROS = new ArrayList<Heros>();
    
    static {
        HEROS.add(new Heros("Jaina", new AttaqueCiblee("Boule de feu", "Inflige 1 point de dégat à une cible.", 1)));
        HEROS.add(new Heros("Rexxar", new AttaqueHeros("Tir Assuré", "Inflige 2 points de dégat au héros adverse.", 2)));
    };
    
    
    private String nom;
    private int pv;
    private ICapacite pouvoir;
    
    public Heros (String nom, ICapacite pouvoir) {
        this.nom = nom;
        this.pv = BASE_HP;
        this.pouvoir = pouvoir;
    }

    private Heros(Heros heros) {
        this.nom = heros.nom;
        this.pouvoir = heros.pouvoir;
        this.pv = heros.pv;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public ICapacite getPouvoir() {
        return pouvoir;
    }

    public void setPv(int pv) throws HearthstoneException {
        this.pv = pv;
        
        if (this.getPv() < 0) {
            IPlateau plateau = Plateau.getPlateau();
            plateau.gagnePartie(plateau.getAdversaire(plateau.getJoueurCourant()));
        }
    }
    
    //Séléction du héros par nom
    public static Heros getHeros(String str) throws HearthstoneException {
        for (Heros heros : HEROS) {
            if (heros.getNom().contains(str)) return new Heros(heros);
        }
        throw new HearthstoneException("Heros non trouvé.");
    }
}
