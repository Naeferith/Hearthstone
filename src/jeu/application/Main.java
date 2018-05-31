package jeu.application;

import jeu.application.console.ouput.DialogInterface;
import jeu.application.console.ouput.Output;
import jeu.src.Plateau;
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