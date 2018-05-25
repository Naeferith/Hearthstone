package jeu.application;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.application.console.ouput.DialogInterface;
import jeu.application.console.ouput.InterfaceAddPlayer;
import jeu.application.console.ouput.InterfacePlay;
import jeu.application.console.ouput.InterfaceQuit;
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

        //Init main menu
        DialogInterface ihm = Output.initMainMenu();
        
        while(true) {
            String choix = Output.printMenu(ihm);
            try {
                ihm.interact(choix);
            }
            catch (HearthstoneException e) { System.out.println("Erreur :" + e); }
            catch (NumberFormatException e) { System.out.println("Entrée inconnue");}
        }
    }
    
    public static void StartGame() throws HearthstoneException {
        DialogInterface ihm = Output.initGameMenu();
        Output.printNewGameSummary();
        while (Plateau.getPlateau().estDemaree()) {
            String choix = Output.printMenu(ihm);
            try {
                ihm.interact(choix);
            }
            catch (HearthstoneException e) { System.out.println("Erreur :" + e); }
            catch (NumberFormatException e) { System.out.println("Entrée inconnue");}
        }
    }
}
