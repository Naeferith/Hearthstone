package jeu.src;

import jeu.src.carte.ICarte;
import jeu.src.heros.Heros;
import static jeu.src.capacite.ICapacite.COUT_POUVOIR;
import jeu.src.carte.Serviteur;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import jeu.database.Deck;
import jeu.src.capacite.EffetPermanent;
import jeu.src.capacite.Provocation;
import jeu.src.exception.HearthstoneException;

/**Classe Joueur
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

    //Renvoie true si le plateau du joueur contient un serviteur avec provocation
    public boolean isProvocation() {
        for (ICarte carte : this.getJeu()) {
            if (carte.getCapacite() instanceof Provocation) return true;
        }
        return false;
    }
    
    @Override
    public void jouerCarte(ICarte carte) throws HearthstoneException {
        //Ai-je le mana suffisant ?
        if (this.getStockMana() >= carte.getCout()) {
            
            if (carte instanceof Serviteur) {
                if (this.getJeu().size() >= TAILLE_BOARD) throw new HearthstoneException("Plateau plein. Impossible de placer de nouveaux serviteurs.");
                this.getMain().remove(carte);                               //On enlève la carte de la main

                //Buff loop
                for (ICarte serv : this.getJeu()) {
                    if (serv.getCapacite() instanceof EffetPermanent) {
                        ((Serviteur) carte).setAtk(((Serviteur) carte).getAtk() + ((EffetPermanent) serv.getCapacite()).getBonusAtk());
                        ((Serviteur) carte).setPv(((Serviteur) carte).getPv() + ((EffetPermanent) serv.getCapacite()).getBonusPv());
                    }
                }
                this.getJeu().add(carte); //On ajoute la carte au plateau
            }
            else {
                //sort
            }
            carte.executerEffetDebutMiseEnJeu(carte.getProprietaire()); //Par defaut
            this.setCurrentMana(this.getStockMana() - carte.getCout()); //On soustrait le cout de la carte
            
        }
        else throw new HearthstoneException("Mana insuffisant.");
    }

    @Override
    public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
        if (cible == null) throw new HearthstoneException("Cible non trouvée.");
        if (this.getStockMana() >= carte.getCout()) {
            
            if (carte instanceof Serviteur) {
                if (this.getJeu().size() >= TAILLE_BOARD) throw new HearthstoneException("Plateau plein. Impossible de placer de nouveaux serviteurs.");
                this.getMain().remove(carte);                               //On enlève la carte de la main
                
                //Buff loop
                for (ICarte serv : this.getJeu()) {
                    if (serv.getCapacite() instanceof EffetPermanent) {
                        ((Serviteur) carte).setAtk(((Serviteur) carte).getAtk() + ((EffetPermanent) serv.getCapacite()).getBonusAtk());
                        ((Serviteur) carte).setPv(((Serviteur) carte).getPv() + ((EffetPermanent) serv.getCapacite()).getBonusPv());
                    }
                }
                this.getJeu().add(carte); //On ajoute la carte au plateau
            }
            else {
                //sort
            }
            this.setCurrentMana(this.getStockMana() - carte.getCout()); //On soustrait le cout de la carte
            carte.executerEffetDebutMiseEnJeu(cible);
        }
        else throw new HearthstoneException("Mana insuffisant.");
    }

    @Override
    public void perdreCarte(ICarte carte) throws HearthstoneException {
        //Par défaut, la cible d'une disparition de serviteur est le propriétaire de la carte
        carte.executerEffetDisparition(carte.getProprietaire());
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
        this.deck.addAll(this.heros.carteHeros(this));
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setMana(int mana) {
        if (this.getMana() < MAX_MANA) this.mana = mana;
    }

    @Override
    public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
        //aka Attaque serviteur vers cible adverse
        if (!((Serviteur) carte).canAttack()) throw new HearthstoneException("Le serviteur ne peut pas/plus attaquer ce tour.");
        if (((Serviteur) carte).getAtk() == 0) throw new HearthstoneException("Votre serviteur est trop faible pour attaquer.");
        if (cible instanceof Heros) {
            if (((Joueur) Plateau.getPlateau().getAdversaire(carte.getProprietaire())).isProvocation()) throw new HearthstoneException("Vous devez d'abbord cibles les serviteurs avec <Provocation>.");
            else ((Heros) cible).setPv(((Heros) cible).getPv() - ((Serviteur) carte).getAtk());
        }
        else {
            if (((Joueur) Plateau.getPlateau().getAdversaire(carte.getProprietaire())).isProvocation()) {
                if (((Serviteur) cible).getCapacite() instanceof Provocation) {
                    ((Serviteur) cible).setPv(((Serviteur) cible).getPv() - ((Serviteur) carte).getAtk());
                    ((Serviteur) carte).setPv(((Serviteur) carte).getPv() - ((Serviteur) cible).getAtk());
                }
                else throw new HearthstoneException("Vous devez d'abbord cibles les serviteurs avec <Provocation>.");
            }
            else {
                ((Serviteur) cible).setPv(((Serviteur) cible).getPv() - ((Serviteur) carte).getAtk());
                ((Serviteur) carte).setPv(((Serviteur) carte).getPv() - ((Serviteur) cible).getAtk());
            }
        }
    }

    @Override
    public void utiliserPouvoir(Object cible) throws HearthstoneException {
        if (this.getStockMana() < COUT_POUVOIR) throw new HearthstoneException("Mana insuffisant.");
        this.getHeros().getPouvoir().executerAction(cible);
        this.setCurrentMana(this.currentMana - COUT_POUVOIR);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.pseudo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (!Objects.equals(this.pseudo, other.pseudo)) {
            return false;
        }
        return true;
    }
    
}
