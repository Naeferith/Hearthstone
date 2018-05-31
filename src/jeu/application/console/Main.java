package jeu.application.console;

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
<<<<<<< HEAD
        //Etablissement du plateau
        //IPlateau plateau = Plateau.getPlateau();
        
        //Creation des 2 adversaires
        //try {
        //    Joueur j1 = new Joueur("John Cena", Heros.getHeros("Jaina"));
        //    Joueur j2 = new Joueur("BeastMaster64", Heros.getHeros("Rexxar"));
        //    plateau.ajouterJoueur(j1);
        //    plateau.ajouterJoueur(j2);
        //}
        //catch (HearthstoneException e) {
            
        //}
        
        //Commencer la partie
        //plateau.demarrerPartie();
        //----------------------------------------------------------------------------------------- ^_Static_^
        // ---------------------------------------------------------------------------------------- v_Dynamic_v
<<<<<<< HEAD:src/jeu/application/Main.java
        String input;
        Scanner scanIn = new Scanner(System.in);
        
        //IPlateau plateau = Plateau.getPlateau();
        
        while (true) {
            System.out.println("> Bienvenue dans Hearstone (c'est pas exactement comme Hearthstone mais on en est pas loin)");
            System.out.println("-------------------------------------------");
            System.out.println("1. J'ai envie de casser des culs");
            System.out.println("2. Ajouter un nouveau noob dans la partie");
            System.out.println("0. Je vais retourner bosser");
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
                        System.out.print("Et quel héros devra te subir pendant une partie : ");
                        try {
                            heros = Heros.getHeros(scanIn.nextLine());
                        }
                        catch (HearthstoneException e) {
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
                    System.out.println("| Wow on atteint des niveaux de gogolisme jamais atteint auparavent |");
                    System.out.println("+-------------------------------------------------------------------+");
                    break;
=======
=======
        
        //IPlateau plateau = Plateau.getPlateau();


>>>>>>> cfcaf9066c8276ba9a9df9d5e8715ac9b5e60902:src/jeu/application/console/Main.java
        //Init main menu
        DialogInterface ihm = Output.initMainMenu();
        
        while(true) {
            String choix = Output.printMenu(ihm);
            try {
                ihm.interact(choix);
>>>>>>> Alpha
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