package jeu.src.heros;

import java.util.ArrayList;
import jeu.src.capacite.ICapacite;
import jeu.src.carte.ICarte;
import jeu.src.IPlateau;
import jeu.src.Joueur;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;


/**Classe pour les heros
 *
 * @author BAGNATO Thomas
 */
public abstract class Heros implements IHeros{
    private static final int BASE_HP = 15; //Valeur initiale des points de vie au début d'un match
    
    //Les héros sont définis et donc ne peuvent pas etre créée par l'utilisateur
    private static final ArrayList<Heros> HEROS = new ArrayList<Heros>();
    static {
        HEROS.add(new Jaina());
        HEROS.add(new Rexxar());
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
        //Si on applique un soin, on ne peut pas depasser les pv max du heros
        this.pv = (pv > BASE_HP) ? BASE_HP: pv;
        
        if (this.pv <= 0) {
            IPlateau plateau = Plateau.getPlateau();
            plateau.gagnePartie(plateau.getAdversaire(plateau.getJoueurCourant()));
        }
    }
    
    //Séléction du héros par nom
    public static Heros getHeros(String str) throws HearthstoneException, InstantiationException, IllegalAccessException {
        for (Heros heros : HEROS) {
            if (heros.getNom().contains(str)) return heros.getClass().newInstance();
        }
        throw new HearthstoneException("Heros non trouvé.");
    }
    
    //Complément au deck commun
    @Override
    public abstract ArrayList<ICarte> carteHeros(Joueur joueur);
}