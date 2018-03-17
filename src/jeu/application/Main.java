/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.application;

import java.util.Scanner;
import jeu.src.Heros;
import jeu.src.IPlateau;
import jeu.src.Joueur;
import jeu.src.Plateau;
import jeu.src.exception.HearthstoneException;

/**
 *
 * @author bagnato2u
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creation des 2 adversaires
        //Joueur j1 = new Joueur("John Cena", Heros.getHeros("Jaina"));
        //Joueur j2 = new Joueur("BeastMaster64", Heros.getHeros("Rexxar"));
        
        //Pseudo deck lul
        //j1.getDeck().add(new Serviteur("Gay Lord", 1, j1, new Provocation(), 7, 7));
        //j2.getDeck().add(new Serviteur("Pink Guy", 1, j2, null, 7, 7));
        
        //Etablissement du plateau
        //IPlateau plateau = Plateau.getPlateau();
        //plateau.ajouterJoueur(j1);
        //plateau.ajouterJoueur(j2);
        
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
            System.out.println("1. J'ai envie de casser des culs");
            System.out.println("2. Ajouter un nouveau noob dans la partie");
            System.out.println("0. Je vais retourner bosser");
            System.out.println("-------------------------------------------");
            System.out.println("Choix : ");
            input = scanIn.nextLine();
            
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    try {
                        plateau.demarrerPartie();
                    }
                    catch (HearthstoneException e){
                        System.out.println("Erreur : " + e);
                    }
                    break;
                case "2": {
                    String pseudo = "";
                    Heros heros = null;
                    do {
                        System.out.println("C'est quoi ton petit nom de tapète :");
                        pseudo = scanIn.nextLine();
                        System.out.println("Et quel héros devra te subir pendant une partie :");
                        heros = Heros.getHeros(scanIn.nextLine());
                    }
                    while("".equals(pseudo) || heros == null);
                    try {
                        plateau.ajouterJoueur(new Joueur(pseudo, heros));
                    }
                    catch(HearthstoneException e) {
                        System.out.println("Erreur : " + e);
                    }
                    //System.out.println("[DEBUG] Player " + pseudo + " (" + heros.getNom() + ") added to the game.");
                    }
                    break;
                default:
                    System.out.println("+-------------------------------------------------------------------+");
                    System.out.println("| Wow on atteint des niveaux de gogolisme jamais atteint auparavent |");
                    System.out.println("+-------------------------------------------------------------------+");
                    break;
            }
        }
        
        
    }
}
