package jeu.src;

import static jeu.src.ICapacite.COUT_POUVOIR;
import jeu.src.carte.Serviteur;
import java.util.ArrayList;
import java.util.Random;
import jeu.database.Deck;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public class Joueur implements IJoueur {
    private final String pseudo;
    private ArrayList<ICarte> board;
    private ArrayList<ICarte> deck;
    private ArrayList<ICarte> main;
    private int mana;
    private int currentMana;
    private Heros heros;
    
    //Incrémenteur de fatigue
    private int fatigue;

    public Joueur(String pseudo, Heros heros) {
        this.pseudo = pseudo;
        this.heros = heros;
        this.board = new ArrayList<>(TAILLE_BOARD);
        this.deck = new ArrayList<>(TAILLE_DECK);
        this.main = new ArrayList<>(TAILLE_MAIN);
        this.mana = 0;
        this.fatigue = 1;
    }
            
           
            
    @Override
    public void finirTour() {
        //On vérifie les effets de fin de tour des serviteurs aliés
        for (ICarte carte : this.getJeu()) carte.executerEffetFinTour();
    }

    @Override
    public ICarte getCarteEnJeu(String nomCarte) {
        for (ICarte carte : this.getJeu()) {
            if (carte.getNom().contains(nomCarte)) return carte;
        }
        return null;
    }

    @Override
    public ICarte getCarteEnMain(String nomCarte) {
        for (ICarte carte : this.getMain()) {
            if (carte.getNom().contains(nomCarte)) return carte;
        }
        return null;
    }

    @Override
    public ArrayList<ICarte> getJeu() {
        return this.board;
    }

    @Override
    public ArrayList<ICarte> getMain() {
        return this.main;
    }

    public ArrayList<ICarte> getDeck() {
        return this.deck;
    }

    @Override
    public Heros getHeros() {
        return this.heros;
    }
    
    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public String getPseudo() {
       return this.pseudo;
    }

    @Override
    public int getStockMana() {
        return this.currentMana;
    }

    @Override
    public void jouerCarte(ICarte carte) throws HearthstoneException {
        //Ai-je le mana suffisant ?
        if (this.getStockMana() >= carte.getCout()) {
            
            if (carte instanceof Serviteur) {
                if (this.getJeu().size() >= TAILLE_BOARD) throw new HearthstoneException("Plateau plein. Impossible de placer de nouveaux serviteurs.");
                this.getMain().remove(carte);                               //On enlève la carte de la main
                this.getJeu().add(carte);                                   //On ajoute la carte au plateau
            }
            else {
                
            }
            this.setCurrentMana(this.getStockMana() - carte.getCout()); //On soustrait le cout de la carte
        }
        else throw new HearthstoneException("Mana insuffisant.");
    }

    @Override
    public void jouerCarte(ICarte carte, Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void perdreCarte(ICarte carte) throws HearthstoneException {
        //Par défaut, la cible d'une disparition de serviteur est le héros adverse
        carte.executerEffetDisparition(Plateau.getPlateau().getAdversaire(carte.getProprietaire()).getHeros());
        this.getJeu().remove(carte);
    }

    @Override
    public void piocher() throws HearthstoneException {
        //Fatigue
        if (this.getDeck().isEmpty()) {
            this.getHeros().setPv(this.getHeros().getPv() - this.fatigue);
            
            //La fatigue frappera plus fort au tour suivant
            this.setFatigue(this.fatigue + 1);
        }
        else {
            //Piochage aléatoire -> la carte quitte le deck dans tout les cas
            Random rand = new Random();
            int i = rand.nextInt(this.getDeck().size());
            ICarte carte = this.getDeck().get(i);
            this.getDeck().remove(i);
            
            if (this.getMain().size() < TAILLE_MAIN) this.getMain().add(carte);
            
            //defausse, la carte part dans le neant
            else {}
        }
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    @Override
    public void prendreTour() throws HearthstoneException {
        //Le pool de mana augmente de 1
        this.setMana(this.getMana() + 1);
        
        //Refill pool mana
        this.setCurrentMana(this.getMana());
        
        //On pioche
        this.piocher();
        
        //On vérifie les effets de début de tour des serviteurs aliés et on leur permet de réattaquer
        for (ICarte carte : this.getJeu()) carte.executerEffetDebutTour();
        
        //On réactive le pouvoir héroique
        this.getHeros().getPouvoir().setUse(false);
    }
    
    @Override
    public void setDeck() {
        this.deck.addAll(Deck.getDeckCommun(this));
        switch (this.getHeros().getNom()) {
            case "Jaina":
                this.deck.addAll(Deck.getDeckJaina(this));
                break;
            case "Rexxar":
                this.deck.addAll(Deck.getDeckRexxar(this));
                break;
            default:
                //throw ?
                break;
        }
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setMana(int mana) {
        if (this.getMana() < MAX_MANA) this.mana = mana;
    }

    @Override
    public void utiliserCarte(ICarte carte, Object cible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void utiliserPouvoir(Object cible) throws HearthstoneException {
        if (this.getStockMana() < COUT_POUVOIR) this.getHeros().getPouvoir().executerAction(cible);
        else throw new HearthstoneException("Mana insuffisant.");
    }
}
