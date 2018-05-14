package jeu.application;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.application.console.ouput.Output;
import jeu.src.heros.Heros;
import jeu.src.carte.ICarte;
import jeu.src.IPlateau;
import jeu.src.Joueur;
import jeu.src.Plateau;
import jeu.src.capacite.AttaqueCiblee;
import jeu.src.carte.Serviteur;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author BAGNATO Thomas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Etablissement du plateau
        //IPlateau plateau = Plateau.getPlateau();
        //Creation des 2 adversaires
        //try {
        //    Joueur j1 = new Joueur("John Cena", Heros.getHeros("Jaina"));
        //    Joueur j2 = new Joueur("BeastMaster64", Heros.getHeros("Rexxar"));
        //    plateau.ajouterJoueur(j1);
        //plateau.ajouterJoueur(j2);
        //}
        //catch (HearthstoneException e) {
            
        //}
        
        //Commencer la partie
        //plateau.demarrerPartie();
        //----------------------------------------------------------------------------------------- ^_Static_^
        // ---------------------------------------------------------------------------------------- v_Dynamic_v
        String input;
        Scanner scanIn = new Scanner(System.in);
        
        IPlateau plateau = Plateau.getPlateau();
        
        while (true) {
            System.out.println("> Bienvenue dans Hearstone (c'est pas exactement comme Hearthstone mais on en est pas loin)");
            System.out.println("-------------------------------------------");
            System.out.println("1. Démarrer la partie");
            System.out.println("2. Ajouter un nouveau joueur dans la partie");
            System.out.println("0. Quitter");
            System.out.println("-------------------------------------------");
            System.out.print("Choix : ");
            input = scanIn.nextLine();
            
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    try {
                        plateau.demarrerPartie();
                        StartGame();
                    }
                    catch (HearthstoneException e){
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;
                case "2": {
                    String pseudo = "";
                    Heros heros = null;
                    do {
                        System.out.print("Pseudo : ");
                        pseudo = scanIn.nextLine();
                        System.out.print("Choix du héros : ");
                        try {
                            heros = Heros.getHeros(scanIn.nextLine());
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (HearthstoneException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
                        
                    }
                    while("".equals(pseudo) || heros == null);
                    try {
                        plateau.ajouterJoueur(new Joueur(pseudo, heros));
                    }
                    catch(HearthstoneException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;
                    }
                default:
                    System.out.println("+-------------------------------------------------------------------+");
                    System.out.println("|                         CHOIX NON RECONNU                         |");
                    System.out.println("+-------------------------------------------------------------------+");
                    break;
            }
        }
    }
    
    private static void StartGame() throws HearthstoneException {
        String input;
        Scanner scanIn = new Scanner(System.in);
        
        IPlateau plateau = Plateau.getPlateau();
        Output.printNewGameSummary();
        
        while (plateau.estDemaree()) {
            System.out.println("--------------------------------------------");
            Output.printOpponentStat();
            Output.printPlayerStat();
            System.out.println("--------------------------------------------");
            System.out.println("Tour de " + plateau.getJoueurCourant().getPseudo());
            System.out.println("--------------------------------------------");
            Output.printMenuAction();
            input = scanIn.nextLine();
            
            switch (input) {
                case "1":
                    Output.printHand();
                    break;
                case "2":
                    Output.printBoard();
                    break;
                case "3": {
                    Output.printMenuAttack();
                    input = scanIn.nextLine();
                    ICarte carteSelect = plateau.getJoueurCourant().getCarteEnMain(input);
                    if (carteSelect == null) System.out.println("Carte non trouvée");
                    else if (carteSelect.getCapacite() != null && carteSelect.getCapacite() instanceof AttaqueCiblee) {
                        Output.printOpponentBoard();
                        System.out.println("Choisissez votre cible (0 pour le héros adverse)");
                        input = scanIn.nextLine();
                        try {
                            if ("0".equals(input)) plateau.getJoueurCourant().jouerCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                            else plateau.getJoueurCourant().jouerCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
                        }
                        catch (HearthstoneException e){
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                    else {
                        try {
                            plateau.getJoueurCourant().jouerCarte(carteSelect);
                        }
                        catch (HearthstoneException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                    break;
                }
                case "4":{
                    if (plateau.getJoueurCourant().getJeu().isEmpty()) System.out.println("Aucun servieur n'est sur le terrain.");
                    else {
                        Output.printCurrentBoard();
                        System.out.println("Quel serviteur va attaquer ? :");
                        input = scanIn.nextLine();
                        Serviteur carteSelect = (Serviteur) plateau.getJoueurCourant().getCarteEnJeu(input);
                        if (carteSelect == null) System.out.println("Erreur : Carte non trouvée");
                        Output.printOpponentBoard();
                        System.out.println("Choisissez votre cible (0 pour le héros adverse)");
                        input = scanIn.nextLine();
                        try {
                            if ("0".equals(input)) plateau.getJoueurCourant().utiliserCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                            else plateau.getJoueurCourant().utiliserCarte(carteSelect, plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
                        }
                        catch (HearthstoneException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                    break;
                }
                case "5":
                    if (plateau.getJoueurCourant().getHeros().getPouvoir() instanceof AttaqueCiblee) {
                        Output.printOpponentBoard();
                        System.out.println("Choisissez votre cible (0 pour le héros adverse)");
                        input = scanIn.nextLine();
                        try {
                            if ("0".equals(input)) plateau.getJoueurCourant().utiliserPouvoir(plateau.getAdversaire(plateau.getJoueurCourant()).getHeros());
                            else plateau.getJoueurCourant().utiliserPouvoir(plateau.getAdversaire(plateau.getJoueurCourant()).getCarteEnJeu(input));
                        }
                        catch (HearthstoneException e){
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                    else {
                        try {
                            plateau.getJoueurCourant().utiliserPouvoir(plateau.getJoueurCourant());
                        }
                        catch (HearthstoneException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
                    }
                    break;
                case "0":
                    plateau.finTour(plateau.getJoueurCourant());
                    break;
                default:
                    break;
            }
        }
    }
}
