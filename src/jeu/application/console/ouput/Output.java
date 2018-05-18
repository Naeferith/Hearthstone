package jeu.application.console.ouput;

import java.util.ArrayList;
import java.util.Scanner;
import jeu.src.carte.ICarte;
import jeu.src.IPlateau;
import jeu.src.Plateau;
import jeu.src.capacite.Provocation;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**Classe concue spécialement pour contenir les affichages sur la console.
 *
 * @author BAGNATO Thomas
 */
public final class Output {
    private static final IPlateau PLATEAU = Plateau.getPlateau();
    
    public static DialogInterface initMainMenu() {
        DialogInterface ihm = null;
        
        ihm = new InterfaceAddPlayer(ihm);
        ihm = new InterfacePlay(ihm);
        ihm = new InterfaceQuit(ihm);
        
        return ihm;
    }
    
    public static DialogInterface initGameMenu() {
        DialogInterface ihm = null;
        
        ihm = new InterfaceEndTurn(ihm);
        ihm = new InterfaceHeroPowerAttack(ihm);
        ihm = new InterfaceMobAttack(ihm);
        ihm = new InterfacePlayCard(ihm);
        ihm = new InterfaceDisplayBoard(ihm);
        ihm = new InterfaceDisplayHand(ihm);
        
        return ihm;
    }
    
    public static String printMenu(DialogInterface di) {
        Scanner scanIn = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        DialogInterface localDi = di;
        //Sauter unr ligne
        System.out.println("");
        while (localDi != null) {
            menu.add(localDi.getDescription());
            localDi = localDi.getNext();
        }
        
        int n = 0;
        if (PLATEAU.estDemaree()) System.out.println("[Tour de "+ PLATEAU.getJoueurCourant().getPseudo() + "]\n");
        for (String s : menu) {
            System.out.println("" + n + ". " + s);
            n += 1;
        }
        
        System.out.println("Votre choix :");
        return menu.get(Integer.parseInt(scanIn.nextLine()));
    }
    
    public static final void printHand() {
        System.out.println("Votre main :");
        for (ICarte carte : PLATEAU.getJoueurCourant().getMain()) System.out.println(carte.toString());
    }
    
    public static final void printMenuAction() {
        System.out.println("1. Afficher Main");
        System.out.println("2. Afficher Jeu");
        System.out.println("3. Jouer Carte");
        System.out.println("4. Attaquer");
        System.out.println("5. Utiliser pouvoir Héroique");
        System.out.println("0. Finir le tour");
        System.out.print("Choix : ");
    }
    
    public static final void printMenuAttack() {
        printHand();
        System.out.print("Quelle carte voulez vous jouer ? : ");
    }
    
    public static final void printOpponentStat() throws HearthstoneException {
        System.out.println(PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getNom() + " : " + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getPv() + "pv");
    }
    
    public static final void printPlayerStat() {
        System.out.println(PLATEAU.getJoueurCourant().getHeros().getNom() + " : " + PLATEAU.getJoueurCourant().getHeros().getPv() +"pv / " 
                + PLATEAU.getJoueurCourant().getStockMana() + " mana restant");
    }
    
    public static final void printNewGameSummary() throws HearthstoneException {
        System.out.println("Nouvelle partie : " + PLATEAU.getJoueurCourant().getHeros().getNom() 
                + " (" + PLATEAU.getJoueurCourant().getPseudo() + ") contre " 
                + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getHeros().getNom() 
                + " (" + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getPseudo() + ")");
    }
    
    public static final void printBoard() throws HearthstoneException {
        printOpponentBoard();
        printCurrentBoard();
    }
    
    public static final void printCurrentBoard() {
        System.out.println("-----------------------------------------------");
        System.out.println("Votre terrain : " + PLATEAU.getJoueurCourant().getJeu().size() + " serviteurs");
        for (ICarte carte : PLATEAU.getJoueurCourant().getJeu()) System.out.println("> " + ((Serviteur) carte).toString() + ((((Serviteur) carte).getCapacite() instanceof Provocation) ? " | <Provocation>": ""));
    }
    
    public static final void printOpponentBoard() throws HearthstoneException {
        System.out.println("-----------------------------------------------");
        System.out.println("Adversaire : " + PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getJeu().size() + " serviteurs");
        for (ICarte carte : PLATEAU.getAdversaire(PLATEAU.getJoueurCourant()).getJeu()) System.out.println("> " + ((Serviteur) carte).toString() + ((((Serviteur) carte).getCapacite() instanceof Provocation) ? " | <Provocation>": ""));
    }
}
